package com.noite.noite.model;
public class Post {
    private String content;

    public Post(){};

    public Post(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
