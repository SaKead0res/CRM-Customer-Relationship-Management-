package org.example.classes;

import org.example.enums.Product;
import org.example.enums.Status;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.example.classes.Navigate.navigate;

public class Opportunity {
    private int id;
    private Product product;
    private int quantity;
    static Contact decisionMaker;
    private Status status;
    static List<Opportunity> opportunityList = new ArrayList<>(); // Los ID's no funcionan. Siempre son 0
    public Opportunity(int id, Product product, int quantity, Contact decisionMaker, Status status) {
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
    public Contact getDecisionMaker() {
        return decisionMaker;
    }
    public void setDecisionMaker(Contact decisionMaker) {
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
        System.out.println("Introduce the Lead Id to convert:");
        opportunity.setDecisionMaker(Contact.createContact(Lead.leadList.get(Integer.parseInt(input.nextLine()))));
        System.out.println("Introduce the interested product:");
        opportunity.setProduct(Product.valueOf(input.nextLine()));
        System.out.println("Introduce the interested quantity of product:");
        opportunity.setQuantity(Integer.parseInt(input.nextLine()));
        opportunity.setStatus(Status.OPEN);
        System.out.println("\nThe new " + (char)27 + "[33m" + "OPPORTUNITY" + (char)27 + "[0m" + " is created correctly.");
        System.out.println("{ID: " + opportunity.getId() + " | Status: " + opportunity.getStatus() +
                " | Decision Maker: " + decisionMaker.getName() + " | Interested Product: " + opportunity.getProduct() +
                " | Interested Units: " + opportunity.getQuantity() + " }\n");
        opportunityList.add(opportunity);
        Account.accountOpportunityList.add(opportunity);

        Account.addAccount();

    }

    public static void closedWon() {

        Opportunity opportunity = new Opportunity();
        Scanner input = new Scanner(System.in);
        opportunityList.get(input.nextInt());
        opportunity.setStatus(Status.CLOSED_WON);
        System.out.println("Opportunity " + decisionMaker.getName() + " was " + opportunity.status + " succesfully.\n");
        navigate();
    }

    public static void closedLost(){

        Opportunity opportunity = new Opportunity();
        Scanner input = new Scanner(System.in);
        opportunityList.get(input.nextInt());
        opportunity.setStatus(Status.CLOSED_LOST);
        System.out.println("Opportunity " + decisionMaker.getName() + " was " + opportunity.status + " succesfully.\n");
        navigate();
    }

    public static void lookupOpportunity(){

        Opportunity opportunity = new Opportunity();
        Scanner input = new Scanner(System.in);
        System.out.println("Introduce the " + (char)27 + "[33m" + "OPPORTUNITY" + (char)27 + "[0m" + " Id to LOOK:");
        opportunityList.get(input.nextInt());
        System.out.println("{ID: " + opportunity.getId() + " | Status: " + opportunity.getStatus() +
                " | Decision Maker: " + decisionMaker.getName() + " | Interested Product: " + opportunity.getProduct() +
                " | Interested Units: " + opportunity.getQuantity() + " }\n");
        navigate();
    }

    public static void showOpportunities(){

        System.out.println("\nOPPORTUNITY LIST\n===================");
        for (Opportunity opportunity : opportunityList){
            System.out.println("Opportunity { " + opportunity.getId() + " | Status: " + opportunity.getStatus() +
                    " | Decision Maker: " + decisionMaker.getName() + " | Interested Product: " + opportunity.getProduct() +
                    " | Interested Units: " + opportunity.getQuantity() + " }");
            System.out.println("====================");
        }
        System.out.println("END OF LIST\n");
    }

}

