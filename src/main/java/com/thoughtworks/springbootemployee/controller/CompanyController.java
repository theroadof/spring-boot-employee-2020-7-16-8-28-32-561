package com.thoughtworks.springbootemployee.controller;

import com.thoughtworks.springbootemployee.model.Company;
import com.thoughtworks.springbootemployee.model.Employee;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    @GetMapping()
    public List<Company> getAllCompanies(){
        List<Company> companies = new ArrayList<>();
        companies.add(new Company(1,"alibaba"));
        companies.add(new Company(2,"tencent"));
        return companies;
    }

    @GetMapping("/{id}")
    public Company getBy(@PathVariable int id){
        return new Company(id,"alibaba");
    }

    @GetMapping("/{id}/employees")
    public List<Employee> getAllEmployees(@PathVariable int id){
        Company company = new Company(id,"alibab");
        return company.getEmployees();
    }

    @GetMapping("?page={page}&pageSize={pageSize}")
    public List<Company> getSpecificCompanies(@PathVariable int page, @PathVariable int pageSize){
        List<Company> companies = new ArrayList<>();
        companies.addAll(Arrays.asList(new Company(1,"1"),
                new Company(2,"2"),new Company(3,"3"),
                new Company(4,"4"),new Company(5,"5"),
                new Company(6,"6")));
        return companies.stream().filter(company -> (companies.indexOf(company)<=pageSize-page)).collect(Collectors.toList());
    }

    @PostMapping()
    public Company addCompanies(@RequestBody Company company){
        Company thisCompany = new Company(company.getId(),company.getName());
        return thisCompany;
    }

    @PutMapping("/{id}")
    public Company updateCompanies(@PathVariable int id ){
        Company thisCompany = new Company(id,"alibaba");
        thisCompany.setId(100);
        return thisCompany;
    }

    @DeleteMapping("/{id}")
    public List<Employee> deleteCompanies(@PathVariable int id){
        Company company = new Company(id,"alibaba");
        company.getEmployees().add(new Employee(1));
        List<Employee> employees = company.getEmployees();
        company.getEmployees().removeAll(employees);
        return employees;
    }
}
