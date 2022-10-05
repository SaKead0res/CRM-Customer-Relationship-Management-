package org.example.classes;

import org.example.enums.Industries;
import org.example.classes.Opportunity;

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
    private List<Contact> contactList;
    private List<Opportunity> opportunityList;
    public static List<Account> accountList = new ArrayList<>();

    public static void lookupAccount() {

//        Account account = new Account();
//        Scanner input = new Scanner(System.in);
//        accountList.get(input.nextInt());
//        System.out.println("{ID: " + account.getId() + " | Status: " + account.getStatus() +
//                " | Decision Maker: " + account.getName() + " | Interested Product: " + account.getProduct() +
//                " | Interested Units: " + account.getQuantity() + " }\n");
        navigate();
    }

    public static void showAccounts(){

        System.out.println(accountList);
//        System.out.println("{ID: " + opportunity.getId() + " | Status: " + opportunity.getStatus() +
//                " | Decision Maker: " + decisionMaker.getName() + " | Interested Product: " + opportunity.getProduct() +
//                " | Interested Units: " + opportunity.getQuantity() + " }\n");
        navigate();
    }
}
