package com.thoughtworks.springbootemployee.repository;

import com.thoughtworks.springbootemployee.model.Company;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository {
    List<Company> findAll();
}
