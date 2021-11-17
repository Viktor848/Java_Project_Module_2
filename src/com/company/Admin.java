package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Admin<T> extends LoginPage{
    public ArrayList<Customer> customers = new ArrayList<>();

    public void addNewCustomer() throws IOException {
        FileWriter fileWriter = new FileWriter("Customers.txt",true);
        PrintWriter out = new PrintWriter(fileWriter);
        Scanner input = new Scanner(System.in);
        System.out.println("Въведете име на клиента: ");
        String customerName = input.nextLine();
        System.out.println("Въведете име на проекта: ");
        String projectName = input.nextLine();
        System.out.println("Въведете дата за край на проекта: ");
        String dateOfTheEnd = input.nextLine();
        out.println("Име на клиента: " + customerName + " Име на проекта: " + projectName + " Дата за край на проекта: " + dateOfTheEnd);
        out.close();

//        File file = new File("Customer.txt");
//        Scanner fileReader = new Scanner(file, "windows-1251");
//
//        for (int i = 0; i < customers.size(); i++) {
//            if(i % 2 == 0){
//                names.add(list.get(i));
//            }
//            else{
//                passwords.add(list.get(i));
//            }
//        }
    }

    public void addNewEmployee() throws IOException {
        FileWriter fileWriter = new FileWriter("Names and Passwords.txt",true);
        PrintWriter out = new PrintWriter(fileWriter);
        Scanner input = new Scanner(System.in);
        System.out.println("Въведете име: ");
        String employeeName = input.nextLine();
        System.out.println("Въведете парола: ");
        String employeePassword = input.nextLine();
        out.println(employeeName);
        out.println(employeePassword);
        out.close();
    }
}
