package com.example.QAPlatform.dao;

import com.example.QAPlatform.model.QuestionCompanyMapping;
import com.example.QAPlatform.model.QuestionCompanyMappingId;
import com.example.QAPlatform.model.TagId;
import com.example.QAPlatform.model.Tags;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface QuestionCompanyMappingDao extends JpaRepository<QuestionCompanyMapping, QuestionCompanyMappingId> {
}

