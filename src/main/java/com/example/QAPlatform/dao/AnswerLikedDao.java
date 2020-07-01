package com.example.QAPlatform.dao;

import com.example.QAPlatform.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



@Repository
public interface AnswerLikedDao extends JpaRepository<AnswerLikes, AnswerLikedId> {
}
