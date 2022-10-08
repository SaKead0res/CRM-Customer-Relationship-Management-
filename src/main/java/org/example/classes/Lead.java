package org.example.classes;

import org.example.enums.Status;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import static org.example.classes.Navigate.input;
import static org.example.classes.Navigate.navigate;

public class Lead {

    private int id;
    private String name;
    private String phoneNumber;
    private String emailAddress;
    private String companyName;

    public static List<Lead> leadList = new ArrayList<>(); // Los ID's no funcionan. Siempre son 0


    public static Lead addLead() throws InterruptedException {
        Lead lead = new Lead();//Añadido junto con el constructor vacio porque sino lanzaba un error.

        System.out.print("- Introduce a Name: ");
        lead.setName(Navigate.input());
        System.out.print("- Introduce a Phone Number: ");
        lead.setPhoneNumber(Navigate.input());
        System.out.print("- Introduce an Email: ");
        lead.setEmailAddress(Navigate.input());
        System.out.print("- Introduce a Company Name: ");
        lead.setCompanyName(Navigate.input());

        leadList.add(lead);
        System.out.println("\nThe new " + (char)27 + "[33m" + "LEAD" + (char)27 + "[0m" + " is created correctly.");
        System.out.println("Lead { Id: " + lead.id + " | Name: " + lead.name + " | Phone: " + lead.phoneNumber +
                " | Email: " + lead.emailAddress + " | Company Name: " + lead.companyName + " }\n");
//        navigate();
        return lead;
    }

    public static void showLeads(){
        System.out.println("\nLEAD LIST\n===================");
        for (Lead lead : leadList){
            System.out.println("Lead { " + Lead.leadList.indexOf(lead) + " | Name: " + lead.name + " | Phone: " + lead.phoneNumber +
                    " | Email: " + lead.emailAddress + " | Company Name: " + lead.companyName + " }");
            System.out.println("====================");
        }
        System.out.println("END OF LIST\n");
    }

    public static void lookupLead() throws InterruptedException {

        Scanner input = new Scanner(System.in);

        System.out.print("- Introduce the " + (char)27 + "[33m" + "LEAD" + (char)27 + "[0m" + " Id to LOOK: ");

        Lead lead = null;

        try {
            lead = leadList.get(input.nextInt());

        } catch (IllegalArgumentException e){
            System.err.println("Wrong ID format.");
            TimeUnit.MILLISECONDS.sleep(1000);
            lookupLead();
        }

        System.out.println("Lead{ Id: " + Lead.leadList.indexOf(lead) + " | Name: " + lead.name + " | Phone: " + lead.phoneNumber +
                " | Email: " + lead.emailAddress + " | Company Name: " + lead.companyName + " }\n");
        navigate();
    }

    public static void convert() throws InterruptedException {
//SE PUEDE AHORRAR UN METODO
        Account.addAccount(Opportunity.addOpportunity());
        Lead.leadList.remove(Lead.leadList.get(Opportunity.inputId));
        navigate();

    }

    public Lead(String name, String phoneNumber, String emailAddress, String companyName) {
        setId(id);
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.companyName = companyName;
    }

    public Lead() {
        setId(id);
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
