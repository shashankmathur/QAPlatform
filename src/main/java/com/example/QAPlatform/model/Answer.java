package com.example.QAPlatform.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.UUID;
@Entity
public class Answer {
    @Id
    private String answerId;
    private String questionId;
    private String answer;
    private String userId;
    private LocalDate createdOn;

    public Answer() {
    }

    public Answer(@JsonProperty("answerId") String answerId,
                  @JsonProperty("questionId") String questionId,
                  @JsonProperty("answer") String answer,
                  @JsonProperty("userId") String userId) {
        this.answerId = answerId;
        this.questionId = questionId;
        this.answer = answer;
        this.userId = userId;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getAnswerId() {
        return answerId;
    }

    public void setAnswerId(String answerId) {
        this.answerId = answerId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public LocalDate getDate() {
        return createdOn;
    }

    public void setDate(LocalDate createdOn) {
        this.createdOn = createdOn;
    }
}
