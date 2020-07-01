package com.example.QAPlatform.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(TagId.class)
public class Tags {
    @Id
    private String questionId;
    @Id
    private String tag;

    public Tags() {
    }

    public Tags(@JsonProperty("questionId") String questionId, @JsonProperty("tag") String tag) {
        this.questionId = questionId;
        this.tag = tag;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
