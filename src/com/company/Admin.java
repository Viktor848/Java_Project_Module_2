package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Admin<T> {
    public ArrayList<Customer> customers = new ArrayList<>();

    public void addNewCustomer(){
        Scanner input = new Scanner(System.in);
        System.out.println("Name of the customer: ");
        String customerName = input.nextLine();
        System.out.println("Name of the project: ");
        String projectName = input.nextLine();
        System.out.println("Date of the end of the project: ");
        String dateOfTheEnd = input.nextLine();
        Customer guy = new Customer(customerName, projectName, dateOfTheEnd);
        customers.add(guy);
    }
}
