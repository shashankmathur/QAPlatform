package com.example.QAPlatform.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class QuestionInput {
    private String questionText;
    private String companyId;
    private String topicId;
    private String subtopicId;
    private String[] tags;
    private String userId;

    public QuestionInput(@JsonProperty("questionText") String questionText,
                         @JsonProperty("companyId") String companyId,
                         @JsonProperty("topicId") String topicId,
                         @JsonProperty("subtopicId") String subtopicId,
                         @JsonProperty("tags") String[] tags,
                         @JsonProperty("userId") String userId) {
        this.questionText = questionText;
        this.companyId = companyId;
        this.topicId = topicId;
        this.subtopicId = subtopicId;
        this.tags = tags;
        this.userId = userId;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }

    public String getSubtopicId() {
        return subtopicId;
    }

    public void setSubtopicId(String subtopicId) {
        this.subtopicId = subtopicId;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
