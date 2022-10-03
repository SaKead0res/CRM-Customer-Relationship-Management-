package org.example.classes;

import org.example.Enums.Commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Navigate {

    public static void navigate(){

        System.out.println("Please, enter a command");

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
    }

    public static void help(){
        System.out.println("List of commands available:");
        System.out.println("NEWLEAD:");
        System.out.println("SHOWLEADS:");
        System.out.println("LOOKUPLEAD:");
        System.out.println("CONVERT:");
        System.out.println("CLOSED_WON:");
        System.out.println("CLOSED_LOST:");
        navigate();
    }

    public static String input() {
        //Create a Scanner to collect user input
        Scanner myScanner = new Scanner(System.in);

        String userInput = myScanner.nextLine();

//        PROBANDO LOOKUPLEADID

        List<String> inputArray = new ArrayList<>(List.of(userInput.trim().split(" ")));
        String inputFirstPart = inputArray.get(0) + inputArray.get(1);
        int id;
        System.out.println(inputFirstPart);
//        if (Integer.parseInt(inputArray.get(inputArray.size() - 1)))
        try{
            id = Integer.parseInt(inputArray.get(inputArray.size() - 1));
        } catch (IllegalArgumentException e){
            System.err.println("Wrong ID format. Try again.");
            input();
        }
//        String upperCaseInput = userInput.toUpperCase().replace(" ", "");
        return inputFirstPart.toUpperCase();
    }
}
