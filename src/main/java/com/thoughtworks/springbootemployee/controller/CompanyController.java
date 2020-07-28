package com.thoughtworks.springbootemployee.controller;

import com.thoughtworks.springbootemployee.model.Company;
import com.thoughtworks.springbootemployee.model.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    @GetMapping()
    public List<Company> getAllCompanies(){
        List<Company> companies = new ArrayList<>();
        companies.add(new Company(1));
        companies.add(new Company(2));
        return companies;
    }

    @GetMapping("/{id}")
    public Company getBy(@PathVariable int id){
        return new Company(id);
    }

    @GetMapping("/{id}/employees")
    public List<Employee> getAllEmployees(@PathVariable int id){
        Company company = new Company(id);
        List<Employee> employees = company.getEmployees();
        return employees;
    }

    @GetMapping("/companies")
    public List<Employee> getSpecificEmployees(@PathParam("page") int page,@PathParam("pageSize") int pageSize){
        return null;
    }

}
