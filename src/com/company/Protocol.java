package com.company;

public class Protocol {
    private String customerNames;
    private String spentTimeOnCustomers;
    private String author;

    public String customerNamesGetter(){
        return this.customerNames;
    }

    public String spentTimeOnCustomersGetter(){
        return this.spentTimeOnCustomers;
    }

    public String authorGetter(){
        return this.author;
    }

    public void customerNamesSetter(String customerNames){
        this.customerNames = customerNames;
    }

    public void spentTimeOnCustomersSetter(String spentTimeOnCustomers){
        this.spentTimeOnCustomers = spentTimeOnCustomers;
    }

    public void authorSetter(String author){
        this.author = author;
    }
}
