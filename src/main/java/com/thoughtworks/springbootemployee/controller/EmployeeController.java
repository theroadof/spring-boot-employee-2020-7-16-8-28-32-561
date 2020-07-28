package com.thoughtworks.springbootemployee.controller;

import com.thoughtworks.springbootemployee.model.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @GetMapping
    public List<Employee> getAll(){
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1));
        employees.add(new Employee(2));
        return employees;
    }

    @GetMapping("/{id}")
    public Employee getByID(@PathVariable int id){
        return new Employee(id);
    }

    @GetMapping("?page={page}&pageSize={pageSize}")
    public List<Employee> getSpecificEmployees(@PathVariable int page,@PathVariable int pageSize){
        List<Employee> employees = new ArrayList<>();
        employees.addAll(Stream.of(new Employee(1),new Employee(2),new Employee(3),new Employee(4),new Employee(5),new Employee(6))
                .collect(Collectors.toList()));
        return employees.stream().filter(company -> (employees.indexOf(company)<=pageSize-page)).collect(Collectors.toList());
    }

    @GetMapping("?gender={gender}")
    public List<Employee> getByGender(@PathVariable String gender){
        return Stream.of(new Employee(1,"male"),new Employee(2,"female"),new Employee(3,"male"))
                .filter(employee -> (employee.getGender().equals(gender))).collect(Collectors.toList());
    }

    @PostMapping()
    public Employee addEmployee(@RequestBody Employee employee){
        Employee newEmployee = new Employee(employee.getId(),employee.getGender());
        return newEmployee;
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable int id){
        Employee employee = new Employee(id,"male");
        employee.setGender("female");
        return employee;
    }

    @DeleteMapping("/{id}")
    public Employee deleteEmployee(@PathVariable int id){
        Employee employee = new Employee(id,"male");
        return employee;
    }
}
