package com.thoughtworks.springbootemployee.controller;

import com.thoughtworks.springbootemployee.model.Company;
import com.thoughtworks.springbootemployee.model.Employee;
import com.thoughtworks.springbootemployee.service.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    private CompanyService companyService;

    @GetMapping("/{id}")
    public Company getBy(@PathVariable int id) {
        return new Company(id, "alibaba");
    }

    @GetMapping("/{id}/employees")
    public List<Employee> getAllEmployees(@PathVariable int id) {
        Company company = new Company(id, "alibab");
        company.setEmployees(new ArrayList<>(Stream.of(new Employee(1,"male"),new Employee(2,"female")).collect(Collectors.toList())));
        return company.getEmployees();
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Company> getCompanies(@PathVariable Integer page, @PathVariable Integer pageSize) {
        if(page==null || pageSize == null){
            return companyService.getCompanies();
        }
        List<Company> companies = new ArrayList<>();
        companies.addAll(Arrays.asList(new Company(1, "1"),
                new Company(2, "2"), new Company(3, "3"),
                new Company(4, "4"), new Company(5, "5"),
                new Company(6, "6")));
        return companies.stream().filter(company -> (companies.indexOf(company) < pageSize*page &&
                companies.indexOf(company)>=(page-1)*pageSize)).collect(Collectors.toList());
    }

    @PostMapping()
    public Company addCompanies(@RequestBody Company company) {
        Company thisCompany = new Company(company.getId(), company.getName());
        return thisCompany;
    }

    @PutMapping("/{id}")
    public Company updateCompanies(@PathVariable int id,@RequestBody Company requestBody) {
        Company company = new Company(id,"alibaba");
        company.setId(requestBody.getId());
        company.setName(requestBody.getName());
        company.setEmployees(requestBody.getEmployees());
        company.setEmployeeNumber(requestBody.getEmployeeNumber());
        return company;
    }

    @DeleteMapping("/{id}")
    public List<Employee> deleteCompanies(@PathVariable int id) {
        Company company = new Company(id, "alibaba");
        company.getEmployees().add(new Employee(1));
        List<Employee> employees = company.getEmployees();
        company.getEmployees().removeAll(employees);
        return employees;
    }
}
