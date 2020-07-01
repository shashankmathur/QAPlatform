package com.example.QAPlatform.model;

import java.time.LocalDate;

public class CommentOutput {
    private String comment;
    private LocalDate date;
    private String userName;

    public CommentOutput() {
    }

    public CommentOutput(String comment, LocalDate date, String userName) {
        this.comment = comment;
        this.date = date;
        this.userName = userName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
