package org.example.classes;

import org.example.enums.Commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Navigate {

    public static void navigate() throws InterruptedException {

        System.out.print("Please, enter a command: " + Account.accountContactList.size());


        Commands command = null;
        try {
            command = Commands.valueOf( input() );//esta funcion intenta dar a la variable command el valor de una String(input())
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
            case SHOWOPPORTUNITIES:
                Opportunity.showOpportunities();
                break;
            case SHOWACCOUNTS:
                Account.showAccounts();
                break;
            case LOOKUPLEAD:
                Lead.lookupLead();
                break;
            case LOOKUPACCOUNT:
                Account.lookupAccount();
                break;
            case LOOKUPOPPORTUNITY:
                Opportunity.lookupOpportunity();
                break;
            case CONVERT:
                Lead.convert();
                break;
            case CLOSED_WON:
                Opportunity.closedWon();
                break;
            case CLOSED_LOST:
                Opportunity.closedLost();
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
    }

    public static void help() throws InterruptedException {
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
        navigate();
    }

    public static String input() {
        Scanner myScanner = new Scanner(System.in);

        String userInput = myScanner.nextLine();
//
////        PROBANDO LOOKUPLEADID
//
//        List<String> inputArray = new ArrayList<>(List.of(userInput.trim().split(" ")));
//        String inputFirstPart = inputArray.get(0) + inputArray.get(1);
//        int id;
//        System.out.println(inputFirstPart);
////        if (Integer.parseInt(inputArray.get(inputArray.size() - 1)))
//        try{
//            id = Integer.parseInt(inputArray.get(inputArray.size() - 1));
//        } catch (IllegalArgumentException e){
//            System.err.println("Wrong ID format. Try again.");
//            input();
//        }
//        String upperCaseInput = userInput.toUpperCase().replace(" ", "");
//        return inputFirstPart.toUpperCase();
        return userInput.toUpperCase();
    }
}
