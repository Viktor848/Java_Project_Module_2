package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class LoginPage extends Admin {
    public ArrayList<String> names = new ArrayList<>();
    public ArrayList<String> passwords = new ArrayList<>();

    public void Login() {
        System.out.println("Въведете име: ");
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        this.names.add("admin");
        while (true) {
            for (int i = 0; i < names.toArray().length; i++) {
                if (name.equals(names.get(i))) {
                    System.out.println("Success!");
                    System.out.println("Въведете парола: ");
                    String password = input.nextLine();
                    passwords.add("admin123");
                    passwords.add(password);
                    for (int j = i; j < passwords.toArray().length; j++) {
                        if (password.equals(passwords.get(i))) {
                            System.out.println("Success");
                            //The admin options...

                        } else {
                            System.out.println("Try again!");
                            password = input.nextLine();
                        }
                    }
                } else {
                    System.out.println("Try again!");
                    name = input.nextLine();
                }
            }
        }
    }
}
