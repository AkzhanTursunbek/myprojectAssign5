package com.company;

import controllers.EmployeeController;
import entities.Employee;

import java.util.ArrayList;
import java.util.Scanner;

public class MyApplication {
    private final EmployeeController employeeController;
    private final Projects projects;
    private final Scanner scanner;
    public MyApplication(EmployeeController employeeController, Projects projects) {
        this.employeeController = employeeController;
        this.projects=projects;
        scanner = new Scanner(System.in);
    }


    public void start() {
        while (true) {
            System.out.println("Choose one option:\n 1) Add new Project\n 2) Search for any employee by name\n 3) Search for any employee by id\n 4) Remove employee\n 5) Show all employees\n 6) InfoAboutProject\n 7) Get employee with Max Salary \n" + " 0) Exit\n");
            int choice = scanner.nextInt();

            if (choice == 1) {
           addProject();
            }
            else if (choice == 2) {
                searchEmployeeByName();
            } else if (choice == 3) {
                getEmployeeById();
            } else if (choice == 4) {
                removeEmployeeById();
            }
            else if (choice == 5) {

            }
            else if (choice == 6) {
                InfoAboutProject();
            }
            else if (choice == 7) {
                getEmployee_with_MaxSalary();
            }
                else {
                break;
            }

            System.out.println("____________________________");
        }
    }



    public void searchEmployeeByName() {
        System.out.println("Write the name of employee!");
        String name = scanner.next();
        String result = String.valueOf(employeeController. searchEmployeeByName(name));
        System.out.println(result);
    }

    public void getEmployeeById() {
        System.out.println("Write the id of employee!");
        int id = scanner.nextInt();
        String result = employeeController.getEmployeeById(id);
        System.out.println(result);
    }



    public void removeEmployeeById() {
        System.out.println("Write employee's id!");
        int id = scanner.nextInt();

        String result = String.valueOf(employeeController.removeEmployeeById(id));

        System.out.println(result);
    }


    public void addProject() {
        System.out.println("Write project's id");
        int project_id = scanner.nextInt();
        System.out.println("Write project's name");
        String project_name = scanner.next();
        System.out.println("Write project's type! \n Web-site/Game/DataBase");
        String project_type = scanner.next();
        System.out.println("In what language project is needed? \n PHP/Java/SQLite/MongoDB/CSS/HTML");
        String language = scanner.next();
        System.out.println("When project had been finished? \n If late for n days, please write with minus in front!");
        int time_remaning = scanner.nextInt();
        System.out.println("How many participants are there?");
        int partcipants = scanner.nextInt();

        String result;
        result = employeeController.addProject(project_id,project_name, project_type, language, time_remaning,partcipants);
        int k = 0;
while (k!=partcipants) {
    System.out.println("Write employee's id");
    int id = scanner.nextInt();
    System.out.println("Write employee's name");
    String name = scanner.next();
    System.out.println("Write employee's Address!");
    String Address = scanner.next();
    System.out.println("Write employee's status \n EXAMPLE: Single/married/divorced/in Relationship");
    String status = scanner.next();
    System.out.println("Write employee's level \n EXAMPLE:Intern/junior/middle/senior/architect");
    String level = scanner.next();
    System.out.println("Write employee's position \n EXAMPLE: Backend-developer/frontend-developer/manager");
    String Department = scanner.next();
    System.out.println("Write employee's salary");
    int salary = scanner.nextInt();



    String result1;
    result1 = employeeController.addEmployee(id, name, Address, status, level, Department,salary);

    System.out.println(result1);
    k++;
}
k=0;
        System.out.println(result);
    }

    public void InfoAboutProject(){
        System.out.println("Write the name of the project!");
        String project_name = scanner.next();
        String result = employeeController.InfoAboutProject(project_name);
        System.out.println(result);


        ArrayList<Employee> result1 = employeeController.showAllEmployees();
        System.out.println("Participants: ");
        System.out.println(result1);

    }


    public void getEmployee_with_MaxSalary() {
        ArrayList<Employee> result = employeeController.getEmployee_with_MaxSalary();
        System.out.println("The list of employees:");
        System.out.println(result);
    }

   }










