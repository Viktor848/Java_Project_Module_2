package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class AdminOptions implements adminInterface {
    public ArrayList<String> authors = new ArrayList<>();

    public void addNewCustomer() throws IOException {
        FileWriter fileWriter = new FileWriter("Customers.txt", true);
        PrintWriter out = new PrintWriter(fileWriter);
        Scanner input = new Scanner(System.in);
        System.out.println("Въведете име на клиента: ");
        try {
            String customerName = input.nextLine();
            System.out.println("Въведете име на проекта: ");
            String projectName = input.nextLine();
            System.out.println("Въведете дата за край на проекта: ");
            String dateOfTheEnd = input.nextLine();
            out.println("Име на клиента: " + customerName + " Име на проекта: " + projectName + " Дата за край на проекта: " + dateOfTheEnd);
            out.close();
        } catch (Exception e) {
            System.out.println("Грешни входни данни!");
        }
    }

    public void addNewEmployee() throws IOException {
        FileWriter fileWriter = new FileWriter("Names and Passwords.txt", true);
        PrintWriter out = new PrintWriter(fileWriter);
        Scanner input = new Scanner(System.in);
        System.out.println("Въведете име: ");
        try {
            String employeeName = input.nextLine();
            System.out.println("Въведете парола: ");
            String employeePassword = input.nextLine();
            out.println(employeeName);
            out.println(employeePassword);
            out.close();
        } catch (Exception e) {
            System.out.println("Грешни входни данни!");
        }
    }

    public void searchProtocols() throws FileNotFoundException {
        File file = new File("Employee's protocols.txt");
        Scanner fileReader = new Scanner(file, "windows-1251");
        Scanner input = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<String>();
        while (fileReader.hasNext()){
            list.add(fileReader.next());
        }
        fileReader.close();

        for (int i = 0; i < list.size(); i++) {
            if(list.indexOf(i) / 3 != 0){

            }
        }
        
        for (int i = 0; i < list.size(); i+=3) {
            authors.add(list.get(i));
        }

        System.out.println("На кого искате да погледнете протокола:");
        String employeeName = input.nextLine();
        while(!authors.contains(employeeName)){
            System.out.println("Няма такъв служител!");
            employeeName = input.nextLine();
        }
        for (int i = 0; i < authors.size(); i++) {
            if(employeeName.equals(authors.get(i))){
                System.out.println();
            }
        }
    }
}
