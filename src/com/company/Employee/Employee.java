package com.company.Employee;

public class Employee {
    private String name;
    private String password;

    public String nameGetter(){
        return this.name;
    }

    public String passwordGetter(){
        return this.password;
    }

    public void nameSetter(String name){
        this.name = name;
    }

    public void passwordSetter(String password){
        this.password = password;
    }
}
