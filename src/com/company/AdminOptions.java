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
        System.out.print("Въведете име на клиента: ");
        try {
            String customerName = input.nextLine();
            System.out.print("Въведете име на проекта: ");
            String projectName = input.nextLine();
            System.out.print("Въведете дата за край на проекта: ");
            String dateOfTheEnd = input.nextLine();
            out.println(customerName);
            out.println(projectName);
            out.println(dateOfTheEnd);
            out.close();
        } catch (Exception e) {
            System.out.println("Грешни входни данни!");
        }
    }

    public void addNewEmployee() throws IOException {
        FileWriter fileWriter = new FileWriter("Names and Passwords.txt", true);
        PrintWriter out = new PrintWriter(fileWriter);
        Scanner input = new Scanner(System.in);
        System.out.print("Въведете име: ");
        try {
            String employeeName = input.nextLine();
            System.out.print("Въведете парола: ");
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
        ArrayList<String> names = new ArrayList<String>();
        ArrayList<String> workTime = new ArrayList<String>();
        while (fileReader.hasNext()){
            list.add(fileReader.next());
        }
        fileReader.close();

        for (int i = 0; i < list.size(); i+=3) {
            names.add(list.get(i));
        }

        for (int i = 1; i < list.size(); i+=3) {
            workTime.add(list.get(i));
        }
        
        for (int i = 2; i < list.size(); i+=3) {
            authors.add(list.get(i));
        }

        System.out.println(authors);
        System.out.print("На кого искате да погледнете протокола: ");
        String employeeName = input.nextLine();
        while(!authors.contains(employeeName)){
            System.out.println("Няма такъв служител!");
            System.out.print("На кого искате да погледнете протокола: ");
            employeeName = input.nextLine();
        }

        for (int i = 0; i < authors.size(); i++) {
            if(employeeName.equals(authors.get(i))){
                System.out.println("Име на клиент: " + names.get(i) + ", Време работено с клиент: " + workTime.get(i) + " минути");
            }
        }
    }
}
