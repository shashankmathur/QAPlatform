package com.example.QAPlatform.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.time.LocalDate;
import java.util.UUID;
@Entity
@IdClass(AnswerLikedId.class)
public class AnswerLikes {
    @Id
    private String answerId;
    @Id
    private String userId;
    private LocalDate createdOn;

    public AnswerLikes() {
    }

    public AnswerLikes(@JsonProperty("answerId") String answerId, @JsonProperty("userId") String userId, @JsonProperty("createdOn") LocalDate createdOn) {
        this.answerId = answerId;
        this.userId = userId;
        this.createdOn = createdOn;
    }

    public String getAnswerId() {
        return answerId;
    }

    public void setAnswerId(String answerId) {
        this.answerId = answerId;
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
