package com.company;

import com.company.Interfaces.employeeInterface;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeOptions{
    private ArrayList<String> customerNames = new ArrayList<>();

        public void writingProtocol(String name) throws IOException {
            FileWriter fileWriter = new FileWriter("Employee's protocols.txt", true);
            PrintWriter out = new PrintWriter(fileWriter);
            Scanner input = new Scanner(System.in);
            displayCustomerNames();
            System.out.println("За кои клиенти си работил/а днес?");
            try {
                String customerName = input.nextLine();
                while(!customerNames.contains(customerName)){
                    System.out.println("Няма такъв клиент!");
                    System.out.println("Въведете друг клиент:");
                    customerName = input.nextLine();
                }

                System.out.println("Колко време отдели на клиента?");
                String timeSpendOnCustomer = input.nextLine();
                out.println(customerName);
                out.println(timeSpendOnCustomer);
                out.println(name);
                out.close();
            }
            catch (Exception e){
                System.out.println("Грешни входни данни!");
            }
        }

        public void displayCustomerNames() throws FileNotFoundException {
            File file = new File("Customers.txt");
            Scanner fileReader = new Scanner(file, "windows-1251");
            ArrayList<String> list = new ArrayList<String>();
            while (fileReader.hasNext()){
                list.add(fileReader.next());
            }
            fileReader.close();

            for (int i = 0; i < list.size(); i += 3) {
                customerNames.add(list.get(i));
            }
            System.out.println(customerNames);
        }
}
