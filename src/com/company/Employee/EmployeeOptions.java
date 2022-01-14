package com.company.Employee;

import com.company.Customer;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeOptions {
    private ArrayList<Customer> customers = new ArrayList<>();

    public void writingProtocol(String name) throws IOException {
        FileWriter fileWriter = new FileWriter("Employee's protocols.txt", true);
        PrintWriter out = new PrintWriter(fileWriter);
        Scanner input = new Scanner(System.in);
        readCustomersFile();

        for (int i = 0; i < customers.size(); i++) {
            System.out.println(customers.get(i).nameGetter());
        }

        System.out.println("За кои клиенти си работил/а днес?");

        ArrayList<String> names = new ArrayList<>();
        for (int i = 0; i < customers.size(); i++) {
            names.add(customers.get(i).nameGetter());
        }

        try {
            String customerName = input.nextLine();
            while (!names.contains(customerName)) {
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
        } catch (Exception e) {
            System.out.println("Грешни входни данни!");
        }
    }

    public void readCustomersFile() throws FileNotFoundException {
        File file = new File("Customers.txt");
        Scanner fileReader = new Scanner(file, "windows-1251");
        ArrayList<String> list = new ArrayList<String>();
        while (fileReader.hasNext()) {
            list.add(fileReader.next());
        }
        fileReader.close();

        int up = 0;
        for (int i = 0; i < list.size(); i++) {
            while (up < list.size()) {
                Customer customer = new Customer();
                customer.nameSetter(list.get(up));
                up++;
                customer.projectNameSetter(list.get(up));
                up++;
                customer.dateOfEndOfTheProjectSetter(list.get(up));
                customers.add(customer);
                up++;
            }
        }
    }
}
