package com.example.QAPlatform.model;

public class FilterQuestionOutput {
    private String questionId;
    private String question;
    private String[] companies;
    private int likes;
    private String mostLikedAnswer;
    private String[] tags;

    public FilterQuestionOutput() {
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String[] getCompanies() {
        return companies;
    }

    public void setCompanies(String[] companies) {
        this.companies = companies;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getMostLikedAnswer() {
        return mostLikedAnswer;
    }

    public void setMostLikedAnswer(String mostLikedAnswer) {
        this.mostLikedAnswer = mostLikedAnswer;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }
}
