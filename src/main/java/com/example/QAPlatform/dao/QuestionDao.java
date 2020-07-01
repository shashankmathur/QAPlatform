package com.example.QAPlatform.dao;

import com.example.QAPlatform.model.Company;
import com.example.QAPlatform.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionDao extends JpaRepository<Question, String> {
}
