package org.example.classes;

import java.util.ArrayList;
import java.util.List;

import static org.example.Classes.Navigate.navigate;

public class Lead {

    private int id;
    private String name;
    private String phoneNumber;
    private String emailAddress;
    private String companyName;

    static List<Lead> leadList = new ArrayList<>();//Lo mismo que en el comentario de abajo

    public static void addLead(){
        Lead lead = new Lead();//Añadido junto con el constructor vacio porque sino lanzaba un error.
        System.out.println("Introduce a name:");
        lead.setName(org.example.Classes.Navigate.input());
        System.out.println("Introduce a phone number:");
        lead.setPhoneNumber(org.example.Classes.Navigate.input());
        System.out.println("Introduce an email address:");
        lead.setEmailAddress(org.example.Classes.Navigate.input());
        System.out.println("Introduce a company name:");
        lead.setCompanyName(org.example.Classes.Navigate.input());

        leadList.add(lead);
        navigate();
    }

    public static void showLeads(){
        for (Lead lead : leadList){
            System.out.println("ID: " + lead.getId() + "\n"
                    + "NAME: " + lead.getName());
            System.out.println("====================");
        }
    }

    public static void lookupLead(){

    }

    public static void convert(){

    }

    public static void closeWon(){

    }

    public static void closeLost(){

    }




    public Lead(String name, String phoneNumber, String emailAddress, String companyName) {
        setId(id);
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
