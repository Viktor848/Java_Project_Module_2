package com.company;

import com.company.AdminOptions.AddNewCustomer;
import com.company.AdminOptions.AddNewEmployee;
import com.company.AdminOptions.SearchProtocols;
import com.company.Interfaces.loginPageInterface;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public  class LoginPage implements loginPageInterface {
    private ArrayList<String> names = new ArrayList<>();
    private ArrayList<String> passwords = new ArrayList<>();

    public void namesAndPasswords() throws FileNotFoundException {
        File file = new File("Names and Passwords.txt");
        Scanner fileReader = new Scanner(file, "windows-1251");
        ArrayList<String> list = new ArrayList<String>();
        while (fileReader.hasNext()) {
            list.add(fileReader.next());
        }
        fileReader.close();

        for (int i = 0; i < list.size(); i++) {
            if (i % 2 == 0) {
                names.add(list.get(i));
            } else {
                passwords.add(list.get(i));
            }
        }
    }

    public void login() throws IOException {
        namesAndPasswords();
        System.out.print("Въведете име: ");
        try {
            String name = name();
            while (!names.contains(name)) {
                System.out.println("Няма такова име!");
                System.out.print("Въведете име: ");
                name = name();
            }
            for (int i = 0; i < names.size(); i++) {
                if (name.equals(names.get(i))) {
                    System.out.print("Въведете парола: ");
                    String password = password();
                    while (!password.equals(passwords.get(i))) {
                        System.out.println("Грешна парола!");
                        System.out.print("Въведете парола: ");
                        password = password();
                    }
                    if (password.equals(passwords.get(0)) && name.equals(names.get(0))) {
                        while(true) {
                            adminOptions();
                        }
                    } else {
                        while(true) {
                            employeeOptions(names.get(i));
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Грешни входни данни!");
        }
    }

    public String password(){
        Scanner input = new Scanner(System.in);
        String password = input.nextLine();
        return password;
    }
    public String name(){
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        return name;
    }



    public void adminOptions() throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("Влязохте като админ!\nМоля изберете една от 3-те опции: ");
        System.out.println("(1)-Първа опция е да се въведе клиент.\n(2)-Втора опция е да се въведе служител.\n" +
                "(3)-Трета да се гледа статистика на служителите.\n(4)-Четвърта опция е за изход.");
        try {
            int num = input.nextInt();
            switch (num) {
                case 1:
                    AddNewCustomer option1 = new AddNewCustomer();
                    option1.addNewCustomer();
                    break;
                case 2:
                    AddNewEmployee option2 = new AddNewEmployee();
                    option2.addNewEmployee();
                    break;
                case 3:
                    SearchProtocols option3 = new SearchProtocols();
                    option3.searchProtocols();
                    break;
                case 4:
                    login();
                default:
                    System.out.println("Моля изберете една от посочените горе опции!");
                    num = input.nextInt();
            }
        }
        catch (Exception e){
            System.out.println("Грешни входни данни!");
        }
    }

    public void employeeOptions(String name) throws IOException {
        Scanner input = new Scanner(System.in);
        EmployeeOptions protocol1 = new EmployeeOptions();
        System.out.println("Изберете опция за протокол или за изход");
        System.out.println("(1)-Протокол.");
        System.out.println("(2)-Изход.");
        try {
            int option = input.nextInt();
            switch (option) {
                case 1:
                    protocol1.writingProtocol(name);
                    break;
                case 2:
                    login();
                    break;
                default:
                    System.out.println("Моля изберете една от посочените горе опции!");
                    option = input.nextInt();
            }
        }
        catch (Exception e){
            System.out.println("Грешни входни данни!");
        }
    }
}
