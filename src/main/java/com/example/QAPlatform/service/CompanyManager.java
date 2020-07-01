package com.example.QAPlatform.service;

import com.example.QAPlatform.dao.CompanyDao;
import com.example.QAPlatform.model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CompanyManager {

    @Autowired
    CompanyDao companyDao;

    public void addCompany(Company company){
        company.setCompanyId(UUID.randomUUID().toString());
        company.setCreatedOn(java.time.LocalDate.now());
        companyDao.save(company);
    }

    public Optional<Company> getCompany(String id){
        return companyDao.findById(id);
    }

    public void deleteCompany(String id){
        companyDao.deleteById(id);
    }

    public Optional<Company> updateCompany(Company company, String id)
    {
        company.setCompanyId(id);
        company.setCreatedOn(java.time.LocalDate.now());
        companyDao.save(company);
        return companyDao.findById(company.getCompanyId());
    }

}
