package org.example.classes;

import org.example.enums.Product;
import org.example.enums.Status;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import static org.example.classes.Navigate.navigate;

public class Opportunity {
    private int id;

    public static int inputId;
    private Product product;
    private int quantity;
    static Contact decisionMaker;
    private Status status;
    static List<Opportunity> opportunityList = new ArrayList<>(); // Los ID's no funcionan. Siempre son 0
    public Opportunity(Product product, int quantity, Contact decisionMaker, Status status) {
        setId(id);
        this.product = product;
        this.quantity = quantity;
        Opportunity.decisionMaker = decisionMaker;
        this.status = status;
    }
    public Opportunity() {
        setId(id);
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
        Opportunity.decisionMaker = decisionMaker;
    }
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }

    public static Opportunity addOpportunity() throws InterruptedException {

        Opportunity opportunity = new Opportunity();

        System.out.print("- Introduce the " + (char)27 + "[33m" + "LEAD" + (char)27 + "[0m" + " Id to convert:");

        Scanner input = new Scanner(System.in);
        Integer id = null;
        try {
            id = Integer.parseInt(input.nextLine());

        } catch ( IllegalArgumentException e ) {
            System.err.println( "Wrong ID format." );
            TimeUnit.MILLISECONDS.sleep(1000);
            addOpportunity();
        }

        try {
//            System.out.println(Contact.createContact(Lead.leadList.get()));
            opportunity.setDecisionMaker(Contact.createContact(Lead.leadList.get(id)));

        } catch (IndexOutOfBoundsException e){
            System.err.println("This Lead ID doesn't exists.");
            TimeUnit.MILLISECONDS.sleep(1000);
            addOpportunity();
        }


        System.out.print("- Introduce the Interested Product:");

        Product product = null;

        try {
            product = Product.valueOf( input.nextLine().toUpperCase() );

        } catch ( IllegalArgumentException e ) {
            System.err.println( "This Product doesn't exists" );
            TimeUnit.MILLISECONDS.sleep(1000);
            addOpportunity();
        }
        opportunity.setProduct(product);
        System.out.print("- Introduce the Interested Quantity of product:");

        Integer quantity = -1;

        try {
            quantity = Integer.parseInt( input.nextLine() );//esta funcion intenta dar a la variable command el valor de una String(input())
//                                                  pero como es de clase Enum solo cogera el valor en caso de que exista en la
//                                                  clase Enum Commands.
        } catch ( IllegalArgumentException e ) {
            System.err.println( "Wrong quantity format." );
            TimeUnit.MILLISECONDS.sleep(1000);
            addOpportunity();
        }


        opportunity.setQuantity(quantity);

        opportunity.setStatus(Status.OPEN);

        System.out.println("\nThe new " + (char)27 + "[33m" + "OPPORTUNITY" + (char)27 + "[0m" + " is created correctly.");
        System.out.println("Opportunity {ID: "
                + opportunity.getId() + " | Status: " + opportunity.getStatus() +
                " | Decision Maker: " + opportunity.getDecisionMaker().getName() + " | Interested Product: " + opportunity.getProduct() +
                " | Interested Units: " + opportunity.getQuantity() + " }\n");



        opportunityList.add(opportunity);
//        Account.accountOpportunityList.add(opportunity);

//        Account.addAccount();
        return opportunity;
    }

    public static void closedWon() throws InterruptedException {

        Opportunity opportunity = new Opportunity();
        Scanner input = new Scanner(System.in);
        System.out.print("- Introduce the " + (char)27 + "[33m" + "OPPORTUNITY" + (char)27 + "[0m" + " Id to CLOSE :");
        opportunityList.get(input.nextInt());
        opportunity.setStatus(Status.CLOSED_WON);
        System.out.println("Opportunity " + decisionMaker.getName() + " was " + opportunity.status + " succesfully.\n");
        navigate();
    }

    public static void closedLost() throws InterruptedException {

        Opportunity opportunity = new Opportunity();
        Scanner input = new Scanner(System.in);
        System.out.print("- Introduce the " + (char)27 + "[33m" + "OPPORTUNITY" + (char)27 + "[0m" + " Id to CLOSE :");
        opportunityList.get(input.nextInt());
        opportunity.setStatus(Status.CLOSED_LOST);
        System.out.println("Opportunity " + decisionMaker.getName() + " was " + opportunity.status + " succesfully.\n");
        navigate();
    }

    public static void lookupOpportunity() throws InterruptedException {

        Opportunity opportunity = null;

        Scanner input = new Scanner(System.in);


        System.out.print("- Introduce the " + (char)27 + "[33m" + "OPPORTUNITY" + (char)27 + "[0m" + " Id to LOOK: ");
        try{
            opportunity = opportunityList.get(Integer.parseInt(input.nextLine()));

        }catch (IllegalArgumentException e){
            System.err.println("Wrong Id format.");
            TimeUnit.MILLISECONDS.sleep(1000);
            lookupOpportunity();
        }

        System.out.println("{ID: " + Opportunity.opportunityList.indexOf(opportunity) + " | Status: " + opportunity.getStatus() +
                " | Decision Maker: " + decisionMaker.getName() + " | Interested Product: " + opportunity.getProduct() +
                " | Interested Units: " + opportunity.getQuantity() + " }\n");
        navigate();
    }

    public static void showOpportunities(){

        System.out.println("\nOPPORTUNITY LIST\n===================");
        for (Opportunity opportunity : opportunityList){
            System.out.println("Opportunity { " + Opportunity.opportunityList.indexOf(opportunity) + " | Status: " + opportunity.getStatus() +
                    " | Decision Maker: " + opportunity.getDecisionMaker().getName() + " | Interested Product: " + opportunity.getProduct() +
                    " | Interested Units: " + opportunity.getQuantity() + " }");
            System.out.println("====================");
        }
        System.out.println("END OF LIST\n");
    }

}