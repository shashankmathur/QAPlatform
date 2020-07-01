package com.example.QAPlatform.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.time.LocalDate;
import java.util.UUID;
@Entity
@IdClass(QuestionLikedId.class)
public class QuestionLikes {
    @Id
    private String questionId;
    @Id
    private String userId;
    private LocalDate createdOn;

    public QuestionLikes() {
    }

    public QuestionLikes(@JsonProperty("questionId") String questionId, @JsonProperty("userId") String userId) {
        this.questionId = questionId;
        this.userId = userId;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public LocalDate getLikedOn() {
        return createdOn;
    }

    public void setLikedOn(LocalDate likedOn) {
        this.createdOn = likedOn;
    }
}
