package com.example.QAPlatform.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(QuestionCompanyMappingId.class)
public class QuestionCompanyMapping {
    @Id
    private String questionId;
    @Id
    private String companyId;

    public QuestionCompanyMapping() {
    }

    public QuestionCompanyMapping(@JsonProperty("questionId") String questionId, @JsonProperty("companyId") String companyId) {
        this.questionId = questionId;
        this.companyId = companyId;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }
}
