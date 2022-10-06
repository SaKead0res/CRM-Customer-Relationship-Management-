package org.example.classes;

public class Contact extends Lead {
    public Contact (String name, String phoneNumber, String emailAddress, String companyName) {
        super(name, phoneNumber, emailAddress, companyName);
    }

    public Contact (Contact contact) {
    }

    public Contact() {

    }


    public static Contact createContact(Lead lead) {

        Contact contact = new Contact();

        contact.setName(lead.getName());
        contact.setPhoneNumber(lead.getPhoneNumber());
        contact.setEmailAddress(lead.getEmailAddress());
        contact.setCompanyName(lead.getCompanyName());
        Lead.leadList.remove(lead.getId());
        Account.accountContactList.add(contact);

        return contact;
    }
}