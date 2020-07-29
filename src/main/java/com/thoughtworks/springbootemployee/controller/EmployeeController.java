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
    public List<Employee> getAll() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1));
        employees.add(new Employee(2));
        return employees;
    }

    @GetMapping("/{id}")
    public Employee getByID(@PathVariable int id) {
        return new Employee(id);
    }

    @GetMapping("/page/{page}/page-size/{pageSize}")
    public List<Employee> getSpecificEmployees(@PathVariable String page, @PathVariable String pageSize) {
        int pageNumber = Integer.valueOf(page);
        int pageSizeNumber = Integer.valueOf(pageSize);
        List<Employee> employees = Stream.of(new Employee(1), new Employee(2), new Employee(3), new Employee(4), new Employee(5), new Employee(6)).collect(Collectors.toList());
        return employees.stream().filter(employee -> (employees.indexOf(employee) < pageSizeNumber*pageNumber &&
                employees.indexOf(employee)>= (pageNumber-1)*pageSizeNumber)).collect(Collectors.toList());
    }

    @GetMapping("/gender/{gender}")
    public List<Employee> getByGender(@PathVariable String gender) {
        return Stream.of(new Employee(1, "male"), new Employee(2, "female"), new Employee(3, "male"))
                .filter(employee -> (employee.getGender().equals(gender))).collect(Collectors.toList());
    }

    @PostMapping()
    public Employee addEmployee(@RequestBody Employee employee) {
        Employee newEmployee = new Employee(employee.getId(), employee.getGender());
        return newEmployee;
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable int id,@RequestBody Employee requestBody) {
        Employee employee = new Employee(id, "male");
        employee.setGender(requestBody.getGender());
        employee.setId(requestBody.getId());
        return employee;
    }

    @DeleteMapping("/{id}")
    public Employee deleteEmployee(@PathVariable int id) {
        Employee employee = new Employee(id, "male");
        return employee;
    }
}
