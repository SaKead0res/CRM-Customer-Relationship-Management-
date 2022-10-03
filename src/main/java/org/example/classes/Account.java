package org.example.classes;

import org.example.Enums.Industries;
import org.example.classes.Opportunity;

import java.util.ArrayList;
import java.util.List;

public class Account {

    private int id;
    private Industries industry;
    private int employeeCount;
    private String city;
    private String country;
    private List<Contact> contactList;
    private List<Opportunity> opportunityList;
}
