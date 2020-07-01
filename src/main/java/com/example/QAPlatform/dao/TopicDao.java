package com.example.QAPlatform.dao;

import com.example.QAPlatform.model.TagId;
import com.example.QAPlatform.model.Tags;
import com.example.QAPlatform.model.Topic;
import com.example.QAPlatform.model.TopicCompositeId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
    public interface TopicDao extends JpaRepository<Topic, TopicCompositeId> {
}
