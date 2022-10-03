package org.example.classes;

import org.example.Enums.Product;
import org.example.enums.Status;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Opportunity {

    private int id;
    private Product product;
    private int quantity;
    private String decisionMaker;
    private Status status;

    static List<Opportunity> opportunityList = new ArrayList<>();

    public Opportunity(int id, Product product, int quantity, Contact decisionMaker, Status status) {
        setId(id);
        this.product = product;
        this.quantity = quantity;
        this.decisionMaker = decisionMaker.toString();
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

    public String getDecisionMaker() {
        return decisionMaker;
    }

    public void setDecisionMaker(String decisionMaker) {
        this.decisionMaker = decisionMaker;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public static void addOpportunity() {
        Opportunity opportunity = new Opportunity();
        Scanner input = new Scanner(System.in);
        System.out.println("Introduce the interested product:");
        opportunity.setProduct(Product.valueOf(input.nextLine()));
        System.out.println("Introduce the interested quantity of product:");
        opportunity.setQuantity(Integer.parseInt(input.nextLine()));
//        System.out.println("Introduce a decision maker of the opportunity:");
//        opportunity.setDecisionMaker(input.nextLine());
//        System.out.println("Introduce a status of the opportunity:");
//        opportunity.setStatus(Status.valueOf(input.nextLine()));

        System.out.println("\nThe new opportunity is created correctly.");
    }
}

