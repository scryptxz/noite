package com.litter.litter.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    public static Post convert(Map<String,Object> register) {
        String content = (String) register.get("content");
        return new Post(content);
    }

    public static ArrayList<Post> convertAll(List<Map<String,Object>> registers) {
        ArrayList<Post> aux = new ArrayList<>();
        for(Map<String,Object> register : registers) {
            aux.add(convert(register));
        }
        return aux;
    }
}
