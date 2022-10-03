package org.example.classes;

import org.example.Enums.Status;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Contact extends Lead {

    private int contactId;
    private Status industry;
    private int employeeCount;
    private String country;
    private String city;

   //private static List<Contact> contactList;
    static List<Contact> contactList = new ArrayList<>();

    public Contact(String name, String phoneNumber, String emailAddress, String companyName, int contactId, Status industry, int employeeCount, String country, String city) {
        super(name, phoneNumber, emailAddress, companyName);
        this.contactId = contactId;
        this.industry = industry;
        this.employeeCount = employeeCount;
        this.country = country;
        this.city = city;
    }
    public int getContactId(String s) {
        return contactId;
    }
    public void setContactId(int contactId) {
        this.contactId = contactList.size();
    }

    public Status getIndustry() {
        return industry;
    }

    public void setIndustry(Status industry) {
        this.industry = industry;
    }

    public int getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public static List<Contact> getContactList() {
        return contactList;
    }

    public static void setContactList(List<Contact> contactList) {
        Contact.contactList = contactList;
    }



    public static void ContactList() {
        Contact contact = null;
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter Contact Id : ");
        contact.getContactId(input.nextLine());
        System.out.println("Please enter City : ");
        contact.setCity(input.nextLine());
        System.out.println("Please enter Country : ");
        contact.setCountry(input.nextLine());
        System.out.println("Please enter Industry : ");
        contact.setIndustry(Status.valueOf(input.nextLine()));
        contactList.add(contact);
    }
}
    /*void displayContact(){
        System.out.println("Contact ID:" + contactId);
        System.out.println("City:" + city);
        System.out.println("Country:" + country);
    }*/



