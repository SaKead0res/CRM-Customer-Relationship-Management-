
package org.example.classes;

import org.example.Enums.Industries;

import java.util.ArrayList;
import java.util.List;

public class Account {

    private int id;
    private Industries industry;
    private int employeeCount;
    private String city;
    private String country;
    private List<Contact> AccountContactList;
    private List<Opportunity> AccountOpportunityList;
    //    private static List<Account> accountList;
    static List<Account> accountList = new ArrayList<>();
    public Account(Industries industry, int employeeCount, String city, String country) {
        setAccountId(id);
        this.industry = industry;
        this.employeeCount = employeeCount;
        this.city = city;
        this.country = country;

    }

    public int getId() {
        return id;
    }
    public void setAccountId(int accountId) {
        this.id = accountList.size();
    }
    public Industries getIndustry() {
        return industry;
    }
    public void setIndustry(Industries industry) {
        this.industry = industry;
    }
    public int getEmployeeCount() {
        return employeeCount;
    }
    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }

          /* Scanner input = new Scanner(System.in);
        System.out.println("Please enter Industry : ");
        contact.setIndustry(Status.valueOf(input.nextLine()));
        System.out.println("Please enter your number of employees : ");
        contact.setEmployeeCount(Integer.parseInt(input.nextLine()));
        System.out.println("Please enter City : ");
        contact.setCity(input.nextLine());
        System.out.println("Please enter Country : ");
        contact.setCountry(input.nextLine());*/


}


