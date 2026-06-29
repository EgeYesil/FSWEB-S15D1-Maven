package org.example.mobile;

import java.util.ArrayList;
import java.util.List;

public class MobilePhone {

    private String myNumber;
    private ArrayList<Contact> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<>();
    }

    public MobilePhone(
            String myNumber,
            List<Contact> myContacts
    ) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<>(myContacts);
    }

    public String getMyNumber() {
        return myNumber;
    }

    public ArrayList<Contact> getMyContacts() {
        return myContacts;
    }

    public boolean addNewContact(Contact contact) {
        if (findContact(contact) >= 0) {
            return false;
        }

        myContacts.add(contact);
        return true;
    }

    public boolean updateContact(
            Contact oldContact,
            Contact newContact
    ) {
        int position = findContact(oldContact);

        if (position < 0) {
            return false;
        }

        myContacts.set(position, newContact);
        return true;
    }

    public boolean removeContact(Contact contact) {
        int position = findContact(contact);

        if (position < 0) {
            return false;
        }

        myContacts.remove(position);
        return true;
    }

    public int findContact(Contact contact) {
        return myContacts.indexOf(contact);
    }

    public int findContact(String contactName) {
        for (int i = 0; i < myContacts.size(); i++) {
            Contact contact = myContacts.get(i);

            if (contact.getName().equals(contactName)) {
                return i;
            }
        }

        return -1;
    }

    public Contact queryContact(String contactName) {
        int position = findContact(contactName);

        if (position < 0) {
            return null;
        }

        return myContacts.get(position);
    }

    public void printContact() {
        System.out.println("Contact List:");

        for (int i = 0; i < myContacts.size(); i++) {
            Contact contact = myContacts.get(i);

            System.out.println(
                    (i + 1)
                            + ". "
                            + contact.getName()
                            + " -> "
                            + contact.getPhoneNumber()
            );
        }
    }
}