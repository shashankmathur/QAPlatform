package com.example.QAPlatform.model;

import java.io.Serializable;

public class TagId implements Serializable {

    private String questionId;
    private String tag;

    public TagId() {
    }

    public TagId(String questionId, String tag) {
        this.questionId = questionId;
        this.tag = tag;
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

        TagId tagId = (TagId) obj;

        return (tagId.questionId.equals(this.questionId)  && tagId.tag.equals(this.tag));
    }
}
