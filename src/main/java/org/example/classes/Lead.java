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

    public static List<Lead> leadList = new ArrayList<>();//Lo mismo que en el comentario de abajo


    public static void addLead(){
        Lead lead = new Lead();//Añadido junto con el constructor vacio porque sino lanzaba un error.

        System.out.println("Introduce a name:");
        lead.setName(Navigate.input());
        System.out.println("Introduce a phone number:");
        lead.setPhoneNumber(Navigate.input());
        System.out.println("Introduce an email address:");
        lead.setEmailAddress(Navigate.input());
        System.out.println("Introduce a company name:");
        lead.setCompanyName(Navigate.input());

        leadList.add(lead);
        System.out.println("\nThe new Lead is created correctly.");
        System.out.println("Lead{ Id: " + lead.id + " | Name: " + lead.name + " | Phone Number: " + lead.phoneNumber +
                " | Email: " + lead.emailAddress + " | Company Name: " + lead.companyName + " }\n");
        navigate();
    }

    public static void showLeads(){
        System.out.println("\nLEAD LIST\n===================");
        for (Lead lead : leadList){
            System.out.println("Lead { " + lead.id + " | Name: " + lead.name + " | Phone Number: " + lead.phoneNumber +
                    " | Email: " + lead.emailAddress + " | Company Name: " + lead.companyName + " }");
            System.out.println("====================");
        }
        System.out.println("END OF LIST\n");
    }

    public static void lookupLead(){

        Lead lead = new Lead();
        Scanner input = new Scanner(System.in);
        leadList.get(input.nextInt());
        System.out.println("Lead{ Id: " + lead.id + " | Name: " + lead.name + " | Phone Number: " + lead.phoneNumber +
                " | Email: " + lead.emailAddress + " | Company Name: " + lead.companyName + " }\n");
        navigate();
    }

    public static void convert(){

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
