package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Admin<T> extends LoginPage{
    public ArrayList<String> customers = new ArrayList<>();

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

    public void readProtocols() throws FileNotFoundException {
        File file = new File("Employee's protocols.txt");
        Scanner fileReader = new Scanner(file, "windows-1251");
        int lineNumber = 0;
        while (fileReader.hasNext()){
            lineNumber++;
            if (lineNumber % 2 != 0){
                System.out.println("Име: " + fileReader.nextLine());
            }
            else{
                System.out.println("Време прекарано с него: " + fileReader.nextLine());
            }
        }
        fileReader.close();
    }
}
