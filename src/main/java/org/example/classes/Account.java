package org.example.classes;

import org.example.enums.Industries;
import org.example.enums.Product;
import org.example.enums.Status;

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

    List<Contact> accountContactList;// Los ID's no funcionan. Siempre son 0
    List<Opportunity> accountOpportunityList;// Los ID's no funcionan. Siempre son 0
    static List<Account> accountList = new ArrayList<>(); // Los ID's no funcionan. Siempre son 0

    public Account(Industries industry, int employeeCount, String city, String country) {
        setAccountId(id);
        this.industry = industry;
        this.employeeCount = employeeCount;
        this.city = city;
        this.country = country;

    }

    public Account() {
        setAccountId(id);
    }

    public int getId() {
        return id;
    }
    public void setAccountId(int accountId) {
        this.id = accountList.size();
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


    public static void addAccount(Opportunity opportunity) throws InterruptedException {



        Account account = new Account();

        List<Contact> accountContactList = new ArrayList<>();
        List<Opportunity> accountOpportunityList = new ArrayList<>();

        opportunity.setId(accountOpportunityList.size());

        Scanner input = new Scanner(System.in);
        System.out.print("- Please enter Industry : ");

        Industries industry = null;

        try {
            industry = Industries.valueOf( input.nextLine().toUpperCase() );

        } catch ( IllegalArgumentException e ) {
            System.err.println( "This industry doesn't exists." );
            TimeUnit.MILLISECONDS.sleep(1000);
            addAccount(opportunity);
        }

        account.setIndustry(industry);
        System.out.print("- Please enter your Number of Employees : ");

        Integer numberOfEmployees = -1;

        try {
            numberOfEmployees = Integer.parseInt( input.nextLine() );

        } catch ( IllegalArgumentException e ) {
            System.err.println( "Wrong Number of Employees format." );
            TimeUnit.MILLISECONDS.sleep(1000);
            addAccount(opportunity);
        }

        account.setEmployeeCount(numberOfEmployees);
        System.out.print("- Please enter City : ");

        try {
            account.setCity(input.nextLine());

        }catch (Exception e){
            System.err.println("Wrong City format.");
            TimeUnit.MILLISECONDS.sleep(1000);
            addAccount(opportunity);
        }

        System.out.print("- Please enter Country : ");
        try{

            account.setCountry(input.nextLine());
        }catch (Exception e){
            System.err.println("Wrong City format.");
            TimeUnit.MILLISECONDS.sleep(1000);
            addAccount(opportunity);
        }

        System.out.println("\nThe new " + (char)27 + "[33m" + "ACCOUNT" + (char)27 + "[0m" + " is created correctly.");
        System.out.println("ACCOUNT {ID: " + account.getId() + " | Company: " +
                opportunity.getDecisionMaker().getCompanyName() + " | Industry: " + account.getIndustry() +
                " | Nº Employees: " + account.getEmployeeCount() + " | City: " +
                account.getCity() + " | Country: " + account.getCountry() + " }");

        accountContactList.add(opportunity.getDecisionMaker());

        accountOpportunityList.add(opportunity);

        System.out.println("\nCONTACTS OF THE ACCOUNT\n===================");
        for (Contact contact : accountContactList){
            System.out.println("Contact {"  /*ID: " + contact.getId()  |/  */ + " Name: " + contact.getName() + " | Phone: "
                    + contact.getPhoneNumber() + " | Email: " + contact.getEmailAddress() + " }");
            System.out.println("====================");
        }

        System.out.println("\nOPPORTUNITIES OF THE ACCOUNT\n===================");
        for (Opportunity o : accountOpportunityList) {
            System.out.println("Opportunity { "  /*ID: " + o.getId() +  | */ + " Status: " + o.getStatus() +
                    " | Decision Maker: " + o.getDecisionMaker().getName() + " | Interested Product: " + o.getProduct() +
                    " | Interested Units: " + o.getQuantity() + " }\n");
            System.out.println("====================");
        }


        Account.accountList.add(account);


    }

    public static void showAccounts() throws InterruptedException {

        System.out.println("\nACCOUNT LIST\n===================");
        for (Account account : accountList){
            System.out.println("Account {ID: " + Account.accountList.indexOf(account) + " | Company: " +
                    /*account.accountContactList.get(0).getCompanyName() +*/ " | Industry: " + account.getIndustry() +
                    " | Nº Employees: " + account.getEmployeeCount() + " | City: " +
                    account.getCity() + " | Country: " + account.getCountry() + " }");
            System.out.println("====================");
        }
        System.out.println("END OF LIST\n");
        navigate();
    }


    // Este ultimo metodo peta lo sabemos, pero no se pide.
    public static void lookupAccount() throws InterruptedException {

        Account account = null;
        Scanner input = new Scanner(System.in);
        System.out.print("- Introduce the " + (char)27 + "[33m" + "ACCOUNT" + (char)27 + "[0m" + " Id to LOOK: ");


        try {
            account = accountList.get(input.nextInt());
            //SE pueden agrupar todos los try catch del mismo tipo en metodos?
        } catch (Exception e){
            System.err.println("Wrong ID format.");
            lookupAccount();
        }

        System.out.println("Account {ID: " + Account.accountList.indexOf(account) + /*" | Company: " +
                account.accountContactList.get(0).getCompanyName() +*/ " | Industry: " + account.getIndustry() +
                " | Nº Employees: " + account.getEmployeeCount() + " | City: " +
                account.getCity() + " | Country: " + account.getCountry() + " }\n");

        System.out.println("\nCONTACTS OF THE ACCOUNT\n===================");
        for (Contact contact : account.accountContactList){
            System.out.println("Contact {" /* " + contact.getId() + " |*/ + " Name: " + contact.getName() + " | Phone: " +
                    contact.getPhoneNumber() + " | Email: " + contact.getEmailAddress() + " | Company Name: " +
                    contact.getCompanyName() + " }");
            System.out.println("====================");
        }

        System.out.println("\nOPPORTUNITIES OF THE ACCOUNT\n===================");
        for (Opportunity opportunity : account.accountOpportunityList) {
            System.out.println("Opportunity {" /*ID: " + opportunity.getId() + " |*/ + " Status: " + opportunity.getStatus() +
                    " | Decision Maker: " + opportunity.getDecisionMaker().getName() + " | Interested Product: " + opportunity.getProduct() +
                    " | Interested Units: " + opportunity.getQuantity() + " }\n");
            System.out.println("====================");
        }
        navigate();
    }

}