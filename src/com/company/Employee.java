package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Employee  implements employeeInterface{
    public void protocol() throws IOException {
        FileWriter fileWriter = new FileWriter("Employee's protocols.txt", true);
        PrintWriter out = new PrintWriter(fileWriter);
        Scanner input = new Scanner(System.in);
        System.out.println("За кои клиенти си работил/а днес?");
        try {
            String customerName = input.nextLine();
            System.out.println("Колко време отдели на клиента?");
            String timeSpend = input.nextLine();
            out.println(customerName);
            out.println(timeSpend);
            out.close();
        }
        catch (Exception e){
            System.out.println("Грешни входни данни!");
        }
    }
}
