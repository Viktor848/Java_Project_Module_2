package com.company.AdminOptions;

import com.company.Protocol;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class SearchProtocols{
    public ArrayList<Protocol> protocols = new ArrayList<>();

    public void searchProtocols() throws FileNotFoundException {
        File file = new File("Employee's protocols.txt");
        Scanner fileReader = new Scanner(file, "windows-1251");
        Scanner input = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<String>();
        while (fileReader.hasNext()){
            list.add(fileReader.next());
        }
        fileReader.close();

        int up = 0;
        for (int i = 0; i < list.size(); i++) {
            while (up < list.size()) {
                Protocol protocol = new Protocol();
                protocol.customerNamesSetter(list.get(up));
                up++;
                protocol.spentTimeOnCustomersSetter(list.get(up));
                up++;
                protocol.authorSetter(list.get(up));
                protocols.add(protocol);
                up++;
            }
        }

        for (int i = 0; i < protocols.size(); i++) {
            System.out.println(protocols.get(i).authorGetter());
        }

        System.out.print("На кого искате да погледнете протокола: ");
        String employeeName = input.nextLine();
        ArrayList<String> employeeNames = new ArrayList<>();
        for (int i = 0; i < protocols.size(); i++) {
            employeeNames.add(protocols.get(i).authorGetter());
        }

            while (!employeeNames.contains(employeeName)){
                System.out.println("Няма такъв служител!");
                System.out.print("Въведете отново име на служител: ");
                employeeName = input.nextLine();
            }

        for (int i = 0; i < protocols.size(); i++) {
            if(employeeName.equals(protocols.get(i).authorGetter())){
                System.out.println("Име на клиент: " + protocols.get(i).customerNamesGetter() + ", Време работено с клиент: " + protocols.get(i).spentTimeOnCustomersGetter() + " минути");
            }
        }
    }
}
