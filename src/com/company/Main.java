package com.company;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        LoginPage login = new LoginPage();
        Scanner input = new Scanner(System.in);
        login.Login(input);
    }
}
