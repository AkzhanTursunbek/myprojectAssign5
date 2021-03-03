package repositories;

import com.company.Projects;
import entities.Employee;

import java.util.ArrayList;

public interface IEmployeeRepository {
    ArrayList<Employee> searchEmployeeByName(String name);
    Employee getEmployeeById(int id);
    boolean addEmployee(Employee employee);
    boolean removeEmployeeById(int id);
    ArrayList<Employee> showAllEmployees();
    ArrayList<Projects> showALLProjects();
    boolean addProject(Projects projects);
    Projects InfoAboutProject(String name);
    ArrayList<Employee> getEmployee_with_MaxSalary();
    }
