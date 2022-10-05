package org.example;

import org.example.classes.Contact;
import org.example.classes.Lead;
import org.example.classes.Navigate;
import org.example.classes.Opportunity;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Lead lead1 = new Lead("random", "+34 5643654", "hgd@jhgfc.com", "Movistar");
        Lead lead2 = new Lead("random2", "+34 5643655", "hgd@jhgfc.es", "Orange");
        Lead lead3 = new Lead("random3", "+34 5643656", "hgd@jhgfc.net", "PepePhone");
        Lead.leadList.add(lead1);
        Lead.leadList.add(lead2);
        Lead.leadList.add(lead3);
//        Contact contact1 = new Contact(Contact.createContact(lead2));
        Navigate.navigate();
//        Lead.addLead();
//        Opportunity.addOpportunity();
    }
}