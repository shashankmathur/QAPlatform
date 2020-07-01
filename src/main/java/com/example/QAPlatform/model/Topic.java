package com.example.QAPlatform.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(TopicCompositeId.class)
public class Topic {
    @Id
    private String questionId;
    @Id
    private String topicId;
    private String topic;
    private String subtopicId;
    private String subtopic;

    public Topic() {
    }

    public Topic(@JsonProperty("questionId") String questionId,
                 @JsonProperty("topicId") String topicId,
                 @JsonProperty("topic") String topic,
                 @JsonProperty("subtopicId") String subtopicId,
                 @JsonProperty("subtopic") String subtopic) {
        this.questionId = questionId;
        this.topicId = topicId;
        this.topic = topic;
        this.subtopicId = subtopicId;
        this.subtopic = subtopic;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getSubtopicId() {
        return subtopicId;
    }

    public void setSubtopicId(String subtopicId) {
        this.subtopicId = subtopicId;
    }

    public String getSubtopic() {
        return subtopic;
    }

    public void setSubtopic(String subtopic) {
        this.subtopic = subtopic;
    }
}
