package org.example.classes;

import org.example.enums.Industries;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import static org.example.classes.Navigate.navigate;

public class Account {

    private int id;
    private Industries industry;
    private int employeeCount;
    private String city;
    private String country;
    static List<Contact> accountContactList = new ArrayList<>();
    static List<Opportunity> accountOpportunityList = new ArrayList<>();

    static List<Account> accountList = new ArrayList<>(); // Los ID's no funcionan. Siempre son 0

    public Account(Industries industry, int employeeCount, String city, String country,
                   List<Contact> accountContactList, List<Opportunity> accountOpportunityList) {
        this.industry = industry;
        this.employeeCount = employeeCount;
        this.city = city;
        this.country = country;
        setId(id);
        this.accountContactList = accountContactList;
        this.accountOpportunityList = accountOpportunityList;

    }

    public Account() {
        setId(id);
        this.accountContactList = accountContactList;
        this.accountOpportunityList = accountOpportunityList;

    }

    public void setId(int id) {
        this.id = accountList.size();
    }

    public int getId() {
        return id;
    }
    public Industries getIndustry() {
        return industry;
    }
    public void setIndustry(Industries industry) {
        this.industry = industry;
    }
    public int getEmployeeCount() {
        return employeeCount;
    }
    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }

    public List<Contact> getAccountContactList() {
        return accountContactList;
    }

    public void setAccountContactList(List<Contact> accountContactList) {
        this.accountContactList = accountContactList;
    }

    public List<Opportunity> getAccountOpportunityList() {
        return accountOpportunityList;
    }

    public void setAccountOpportunityList(List<Opportunity> accountOpportunityList) {
        this.accountOpportunityList = accountOpportunityList;
    }

    public static void addAccount() throws InterruptedException {

        Account account = new Account();
        Opportunity opportunity = Opportunity.addOpportunity();
        accountOpportunityList.add(opportunity);
        Lead.convert();
        accountContactList.add(Contact.createContact(Lead.leadList.get(Lead.idOp)));


        Scanner input = new Scanner(System.in);
        System.out.print("- Please enter Industry : ");

        Industries industry = null;

        try {
            industry = Industries.valueOf( input.nextLine().toUpperCase() );//esta funcion intenta dar a la variable command el valor de una String(input())
//                                                  pero como es de clase Enum solo cogera el valor en caso de que exista en la
//                                                  clase Enum Commands.
        } catch ( IllegalArgumentException e ) {
            System.err.println( "This industry doesn't exists." );
            TimeUnit.MILLISECONDS.sleep(1000);
            addAccount();
        }

        account.setIndustry(industry);
        System.out.print("- Please enter your Number of Employees : ");

        int numberOfEmployees = -1;

        try {
            numberOfEmployees = Integer.parseInt( input.nextLine() );

        } catch ( IllegalArgumentException e ) {
            System.err.println( "Wrong Number of Employees format." );
            TimeUnit.MILLISECONDS.sleep(1000);
            addAccount();
        }

        account.setEmployeeCount(numberOfEmployees);
        System.out.print("- Please enter City : ");
        account.setCity(input.nextLine());
        System.out.print("- Please enter Country : ");
        account.setCountry(input.nextLine());
        accountList.add(account);

        System.out.println("\nThe new " + (char)27 + "[33m" + "ACCOUNT" + (char)27 + "[0m" + " is created correctly.");
        System.out.println("ACCOUNT {ID: " + account.getId() + " | Company: " +
                accountContactList.get(0).getCompanyName() + " | Industry: " + account.getIndustry() +
                " | Nº Employees: " + account.getEmployeeCount() + " | City: " +
                account.getCity() + " | Country: " + account.getCountry() + " }");

        System.out.println("\nCONTACTS OF THE ACCOUNT\n===================");
        for (Contact contact : accountContactList){
            System.out.println("Contact { " + accountContactList.indexOf(contact) + " | Name: " + contact.getName() + " | Phone: " +
                    contact.getPhoneNumber() + " | Email: " + contact.getEmailAddress() + " }");
            System.out.println("====================");
        }

        System.out.println("\nOPPORTUNITIES OF THE ACCOUNT\n===================");
        for (Opportunity opportunity1 : accountOpportunityList) {
            System.out.println("Opportunity {ID: " + opportunity1.getId() + " | Status: " + opportunity1.getStatus() +
                    " | Decision Maker: " + opportunity1.getDecisionMaker() + " | Interested Product: " + opportunity1.getProduct() +
                    " | Interested Units: " + opportunity1.getQuantity() + " }\n");
            System.out.println("====================");
        }

        Lead.leadList.remove(Lead.leadList.get(Lead.leadList.size() - 1));
        navigate();
    }
    public static void lookupAccount() throws InterruptedException {

        Account account = new Account();
        Scanner input = new Scanner(System.in);
        System.out.print("- Introduce the " + (char)27 + "[33m" + "ACCOUNT" + (char)27 + "[0m" + " Id to LOOK: ");
        accountList.get(input.nextInt());
        System.out.println("Account {ID: " + account.getId() + " | Company: " +
                accountContactList.get(0).getCompanyName() + " | Industry: " + account.getIndustry() +
                " | Nº Employees: " + account.getEmployeeCount() + " | City: " +
                account.getCity() + " | Country: " + account.getCountry() + " }\n");

        System.out.println("\nCONTACTS OF THE ACCOUNT\n===================");
        for (Contact contact : accountContactList){
            System.out.println("Name: " + contact.getName() + " | Phone: " +
                    contact.getPhoneNumber() + " | Email: " + contact.getEmailAddress() + " | Company Name: " +
                    contact.getCompanyName() + " }");
            System.out.println("====================");
        }

        System.out.println("\nOPPORTUNITIES OF THE ACCOUNT\n===================");
        for (Opportunity opportunity : accountOpportunityList) {
            System.out.println("Opportunity {ID: " + opportunity.getId() + " | Status: " + opportunity.getStatus() +
                    " | Decision Maker: " + opportunity.getDecisionMaker() + " | Interested Product: " + opportunity.getProduct() +
                    " | Interested Units: " + opportunity.getQuantity() + " }\n");
            System.out.println("====================");
        }
        navigate();
    }

    public static void showAccounts() throws InterruptedException {

        System.out.println("\nACCOUNT LIST\n===================");
        for (Account account : accountList){
            System.out.println("Account {ID: " + account.getId() + " | Company: " +
                    accountContactList.get(0).getCompanyName() + " | Industry: " + account.getIndustry() +
                    " | Nº Employees: " + account.getEmployeeCount() + " | City: " +
                    account.getCity() + " | Country: " + account.getCountry() + " }");
            System.out.println("====================");
        }
        System.out.println("END OF LIST\n");
        navigate();
    }
}