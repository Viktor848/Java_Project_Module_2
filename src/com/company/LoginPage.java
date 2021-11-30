package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public  class LoginPage implements loginPageInterface{
    private ArrayList<String> names = new ArrayList<>();
    private ArrayList<String> passwords = new ArrayList<>();

    public void namesAndPasswords() throws FileNotFoundException {
        File file = new File("Names and Passwords.txt");
        Scanner fileReader = new Scanner(file, "windows-1251");
        ArrayList<String> list = new ArrayList<String>();
        while (fileReader.hasNext()){
            list.add(fileReader.next());
        }
        fileReader.close();

        for (int i = 0; i < list.size(); i++) {
            if(i % 2 == 0){
                names.add(list.get(i));
            }
            else{
                passwords.add(list.get(i));
            }
        }
    }

    public void Login() throws IOException {
        namesAndPasswords();
        Scanner input = new Scanner(System.in);
        System.out.print("Въведете име: ");
        try {
            String name = input.nextLine();
            while (true) {
                if (names.contains(name)) {
                    for (int i = 0; i < names.size(); i++) {
                        if (name.equals(names.get(i))) {
                            System.out.print("Въведете парола: ");
                            String password = input.nextLine();
                            try {
                                while (true) {
                                    if (password.equals(passwords.get(i))) {
                                        if (password.equals(passwords.get(0)) && name.equals(names.get(0))) {
                                            adminOptions();
                                        } else {
                                            employeeOptions(names.get(i));
                                        }
                                    } else {
                                        System.out.println("Try again!");
                                        System.out.print("Въведете парола: ");
                                        password = input.nextLine();
                                    }
                                }
                            }
                            catch (Exception e){
                                System.out.println("Грешни входни данни!");
                            }
                        }
                    }
                } else {
                    System.out.println("Try again!");
                    System.out.print("Въведете име: ");
                    name = input.nextLine();
                }
            }
        }
        catch (Exception e){
            System.out.println("Грешни входни данни!");
        }
    }


    public void adminOptions() throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("Влязохте като админ!\nМоля изберете една от 3-те опции: ");
        System.out.println("(1)-Първа опция е да се въведе клиент.\n(2)-Втора опция е да се въведе служител.\n" +
                "(3)-Трета да се гледа статистика на служителите.\n(4)-Четвърта опция е за изход.");
        try {
            int n = input.nextInt();
            switch (n) {
                case 1:
                    AdminOptions option1 = new AdminOptions();
                    option1.addNewCustomer();
                    break;
                case 2:
                    AdminOptions option2 = new AdminOptions();
                    option2.addNewEmployee();
                    break;
                case 3:
                    AdminOptions option3 = new AdminOptions();
                    option3.readProtocols();
                    break;
                case 4:
                    Login();
                default:
                    System.out.println("Моля изберете една от посочените горе опции!");
                    n = input.nextInt();
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
            int n = input.nextInt();
            switch (n) {
                case 1:
                    protocol1.protocol(name);
                    break;
                case 2:
                    Login();
                    break;
                default:
                    System.out.println("Моля изберете една от посочените горе опции!");
                    n = input.nextInt();
            }
        }
        catch (Exception e){
            System.out.println("Грешни входни данни!");
        }
    }
}
