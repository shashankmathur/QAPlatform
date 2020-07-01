package com.example.QAPlatform.controller;

import com.example.QAPlatform.model.Company;
import com.example.QAPlatform.service.CompanyManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RequestMapping(value = "/api/v1",consumes = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class CompanyController {

    @Autowired
    CompanyManager manager;

    @PostMapping("/company")
    @ResponseBody
    public void addCompany(@RequestBody Company company){
        manager.addCompany(company);
    }

    @GetMapping("/company/{id}")
    @ResponseBody
    public Optional<Company> getCompany(@PathVariable String id){
        return manager.getCompany(id);
    }

    @DeleteMapping("/company/{id}")
    @ResponseBody
    public void deleteCompany(@PathVariable String id){
        manager.deleteCompany(id);
    }

    @PostMapping("/company/{id}")
    @ResponseBody
    public Optional<Company> updateCompany(@PathVariable String id, @RequestBody Company company){
        return manager.updateCompany(company,id);
    }
}
