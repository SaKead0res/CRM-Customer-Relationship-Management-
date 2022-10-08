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
    public static int idOp;
    private String name;
    private String phoneNumber;
    private String emailAddress;
    private String companyName;

    public static List<Lead> leadList = new ArrayList<>(); // Los ID's no funcionan. Siempre son 0

    public Lead (String name, String phoneNumber, String emailAddress, String companyName) {

        setId(id);
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.companyName = companyName;


    }

    public Lead() {
        setId(id);
    }
    public void setId(int id) {
        this.id = leadList.size();
    }


    public int getId() {
        return id;
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

    public static Lead addLead() throws InterruptedException {

        Scanner input = new Scanner(System.in);
        Lead lead = new Lead();//Añadido junto con el constructor vacio porque sino lanzaba un error.
        System.out.print("- Introduce a Name: ");
        lead.setName(input.nextLine());
        System.out.print("- Introduce a Phone Number: ");
        lead.setPhoneNumber(input.nextLine());
        System.out.print("- Introduce an Email: ");
        lead.setEmailAddress(input.nextLine());
        System.out.print("- Introduce a Company Name: ");
        lead.setCompanyName(input.nextLine());

        leadList.add(lead);

        System.out.println("\nThe new " + (char)27 + "[33m" + "LEAD" + (char)27 + "[0m" + " is created correctly.");
        System.out.println("Lead { Id: " + lead.id + " | Name: " + lead.name + " | Phone: " + lead.phoneNumber +
                " | Email: " + lead.emailAddress + " | Company Name: " + lead.companyName + " }\n");

        navigate();
        return lead;
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

    public static Lead convert() throws InterruptedException {

//        Integer idOp = null;

        Scanner input = new Scanner(System.in);
        System.out.print("- Introduce the " + (char)27 + "[33m" + "LEAD" + (char)27 + "[0m" + " Id to convert:");

        try {
            idOp = (Integer.parseInt(input.nextLine()));//esta funcion intenta dar a la variable command el valor de una String(input())
//                                                  pero como es de clase Enum solo cogera el valor en caso de que exista en la
//                                                  clase Enum Commands.

        } catch ( IllegalArgumentException e ) {
            System.err.println( "Wrong ID format." );
            TimeUnit.MILLISECONDS.sleep(1000);
            convert();
        }


//        Opportunity.setDecisionMaker(Lead.leadList.get(idOp));
        return leadList.get(idOp);
    }


}
