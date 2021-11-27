package com.company;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public interface adminInterface {
     void addNewEmployee() throws IOException;
     void addNewCustomer() throws IOException;
     void readProtocols() throws FileNotFoundException;
}
