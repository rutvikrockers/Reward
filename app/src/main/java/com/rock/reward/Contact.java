package com.rock.reward;

import java.util.ArrayList;
import java.util.List;

public class Contact {
    private String mName;
    private boolean mOnline;

    public Contact(String name, boolean online) {
        mName = name;
        mOnline = online;
    }

    public String getName() {
        return mName;
    }

    public boolean isOnline() {
        return mOnline;
    }

    private static int lastContactId = 0;

    public static List<Contact> createContactsList(int numContacts, int offset) {
        List<Contact> contacts = new ArrayList<Contact>();

        for (int i = 1; i <= numContacts; i++) {
            contacts.add(new Contact("Person " + ++lastContactId + " offset: " + offset, i <= numContacts / 2));
        }

        return contacts;
    }
}