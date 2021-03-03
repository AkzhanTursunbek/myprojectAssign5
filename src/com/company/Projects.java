package com.company;

import entities.Employee;
import repositories.IEmployeeRepository;

public class Projects extends Employee {
    private int project_id;
    private String project_name;
    private String project_type;
    private String language;
    private int time_remaining;
    private int participants;

    private  IEmployeeRepository employeeRepository;
public Projects(){

}
    public Projects(int project_id,String project_name, String project_type, String language,int time_remaining,int participants) {
       setProject_id(project_id);
        setProject_name(project_name);
       setProject_type(project_type);
       setLanguage(language);
       setTime_remaining(time_remaining);
       setParticipants(participants);
    }

    public int getParticipants() {
        return participants;
    }

    public void setParticipants(int participants) {
        this.participants = participants;
    }

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public Projects(IEmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public String getProject_type() {
        return project_type;
    }

    public void setProject_type(String project_type) {
        this.project_type = project_type;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getTime_remaining() {
        return time_remaining;
    }

    public void setTime_remaining(int time_remaining) {
        this.time_remaining = time_remaining;
    }

    @Override
    public String toString() {
        return " \n _______________________ \n" + " Project #" + project_id + "\n " +
                "\n   project name" + project_name  +
                ",\n \n  project type:" + project_type +
                ",\n \n  language:" + language +
                ",\n \n  have been finished for " + time_remaining + " days before" +
                ",\n \n count pf participants" + participants;


    }

}
