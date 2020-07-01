package com.example.QAPlatform.dao;

import com.example.QAPlatform.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyDao extends JpaRepository<Company, String> {


}
