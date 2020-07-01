package com.example.QAPlatform.model;

import java.io.Serializable;

public class QuestionLikedId implements Serializable {

    private String questionId;
    private String userId;

    public QuestionLikedId() {
    }

    public QuestionLikedId(String questionId, String userId) {
        this.questionId = questionId;
        this.userId = userId;
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

        QuestionLikedId questionLikedId = (QuestionLikedId) obj;

        return (questionLikedId.questionId.equals(this.questionId)  && questionLikedId.userId.equals(this.userId));
    }
}
