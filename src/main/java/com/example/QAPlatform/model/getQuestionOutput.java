package com.example.QAPlatform.model;

public class getQuestionOutput {
    private String questionText;
    private AnswerOutput[] answers;
    private int numberOfLikes;
    private String[] companies;
    private String[] tags;
    private String[] topics;

    public getQuestionOutput() {
    }

    public getQuestionOutput(String questionText, AnswerOutput[] answers, int numberOfLikes, String[] companies, String[] tags, String[] topics) {
        this.questionText = questionText;
        this.answers = answers;
        this.numberOfLikes = numberOfLikes;
        this.companies = companies;
        this.tags = tags;
        this.topics = topics;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public AnswerOutput[] getAnswers() {
        return answers;
    }

    public void setAnswers(AnswerOutput[] answers) {
        this.answers = answers;
    }

    public int getNumberOfLikes() {
        return numberOfLikes;
    }

    public void setNumberOfLikes(int numberOfLikes) {
        this.numberOfLikes = numberOfLikes;
    }

    public String[] getCompanies() {
        return companies;
    }

    public void setCompanies(String[] companies) {
        this.companies = companies;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public String[] getTopics() {
        return topics;
    }

    public void setTopics(String[] topics) {
        this.topics = topics;
    }
}
