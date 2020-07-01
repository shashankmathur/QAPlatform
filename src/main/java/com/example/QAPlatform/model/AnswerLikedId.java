package com.example.QAPlatform.model;

import java.io.Serializable;

public class AnswerLikedId implements Serializable {

    private String answerId;
    private String userId;

    public AnswerLikedId() {
    }

    public AnswerLikedId(String answerId, String userId) {
        this.answerId = answerId;
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

        AnswerLikedId answerLikedId = (AnswerLikedId) obj;

        return (answerLikedId.answerId.equals(this.answerId)  && answerLikedId.userId.equals(this.userId));
    }
}
