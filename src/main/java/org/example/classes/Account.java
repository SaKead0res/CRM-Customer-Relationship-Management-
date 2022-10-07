
package org.example.classes;

import org.example.enums.Industries;
import org.example.enums.Product;
import org.example.enums.Status;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.example.classes.Navigate.navigate;

public class Account {

    private int id;
    private Industries industry;
    private int employeeCount;
    private String city;
    private String country;

    static List<Contact> accountContactList = new ArrayList<>(); // Los ID's no funcionan. Siempre son 0
    static List<Opportunity> accountOpportunityList = new ArrayList<>(); // Los ID's no funcionan. Siempre son 0
    static List<Account> accountList = new ArrayList<>(); // Los ID's no funcionan. Siempre son 0

    public Account(Industries industry, int employeeCount, String city, String country) {
        setAccountId(id);
        this.industry = industry;
        this.employeeCount = employeeCount;
        this.city = city;
        this.country = country;

    }

    public Account() {

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


    public static void addAccount() {

        Account account = new Account();

        /*try {
            opportunity = Commands.valueOf( input() );//esta funcion intenta dar a la variable command el valor de una String(input())
//                                                  pero como es de clase Enum solo cogera el valor en caso de que exista en la
//                                                  clase Enum Commands.
        } catch ( IllegalArgumentException e ) {
            System.err.println( "This command doesn't exists. Try again or type <help>." );
            navigate();
        }

        switch (command) {
            case NEWLEAD:
                Lead.addLead();
                break;
            case SHOWLEADS:
                Lead.showLeads();
                break;
            case LOOKUPLEAD:
                Lead.lookupLead();
                break;
            case CONVERT:
                Lead.convert();
                break;
            case CLOSED_WON:
                Lead.closeWon();
                break;
            case CLOSED_LOST:
                Lead.closeLost();
                break;
            case HELP:
                help();
                break;
            case EXIT:
                System.exit(0);
                break;
            default:
                break;
        }
        navigate();
        */

        Scanner input = new Scanner(System.in);
        System.out.print("- Please enter Industry : ");
        account.setIndustry(Industries.valueOf(input.nextLine()));
        System.out.print("- Please enter your Number of Employees : ");
        account.setEmployeeCount(Integer.parseInt(input.nextLine()));
        System.out.print("- Please enter City : ");
        account.setCity(input.nextLine());
        System.out.print("- Please enter Country : ");
        account.setCountry(input.nextLine());

        System.out.println("\nThe new " + (char)27 + "[33m" + "ACCOUNT" + (char)27 + "[0m" + " is created correctly.");
        System.out.println("ACCOUNT {ID: " + account.getId() + " | Company: " +
                accountContactList.get(0).getCompanyName() + " | Industry: " + account.getIndustry() +
                " | Nº Employees: " + account.getEmployeeCount() + " | City: " +
                account.getCity() + " | Country: " + account.getCountry() + " }");

        System.out.println("\nCONTACTS OF THE ACCOUNT\n===================");
        for (Contact contact : accountContactList){
            System.out.println("Contact { " + contact.getId() + " | Name: " + contact.getName() + " | Phone: " +
                        contact.getPhoneNumber() + " | Email: " + contact.getEmailAddress() + " }");
            System.out.println("====================");
            }

        System.out.println("\nOPPORTUNITIES OF THE ACCOUNT\n===================");
        for (Opportunity opportunity : accountOpportunityList) {
            System.out.println("Opportunity {ID: " + opportunity.getId() + " | Status: " + opportunity.getStatus() +
                    " | Decision Maker: " + opportunity.getDecisionMaker().getName() + " | Interested Product: " + opportunity.getProduct() +
                    " | Interested Units: " + opportunity.getQuantity() + " }\n");
            System.out.println("====================");
        }

        accountList.add(account);

        navigate();
}
    public static void lookupAccount() {

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
            System.out.println("Contact { " + contact.getId() + " | Name: " + contact.getName() + " | Phone: " +
                    contact.getPhoneNumber() + " | Email: " + contact.getEmailAddress() + " | Company Name: " +
                    contact.getCompanyName() + " }");
            System.out.println("====================");
        }

        System.out.println("\nOPPORTUNITIES OF THE ACCOUNT\n===================");
        for (Opportunity opportunity : accountOpportunityList) {
            System.out.println("Opportunity {ID: " + opportunity.getId() + " | Status: " + opportunity.getStatus() +
                    " | Decision Maker: " + opportunity.getDecisionMaker().getName() + " | Interested Product: " + opportunity.getProduct() +
                    " | Interested Units: " + opportunity.getQuantity() + " }\n");
            System.out.println("====================");
        }
        navigate();
    }

    public static void showAccounts(){

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


