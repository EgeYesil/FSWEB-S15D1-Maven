package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Grocery {

    public static ArrayList<String> groceryList = new ArrayList<>();

    public static void startGrocery() {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("""
                    İşlem seçiniz:
                    0 - Çıkış
                    1 - Eleman ekle
                    2 - Eleman çıkar
                    """);

            String option = scanner.nextLine();

            switch (option) {
                case "0":
                    isRunning = false;
                    break;

                case "1":
                    System.out.println(
                            "Eklenmesini istediğiniz elemanları giriniz."
                    );
                    addItems(scanner.nextLine());
                    printSorted();
                    break;

                case "2":
                    System.out.println(
                            "Cıkarılmasını istediğiniz elemanları giriniz."
                    );
                    removeItems(scanner.nextLine());
                    printSorted();
                    break;

                default:
                    System.out.println("Geçersiz işlem.");
            }
        }
    }

    public static void addItems(String input) {
        String[] products = input.split(",");

        for (String product : products) {
            String trimmedProduct = product.trim();

            if (!trimmedProduct.isEmpty()
                    && !checkItemIsInList(trimmedProduct)) {
                groceryList.add(trimmedProduct);
            }
        }

        Collections.sort(groceryList);
    }

    public static void removeItems(String input) {
        String[] products = input.split(",");

        for (String product : products) {
            String trimmedProduct = product.trim();

            if (checkItemIsInList(trimmedProduct)) {
                groceryList.remove(trimmedProduct);
            }
        }

        Collections.sort(groceryList);
    }

    public static boolean checkItemIsInList(String product) {
        return groceryList.contains(product);
    }

    public static void printSorted() {
        Collections.sort(groceryList);

        System.out.println("Grocery List:");

        for (int i = 0; i < groceryList.size(); i++) {
            System.out.println((i + 1) + ". " + groceryList.get(i));
        }
    }
}