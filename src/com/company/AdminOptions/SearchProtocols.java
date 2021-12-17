package com.company.AdminOptions;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class SearchProtocols{
    public ArrayList<String> employee = new ArrayList<>();

    public void searchProtocols() throws FileNotFoundException {
        File file = new File("Employee's protocols.txt");
        Scanner fileReader = new Scanner(file, "windows-1251");
        Scanner input = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<String>();
        ArrayList<String> customerNames = new ArrayList<String>();
        ArrayList<String> spentTimeOnCustomer = new ArrayList<String>();
        while (fileReader.hasNext()){
            list.add(fileReader.next());
        }
        fileReader.close();

        for (int i = 0; i < list.size(); i+=3) {
            customerNames.add(list.get(i));
        }

        for (int i = 1; i < list.size(); i+=3) {
            spentTimeOnCustomer.add(list.get(i));
        }
        
        for (int i = 2; i < list.size(); i+=3) {
            employee.add(list.get(i));
        }

        System.out.println(employee);
        System.out.print("На кого искате да погледнете протокола: ");
        String employeeName = input.nextLine();
        while(!employee.contains(employeeName)){
            System.out.println("Няма такъв служител!");
            System.out.print("На кого искате да погледнете протокола: ");
            employeeName = input.nextLine();
        }

        for (int i = 0; i < employee.size(); i++) {
            if(employeeName.equals(employee.get(i))){
                System.out.println("Име на клиент: " + customerNames.get(i) + ", Време работено с клиент: " + spentTimeOnCustomer.get(i) + " минути");
            }
        }
    }
}
