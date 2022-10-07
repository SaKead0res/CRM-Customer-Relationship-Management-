package org.example.classes;

import org.example.enums.Status;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.example.classes.Navigate.input;
import static org.example.classes.Navigate.navigate;

public class Lead {

    private int id;
    private String name;
    private String phoneNumber;
    private String emailAddress;
    private String companyName;

    public static List<Lead> leadList = new ArrayList<>(); // Los ID's no funcionan. Siempre son 0


    public static void addLead() throws InterruptedException {
        Lead lead = new Lead();//Añadido junto con el constructor vacio porque sino lanzaba un error.

        System.out.print("- Introduce a Name: ");
        lead.setName(Navigate.input());
        System.out.print("- Introduce a Phone Number: ");
        lead.setPhoneNumber(Navigate.input());
        System.out.print("- Introduce an Email: ");
        lead.setEmailAddress(Navigate.input());
        System.out.print("- Introduce a Company Name: ");
        lead.setCompanyName(Navigate.input());
        lead.setId(leadList.size());

        leadList.add(lead);
        System.out.println("\nThe new " + (char)27 + "[33m" + "LEAD" + (char)27 + "[0m" + " is created correctly.");
        System.out.println("Lead { Id: " + lead.id + " | Name: " + lead.name + " | Phone: " + lead.phoneNumber +
                " | Email: " + lead.emailAddress + " | Company Name: " + lead.companyName + " }\n");
        navigate();
    }

    public static void showLeads(){
        System.out.println("\nLEAD LIST\n===================");
        for (Lead lead : leadList){
            System.out.println("Lead { " + lead.id + " | Name: " + lead.name + " | Phone: " + lead.phoneNumber +
                    " | Email: " + lead.emailAddress + " | Company Name: " + lead.companyName + " }");
            System.out.println("====================");
        }
        System.out.println("END OF LIST\n");
    }

    public static void lookupLead() throws InterruptedException {

        Lead lead = new Lead();
        Scanner input = new Scanner(System.in);
        System.out.print("- Introduce the " + (char)27 + "[33m" + "LEAD" + (char)27 + "[0m" + " Id to LOOK: ");
        leadList.get(input.nextInt());
        System.out.println("Lead{ Id: " + lead.id + " | Name: " + lead.name + " | Phone: " + lead.phoneNumber +
                " | Email: " + lead.emailAddress + " | Company Name: " + lead.companyName + " }\n");
        navigate();
    }

    public static void convert() throws InterruptedException {

        Opportunity.addOpportunity();

    }

    public Lead(String name, String phoneNumber, String emailAddress, String companyName) {
        setId(getId());
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.companyName = companyName;
    }

    public Lead() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = leadList.size();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
