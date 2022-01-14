package com.company.AdminOptions;

import com.company.Employee.Employee;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class AddNewEmployee {
    public void addNewEmployee() throws IOException {
        FileWriter fileWriter = new FileWriter("Names and Passwords.txt", true);
        PrintWriter out = new PrintWriter(fileWriter);
        Scanner input = new Scanner(System.in);
        System.out.print("Въведете име: ");
        try {
            String employeeName = input.nextLine();
            System.out.print("Въведете парола: ");
            String employeePassword = input.nextLine();
            Employee employee = new Employee();
            employee.nameSetter(employeeName);
            employee.passwordSetter(employeePassword);
            out.println(employee.nameGetter());
            out.println(employee.passwordGetter());
            out.close();
        } catch (Exception e) {
            System.out.println("Грешни входни данни!");
        }
    }
}
