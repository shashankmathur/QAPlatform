package com.example.QAPlatform.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.UUID;
@Entity
public class Comment {
    @Id
    private String commentId;
    private String answerId;
    private String userId;
    private String comment;
    private LocalDate createdOn;

    public Comment() {
    }

    public Comment(@JsonProperty("commentId") String commentId,
                   @JsonProperty("answerId") String answerId,
                   @JsonProperty("userId")String userId,
                   @JsonProperty("comment") String comment) {
        this.commentId = commentId;
        this.answerId = answerId;
        this.userId = userId;
        this.comment = comment;
    }

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDate getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDate createdOn) {
        this.createdOn = createdOn;
    }
}
