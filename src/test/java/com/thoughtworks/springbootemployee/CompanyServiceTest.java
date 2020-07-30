package com.thoughtworks.springbootemployee;

import com.thoughtworks.springbootemployee.model.Company;
import com.thoughtworks.springbootemployee.model.Employee;
import com.thoughtworks.springbootemployee.repository.CompanyRepository;
import com.thoughtworks.springbootemployee.service.CompanyService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class CompanyServiceTest {

    @InjectMocks
    private CompanyService companyService;

    @Mock
    private CompanyRepository companyRepository;

    @Test
    void should_return_all_companies_when_get_companies_given_none() {
        //given
        when(companyRepository.findAll()).thenReturn(asList(
                new Company(1,"alibaba",2,asList(new Employee(1,"male",22,"zero",9000,1),new Employee(2,"male",22,"austin",9000,1)))
                ,new Company(2,"tencent",1,singletonList(new Employee(3,"male",23,"teddy",9000,2)))));

        //when
        List<Company> companies = companyService.getCompanies();

        //then
        assertEquals(2,companies.size());
        assertEquals(1,companies.get(0).getId());
        assertEquals(2,companies.get(1).getId());
    }

    private List<Company> getAllCompanies(){
        return null;
    }
}
