package com.example.QAPlatform.model;

import java.io.Serializable;

public class QuestionCompanyMappingId implements Serializable {

    private String questionId;
    private String companyId;

    public QuestionCompanyMappingId() {
    }

    public QuestionCompanyMappingId(String questionId, String companyId) {
        this.questionId = questionId;
        this.companyId = companyId;
    }

    @Override
    public int hashCode()
    {
        return (int) (Math.random()*100000);
    }

    @Override
    public boolean equals(Object obj)
    {

        if(this == obj)
            return true;

        if(obj == null || obj.getClass()!= this.getClass())
            return false;

        QuestionCompanyMappingId questionCompanyMappingId = (QuestionCompanyMappingId) obj;

        return (questionCompanyMappingId.questionId.equals(this.questionId)  && questionCompanyMappingId.companyId.equals(this.companyId));
    }
}
