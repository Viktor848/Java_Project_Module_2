package com.company.AdminOptions;

import com.company.Customer;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class AddNewCustomer {
    public void addNewCustomer() throws IOException {
        FileWriter fileWriter = new FileWriter("Customers.txt", true);
        PrintWriter out = new PrintWriter(fileWriter);
        Scanner input = new Scanner(System.in);
        System.out.print("Въведете име на клиента: ");
        try {
            String customerName = input.nextLine();
            System.out.print("Въведете име на проекта: ");
            String projectName = input.nextLine();
            System.out.print("Въведете дата за край на проекта: ");
            String dateOfTheEnd = input.nextLine();
            Customer customer = new Customer();
            customer.nameSetter(customerName);
            customer.projectNameSetter(projectName);
            customer.dateOfEndOfTheProjectSetter(dateOfTheEnd);
            out.println(customer.nameGetter());
            out.println(customer.projectNameGetter());
            out.println(customer.dateOfEndOfTheProjectGetter());
            out.close();
        } catch (Exception e) {
            System.out.println("Грешни входни данни!");
        }
    }
}
