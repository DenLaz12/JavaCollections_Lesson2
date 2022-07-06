package com.dlazarenko;

import java.util.*;

public class UniqueContact {

    public static void main(String[] args) {

        List<Contact> contacts = new LinkedList<>();
        contacts.add(new Contact("Mother", "+38"));
        contacts.add(new Contact("Father", "+48"));
        contacts.add(new Contact("Grandmother", "+1"));
        contacts.add(new Contact("Grandfather", "+7"));
        contacts.add(new Contact("Father", "+48"));
        contacts.add(new Contact("Grandmother", "+1"));

        System.out.println("All items count : " + contacts.size());

        Set<Contact> uniqueContacts = new HashSet<>(contacts);
        System.out.println("Unique items count : " + uniqueContacts.size());
    }
}
