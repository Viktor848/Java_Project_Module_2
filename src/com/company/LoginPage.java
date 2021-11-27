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

    public void Login(Scanner input) throws IOException {
        namesAndPasswords();
        System.out.println("Въведете име: ");
        try {
            String name = input.nextLine();
            while (true) {
                if (names.contains(name)) {
                    for (int i = 0; i < names.size(); i++) {
                        if (name.equals(names.get(i))) {
                            System.out.println("Въведете парола: ");
                            String password = input.nextLine();
                            try {
                                while (true) {
                                    if (password.equals(passwords.get(i))) {
                                        if (password.equals(passwords.get(0)) && name.equals(names.get(0))) {
                                            adminOptions(input);
                                        } else {
                                            employeeOptions(input);
                                        }
                                    } else {
                                        System.out.println("Try again!");
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
                    name = input.nextLine();
                }
            }
        }
        catch (Exception e){
            System.out.println("Грешни входни данни!");
        }
    }

    @Override
    public void adminOptions(Scanner input) throws IOException {
        System.out.println("Влязохте като админ!\nМоля изберете една от 3-те опции: ");
        System.out.println("Първа опция е да се въведе клиент\nВтора опция е да се въведе служител\n" +
                "Трета да се гледа статистика на служителите\nЧетвърта опция е за изход");
        try {
            int n = input.nextInt();
            switch (n) {
                case 1:
                    Admin option1 = new Admin();
                    option1.addNewCustomer(input);
                    break;
                case 2:
                    Admin option2 = new Admin();
                    option2.addNewEmployee(input);
                    break;
                case 3:
                    Admin option3 = new Admin();
                    option3.readProtocols();
                    break;
                case 4:
                    Login(input);
                default:
                    System.out.println("Моля изберете една от посочените горе опции!");
                    n = input.nextInt();
            }
        }
        catch (Exception e){
            System.out.println("Грешни входни данни!");
        }
    }

    @Override
    public void employeeOptions(Scanner input) throws IOException {
        Employee protocol1 = new Employee();
        System.out.println("Изберете опция 1 за протокол или опция 2 за изход");
        try {
            int n = input.nextInt();
            switch (n) {
                case 1:
                    protocol1.protocol(input);
                    break;
                case 2:
                    Login(input);
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
