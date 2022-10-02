package org.example.classes;

import org.example.Enums.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Opportunity {

    private int id;
    private Product product;
    private int quantity;
    private org.example.Classes.Contact decisionMaker;
    private org.example.Enums.Status status;

    static List<Opportunity> opportunityList = new ArrayList<>();

    public Opportunity(int id, Product product, int quantity, org.example.Classes.Contact decisionMaker, org.example.Enums.Status status) {
        setId(id);
        this.product = product;
        this.quantity = quantity;
        this.decisionMaker = decisionMaker;
        this.status = status;
    }

    public Opportunity() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = opportunityList.size();
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public org.example.Classes.Contact getDecisionMaker() {
        return decisionMaker;
    }

    public void setDecisionMaker(org.example.Classes.Contact decisionMaker) {
        this.decisionMaker = decisionMaker;
    }

    public org.example.Enums.Status getStatus() {
        return status;
    }

    public void setStatus(org.example.Enums.Status status) {
        this.status = status;
    }

//    public static Status opportunityInput() {
//        //Create a Scanner to collect user input
//        Scanner myScanner = new Scanner(System.in);
//
//        String userInput = myScanner.nextLine();
//        return null;
//    }

    public static void addOpportunity() {
        Opportunity opportunity = new Opportunity();
        System.out.println("Introduce the product:");
//        opportunity.setProduct(Navigate.input());
        System.out.println("Introduce a quantity of product:");
//        opportunity.setQuantity(Navigate.input());
        System.out.println("Introduce a decision maker of the transaction:");
//        opportunity.setDecisionMaker(Navigate.input());
        System.out.println("Introduce a status of the opportunity:");
//        opportunity.setStatus(Navigate.input());

        System.out.println("\nThe new opportunity is created correctly.");
    }
}

