package com.example.QAPlatform.model;

public class AnswerOutput {
    private String answerText;
    private String userId;
    private int numberOfLikes;
    private CommentOutput[] comments;

    public AnswerOutput() {
    }

    public AnswerOutput(String answerText, String userId, int numberOfLikes, CommentOutput[] comments) {
        this.answerText = answerText;
        this.userId = userId;
        this.numberOfLikes = numberOfLikes;
        this.comments = comments;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getNumberOfLikes() {
        return numberOfLikes;
    }

    public void setNumberOfLikes(int numberOfLikes) {
        this.numberOfLikes = numberOfLikes;
    }

    public CommentOutput[] getComments() {
        return comments;
    }

    public void setComments(CommentOutput[] comments) {
        this.comments = comments;
    }
}
