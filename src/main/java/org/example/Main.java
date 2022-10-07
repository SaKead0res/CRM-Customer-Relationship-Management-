package org.example;

import org.example.classes.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Lead lead1 = new Lead("Julia Roberts", "+34 56436546", "julia.r@hotmail.com", "Movistar");
        Lead lead2 = new Lead("George Clooney", "+41 78658554", "clooney.fckr@gmail.es", "Orange");
        Lead lead3 = new Lead("Susan Sarandon", "+38 97781234", "susan.sar@yahoo.net", "PepePhone");
        Lead.leadList.add(lead1);
        Lead.leadList.add(lead2);
        Lead.leadList.add(lead3);

        System.out.println("Business " + (char)27 + "[35m" + "CRM DATA-BASE" + (char)27 + "[0m" + " Iniatiated:\n===========================");
        System.out.println("List of " + (char)27 + "[33m" + "COMMANDS" + (char)27 + "[0m" + " available:");
        System.out.print("{   NEWLEAD   } ");
        System.out.print("{  SHOWLEADS   } ");
        System.out.print("{  CONVERT   } ");
        System.out.print("{ SHOWOPPORTUNITIES } ");
        System.out.println("{  CLOSED_WON   } ");
        System.out.print("{ CLOSED_LOST } ");
        System.out.print("{ SHOWACCOUNTS } ");
        System.out.print("{ LOOKUPLEAD } ");
        System.out.print("{ LOOKUPOPPORTUNITY } ");
        System.out.print("{ LOOKUPACCOUNT } ");
        System.out.println("\n=================");

        Navigate.navigate();
    }
}