package com.litter.litter.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Post {

    private String content;
    private String uuid;

    public Post() {
    }

    ;

    public Post(String content, String uuid) {
        this.content = content;
        this.uuid = uuid;
    }

    public String getContent() {
        return content;
    }

    public String getUuid() {
        return uuid;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public static Post convert(Map<String, Object> register) {
        String content = (String) register.get("content");
        String uuid = (String) register.get("id").toString();
        return new Post(content, uuid);
    }

    public static ArrayList<Post> convertAll(List<Map<String, Object>> registers) {
        ArrayList<Post> aux = new ArrayList<>();
        for (Map<String, Object> register : registers) {
            aux.add(convert(register));
        }
        return aux;
    }
}
