package com.example.QAPlatform.dao;

import com.example.QAPlatform.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerDao extends JpaRepository<Answer, String> {
}
