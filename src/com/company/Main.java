package com.company;

import controllers.EmployeeController;
import data.DBManager;
import data.interfaces.IDBManager;
import repositories.EmployeeRepository;
import repositories.IEmployeeRepository;

public class Main {
    public static void main(String[] args) {
        IDBManager dbManager = new DBManager();
        IEmployeeRepository employeeRepository = new EmployeeRepository(dbManager);
        EmployeeController employeeController = new EmployeeController(employeeRepository);
        Projects projects= new Projects(employeeRepository);
        MyApplication myApplication = new MyApplication(employeeController,projects);
        myApplication.start();


    }
}

