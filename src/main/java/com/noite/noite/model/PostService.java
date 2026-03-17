package com.noite.noite.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    
    @Autowired
    PostDAO postDAO;

    public void insertPost(Post post) {
        postDAO.insertPost(post);
    }
}
