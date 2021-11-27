package com.company;

import java.io.IOException;
import java.util.Scanner;

public interface adminInterface {
     void readProtocols(Scanner input)throws IOException;
     void addNewEmployee(Scanner input) throws IOException;
     void addNewCustomer(Scanner input) throws IOException;
}
