package com.company;

import java.util.Date;

public class Customer {
    private String name;
    private String projectName;
    private String dateOfEndOfTheProject;

    public String nameGetter(){
        return this.name;
    }

    public String projectNameGetter(){
        return this.projectName;
    }

    public String dateOfEndOfTheProjectGetter(){
        return this.dateOfEndOfTheProject;
    }

    public void nameSetter(String name){
        this.name = name;
    }

    public void projectNameSetter(String projectName){
        this.projectName = projectName;
    }

    public void dateOfEndOfTheProjectSetter(String dateOfEndOfTheProject){
        this.dateOfEndOfTheProject = dateOfEndOfTheProject;
    }
}
