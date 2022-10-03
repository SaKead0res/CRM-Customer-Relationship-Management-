package org.example.classes;

import java.util.ArrayList;
import java.util.List;

public class Contact extends Lead {

    private int contactId;
    private static List<Contact> contactList;


    public Contact(String name, String phoneNumber, String emailAddress, String companyName, int contactId) {
        super(name, phoneNumber, emailAddress, companyName);
        setContactId(contactId);
    }

    public int getContactId() {
        return contactId;
    }
    public void setContactId(int contactId) {
        this.contactId = contactList.size();
    }
}
