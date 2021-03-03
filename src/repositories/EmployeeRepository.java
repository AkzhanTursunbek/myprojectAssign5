package repositories;

import com.company.Projects;
import data.interfaces.IDBManager;
import entities.Employee;


import java.sql.*;
import java.util.ArrayList;

public class EmployeeRepository implements IEmployeeRepository {
    private final IDBManager dbManager;


    public EmployeeRepository(IDBManager dbManager) {
        this.dbManager = dbManager;
    }

    @Override
    public ArrayList<Employee> searchEmployeeByName(String name) {
        Connection connection = null;

        try {
            connection = dbManager.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM employee WHERE name LIKE '%" + name + "%';");

            ResultSet resultSet = preparedStatement.executeQuery();

            ArrayList<Employee> employees = new ArrayList<>();

            while (resultSet.next()) {
                Employee employee = new Employee(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("address"),
                        resultSet.getString("status"),
                        resultSet.getString("level"),
                        resultSet.getString("department"),
                        resultSet.getInt("salary"));

                employees.add(employee);
            }

            return employees;
        } catch ( Exception e ) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Employee getEmployeeById(int id) {
        Connection connection = null;
        try {
            connection = dbManager.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM employee WHERE id=?");

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            Employee employee = new Employee();

            if (resultSet.next()) {
                employee.setID(resultSet.getInt("id"));
                employee.setName(resultSet.getString("name"));
                employee.setAddress(resultSet.getString("address"));
                employee.setStatus(resultSet.getString("status"));
                employee.setLevel(resultSet.getString("level"));
                employee.setDepartment(resultSet.getString("department"));


            }

            return employee;
        } catch ( Exception e ) {
            e.printStackTrace();
        }

        return null;
    }


    @Override
    public boolean addEmployee(Employee employee) {
        Connection con = null;
        try {
            con = dbManager.getConnection();
            String sql = "INSERT INTO employee(id, name, address, status, level, position ,salary) VALUES(?,?,?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, employee.getID());
            st.setString(2, employee.getName());
            st.setString(3, employee.getAddress());
            st.setString(4, employee.getStatus());
            st.setString(5, employee.getLevel());
            st.setString(6, employee.getDepartment());
            st.setInt(7, employee.getSalary());
            st.execute();
            return true;
        } catch ( SQLException throwables ) {
            throwables.printStackTrace();
        } catch ( ClassNotFoundException e ) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean removeEmployeeById(int id) {

        Connection con = null;

        try {
            con = dbManager.getConnection();

            PreparedStatement ps = con.prepareStatement("DELETE FROM employee WHERE id=?");

            ps.setInt(1, id);

            ps.execute();

            return true;

        } catch ( SQLException | ClassNotFoundException throwables ) {
            throwables.printStackTrace();
        } finally {
            try {
                assert con == null;
                con.close();
            } catch ( SQLException throwables ) {
                throwables.printStackTrace();
            }
        }
        return false;
    }


    @Override
    public ArrayList showAllEmployees() {


        Connection con = null;

        try {
            con = dbManager.getConnection();

            PreparedStatement ps = con.prepareStatement("SELECT * FROM employee");
            ResultSet resultSet = ps.executeQuery();
            ArrayList<Employee> employees = new ArrayList<>();
            while (resultSet.next()) {
                Employee employee = new Employee(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("address"),
                        resultSet.getString("status"),
                        resultSet.getString("level"),
                        resultSet.getString("position"),
                        resultSet.getInt("salary"));

                employees.add(employee);
            }
            return employees;

        } catch ( Exception e ) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean addProject(Projects projects) {
        Connection con = null;
        try {
            con = dbManager.getConnection();
            String sql = "INSERT INTO projects(id,project_name,project_type,language,time_remaining,participants) VALUES(?,?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, projects.getProject_id());
            st.setString(2, projects.getProject_name());
            st.setString(3, projects.getProject_type());
            st.setString(4, projects.getLanguage());
            st.setInt(5, projects.getTime_remaining());
            st.setInt(6, projects.getParticipants());
            st.execute();
            return true;
        } catch ( SQLException throwables ) {
            throwables.printStackTrace();
        } catch ( ClassNotFoundException e ) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public ArrayList<Projects> showALLProjects() {


        Connection con = null;

        try {
            con = dbManager.getConnection();

            PreparedStatement ps = con.prepareStatement("SELECT * FROM projects");
            ResultSet resultSet = ps.executeQuery();
            ArrayList<Projects> projects = new ArrayList<>();
            while (resultSet.next()) {
                Projects project = new Projects(resultSet.getInt("id"),
                        resultSet.getString("project_name"),
                        resultSet.getString("project_type"),
                        resultSet.getString("language"),
                        resultSet.getInt("time_remaining"),
                resultSet.getInt("participants"));
                projects.add((project));
            }
            return projects;

        } catch ( Exception e ) {
            e.printStackTrace();
        }

        return null;
    }




    @Override
    public Projects InfoAboutProject(String project_name) {
        Connection connection = null;
        try {
            connection = dbManager.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM project WHERE name=?");

            preparedStatement.setString(1, project_name);

            ResultSet resultSet = preparedStatement.executeQuery();

            Projects projects = new Projects();

            if (resultSet.next()) {
                projects.setID(resultSet.getInt("id"));
                projects.setName(resultSet.getString("name"));
                projects.setAddress(resultSet.getString("address"));
                projects.setStatus(resultSet.getString("status"));
                projects.setLevel(resultSet.getString("level"));
                projects.setDepartment(resultSet.getString("department"));


            }

            return projects;
        } catch ( Exception e ) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public ArrayList<Employee> getEmployee_with_MaxSalary() {


        Connection con = null;

        try {
            con = dbManager.getConnection();

            PreparedStatement ps = con.prepareStatement("SELECT * FROM employee WHERE salary=(SELECT MAX(salary) from employee)");
            ResultSet resultSet = ps.executeQuery();

            ArrayList<Employee> employees = new ArrayList<>();
            while (resultSet.next()) {
                Employee employee = new Employee(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("address"),
                        resultSet.getString("status"),
                        resultSet.getString("level"),
                        resultSet.getString("position"),
                        resultSet.getInt("salary"));

                employees.add(employee);
            }
            return employees;

        } catch ( Exception e ) {
            e.printStackTrace();
        }

        return null;
    }
}
