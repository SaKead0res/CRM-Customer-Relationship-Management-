package org.example.classes;

public abstract class Contact extends Lead {

    private int contactId;
    public Contact(String name, String phoneNumber, String emailAddress, String companyName, int contactId) {
        super(name, phoneNumber, emailAddress, companyName);
        setContactId(contactId);
    }
    public int getContactId(String s) {
        return contactId;
    }
    public void setContactId(int contactId) {
        this.contactId = contactId;
    }


    public static Contact createContact(Lead lead) {
        Contact contact = null;
        contact.setName(lead.getName());
        contact.setPhoneNumber(lead.getPhoneNumber());
        contact.setEmailAddress(lead.getEmailAddress());
        contact.setCompanyName(lead.getCompanyName());

        return contact;

    }
}




