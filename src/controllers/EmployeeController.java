package controllers;

import com.company.Projects;
import entities.Employee;
import repositories.IEmployeeRepository;


import java.util.ArrayList;


public class EmployeeController {
    private final IEmployeeRepository employeeRepository;

    public EmployeeController(IEmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public String searchEmployeeByName(String name) {
        String result = employeeRepository.searchEmployeeByName(name).toString();

        return result;
    }

    public String getEmployeeById(int id) {
        String result = employeeRepository.getEmployeeById(id).toString();

        return result;
    }


    public String removeEmployeeById(int id) {
        boolean removed = employeeRepository.removeEmployeeById(id);

        if (removed) {
            return "Employee was removed!";
        }

        return "Employee was not removed!";
    }

    public String addEmployee(int id, String name, String address, String status, String level, String department, int salary) {

        Employee employee = new Employee(id, name, address, status, level, department, salary);
        boolean added = employeeRepository.addEmployee(employee);

        if (added) {
            return "Employee was added!";
        }

        return "Employee was not added!";

    }



    public String addProject(int project_id,String project_name, String project_type, String language, int time_remaining, int participants) {

        Projects project = new Projects(project_id,project_name, project_type, language, time_remaining,participants);
        boolean added = employeeRepository.addProject(project);

        if (time_remaining == 0 || time_remaining > 0) {
            return "Thank you, project was added! And the team got bonus in " + (time_remaining*0.86) + "$ for early done.";
        } else if (time_remaining < 0) {
            return "Thank you, project was added! And the team got penalty in " +  (time_remaining*0.86) + "$ for late";
        } else {
            return  "Thank you, project was added! And the team got penalty in " +  (time_remaining*0.86) + "$ for late";
        }



    }
    public ArrayList<Employee> getEmployee_with_MaxSalary() {
        ArrayList<Employee> employees = new ArrayList<>();
        employees = employeeRepository.getEmployee_with_MaxSalary();

        return employees;
    }



    public String InfoAboutProject(String project_name) {
        String result = employeeRepository.InfoAboutProject(project_name).toString();

        return result;
    }


    public ArrayList<Employee> showAllEmployees() {
        ArrayList<Employee> employees = new ArrayList<>();
        employees = employeeRepository.showAllEmployees();

        return employees;
    }
    public ArrayList<Projects> showAllProjects() {
        ArrayList<Projects> projects = new ArrayList<>();
        projects = employeeRepository.showALLProjects();

        return projects;
    }
}


