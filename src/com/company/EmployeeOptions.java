package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeOptions implements employeeInterface{
    private ArrayList<String> customerNames = new ArrayList<>();

        public void protocol(String name) throws IOException {
            FileWriter fileWriter = new FileWriter("Employee's protocols.txt", true);
            PrintWriter out = new PrintWriter(fileWriter);
            Scanner input = new Scanner(System.in);
            displayCustomerNames();
            System.out.println("За кои клиенти си работил/а днес?");
            try {
                String customerName = input.nextLine();
                while(!customerNames.contains(customerName)){
                    System.out.println("Няма такъв клиент!");
                    customerName = input.nextLine();
                }


                System.out.println("Колко време отдели на клиента?");
                String timeSpend = input.nextLine();
                out.println(customerName);
                out.println(timeSpend);
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
