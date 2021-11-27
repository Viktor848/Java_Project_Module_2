package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public  class Admin<T> extends LoginPage implements adminInterface{
    public ArrayList<String> customers = new ArrayList<>();


    public void addNewCustomer(Scanner input) throws IOException {
        FileWriter fileWriter = new FileWriter("Customers.txt", true);
        PrintWriter out = new PrintWriter(fileWriter);
        System.out.println("Въведете име на клиента: ");
        try {
            String customerName = input.nextLine();
            System.out.println("Въведете име на проекта: ");
            String projectName = input.nextLine();
            System.out.println("Въведете дата за край на проекта: ");
            String dateOfTheEnd = input.nextLine();
            out.println("Име на клиента: " + customerName + " Име на проекта: " + projectName + " Дата за край на проекта: " + dateOfTheEnd);
            out.close();
        }
        catch (Exception e){
            System.out.println("Грешни входни данни!");
        }
    }

    @Override
    public void readProtocols(Scanner input) throws IOException {

    }

    public void addNewEmployee(Scanner input) throws IOException {
        FileWriter fileWriter = new FileWriter("Names and Passwords.txt", true);
        PrintWriter out = new PrintWriter(fileWriter);
        System.out.println("Въведете име: ");
        try {
            String employeeName = input.nextLine();
            System.out.println("Въведете парола: ");
            String employeePassword = input.nextLine();
            out.println(employeeName);
            out.println(employeePassword);
            out.close();
        }
        catch (Exception e){
            System.out.println("Грешни входни данни!");
        }
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
