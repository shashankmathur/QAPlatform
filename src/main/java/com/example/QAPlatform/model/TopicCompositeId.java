package com.example.QAPlatform.model;

import java.io.Serializable;

public class TopicCompositeId implements Serializable {

    private String questionId;
    private String topicId;

    public TopicCompositeId() {
    }

    public TopicCompositeId(String questionId, String topicId) {
        this.questionId = questionId;
        this.topicId = topicId;
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

        TopicCompositeId topicCompositeId = (TopicCompositeId) obj;

        return (topicCompositeId.questionId.equals(this.questionId)  && topicCompositeId.topicId.equals(this.topicId));
    }
}
