package com.thoughtworks.springbootemployee.model;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private int id;
    private String name;
    private int employeeNumber;
    private List<Employee> employees;

    public Company(int id, String name, List<Employee> employees) {
        this.id = id;
        this.name = name;
        this.employeeNumber = employees.size();
        this.employees = employees;
    }

    public Company(int id, String name) {
        this.id = id;
        this.name = name;
        employees = new ArrayList<>();
    }
    public Company(){}

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }
}
