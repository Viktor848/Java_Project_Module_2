package com.company;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public interface adminInterface {
     void addNewEmployee(Scanner input) throws IOException;
     void addNewCustomer(Scanner input) throws IOException;
     void readProtocols() throws FileNotFoundException;
}
