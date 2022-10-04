package org.example.classes;

import org.example.Enums.Status;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Contact extends Lead {

    private int contactId;
   /* private Status industry;
    private int employeeCount;
    private String country;
    private String city;*/

   //private static List<Contact> contactList;
    static List<Contact> contactList = new ArrayList<>();

    public Contact(String name, String phoneNumber, String emailAddress, String companyName, int contactId) {
        super(name, phoneNumber, emailAddress, companyName);
        setContactId(contactId);
       /* this.industry = industry;
        this.employeeCount = employeeCount;
        this.country = country;
        this.city = city;*/
    }
    public int getContactId(String s) {
        return contactId;
    }
    public void setContactId(int contactId) {
        this.contactId = contactList.size();
    }


//name, phoneNumber, emailAddress, companyName)
    public static void ContactList(Lead lead) {
        Contact contact = null;
        contact.setName(lead.getName());
        contact.setPhoneNumber(lead.getPhoneNumber());
        contact.setEmailAddress(lead.getEmailAddress());
        contact.setCompanyName(lead.getCompanyName());

       /* Scanner input = new Scanner(System.in);
        System.out.println("Please enter Industry : ");
        contact.setIndustry(Status.valueOf(input.nextLine()));
        System.out.println("Please enter your number of employees : ");
        contact.setEmployeeCount(Integer.parseInt(input.nextLine()));
        System.out.println("Please enter City : ");
        contact.setCity(input.nextLine());
        System.out.println("Please enter Country : ");
        contact.setCountry(input.nextLine());*/
        contactList.add(contact);

    }
}




