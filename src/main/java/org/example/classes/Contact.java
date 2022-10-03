package org.example.classes;

import org.example.Main;
import org.example.enums.Status;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Contact {

    private String contactId;
    private Status industry;
    private int employeeCount;
    private String country;
    private String city;

    public Contact(String contactId, Status industry, int employeeCount, String country, String city) {
        this.contactId = contactId;
        this.industry = industry;
        this.employeeCount = employeeCount;
        this.country = country;
        this.city = city;
    }

    public String getContactId() {
        return contactId;
    }

    public void setContactId(String contactId) {
        this.contactId = contactId;
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

    static List<Contact> contactList = new ArrayList<>();
    public static void ContactList() {
        Contact contact = null;
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter Contact Id : ");
        contact.setContactId(input.nextLine());
        System.out.println("Please enter City : ");
        contact.setCity(input.nextLine());
        System.out.println("Please enter Country : ");
        contact.setCountry(input.nextLine());
        System.out.println("Please enter Industry : ");
        contact.setIndustry(Status.valueOf(input.nextLine()));
        contactList.add(contact);
    }
    /*void displayContact(){
        System.out.println("Contact ID:" + contactId);
        System.out.println("City:" + city);
        System.out.println("Country:" + country);
    }*/
}
