package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class LoginPage{
    public ArrayList<String> names = new ArrayList<>();
    public ArrayList<String> passwords = new ArrayList<>();

    public void Login() throws IOException {
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

        System.out.println("Въведете име: ");
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        while (true) {
            if (names.contains(name)) {
                for (int i = 0; i < names.size(); i++) {
                    if (name.equals(names.get(i))) {
                        System.out.println("Въведете парола: ");
                        String password = input.nextLine();

                        while(true) {
                            if (password.equals(passwords.get(i))) {
                                if (password.equals(passwords.get(0)) && name.equals(names.get(0))){
                                    adminOptions();
                                }
                                else{
                                    employeeOptions();
                                }
                            } else {
                                System.out.println("Try again!");
                                password = input.nextLine();
                            }
                        }
                    }
                }
            } else {
                System.out.println("Try again!");
                name = input.nextLine();
            }
        }
    }

    public void adminOptions() throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("Влязохте като админ!\nМоля изберете една от 3-те опции: ");
        System.out.println("Първа опция е да се въведе клиент\nВтора опция е да се въведе служител\nТрета да се гледа статистика на служителите");
        int n = input.nextInt();
        switch(n){
            case 1:
                Admin option1 = new Admin();
                option1.addNewCustomer();
                break;
            case 2:
                Admin option2 = new Admin();
                option2.addNewEmployee();
                break;
            case 3:
                Admin option3 = new Admin();
                option3.readProtocols();
                break;
            case 4:
                Login();
            default:
                System.out.println("Моля изберете една от посочените горе опции!");
                n = input.nextInt();
        }
    }

    public void employeeOptions() throws IOException {
        Employee protocol1 = new Employee();
        Scanner input = new Scanner(System.in);
        System.out.println("Изберете опция 1 за протокол или опция 2 за изход");
        int n = input.nextInt();
        switch(n){
            case 1:
                protocol1.protocol();
                break;
            case 2:
                Login();
                break;
            default:
                System.out.println("Моля изберете една от посочените горе опции!");
                n = input.nextInt();
        }

    }
}
