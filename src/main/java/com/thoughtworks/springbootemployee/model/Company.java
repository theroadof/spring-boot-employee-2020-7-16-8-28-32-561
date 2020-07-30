package com.thoughtworks.springbootemployee.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int employeeNumber;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "companyId")
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

    public Company(int id, String name, int employeeNumber, List<Employee> employees) {
        this.id = id;
        this.name = name;
        this.employeeNumber = employeeNumber;
        this.employees = employees;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Company company = (Company) o;
        return id == company.id &&
                employeeNumber == company.employeeNumber &&
                name.equals(company.name) &&
                employees.equals(company.employees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, employeeNumber, employees);
    }
}
