package entities;

public class Employee {
    private int ID;
    private String name;
    private String address;
    private String status;
    private String level;
    private String department;
    private int salary;


    public Employee(int ID, String name, String address, String status, String level, String department, int salary) {
        setID(ID);
        setName(name);
        setAddress(address);
        setStatus(status);
        setLevel(level);
        setDepartment(department);
        setSalary(salary);

    }
    public Employee(){

    }

    public Employee(int salary) {
        getSalary();
    }


    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID= ID;
    }

    public  String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLevel(String Level){
        this.level=Level;
    }
    public String getLevel(){
        return level;
    }
    public void setStatus(String status){
        this.status=status;
    }
    public String getStatus(){
        return status;
    }
    public void setAddress(String address){
        this.address=address;
    }
    public String getAddress(){

        return address;
    }

    public void setDepartment(String department){
        this.department=department;
    }
    public String getDepartment(){
        return department;
    }

    @Override
    public String toString() {
        return " \n _______________________ \n" + " Participant №" +  ID  +
                ",\n \n  name:'" + name  +
                ",\n \n  address:" + address +
                ",\n \n  status:" + status +
                ",\n \n  level:" + level +
                ",\n \n  position:'" + department  +
                ",\n \n  salary:" + salary + "$ per month";
    }



}