package com.litter.litter.model;

import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository 
public class PostDAO {
    
    @Autowired
    DataSource dataSource;

    JdbcTemplate jdbc;

    @PostConstruct
    private void initialize() {
        jdbc =  new JdbcTemplate(dataSource);
    }

    public void insertPost(Post post) {
        String sql = "INSERT INTO POST(content)" +
                     " VALUES (?)";
        Object[] obj = new Object[1];

        obj[0] = post.getContent();

        jdbc.update(sql, obj);
    }

    public Post showPost(String uuid) {
        String sql = "SELECT * FROM POST WHERE ID=?::uuid";
        return Post.convert(jdbc.queryForMap(sql, uuid));
    }

    public ArrayList<Post> listPosts() {
        String sql = "SELECT * FROM POST";
        return Post.convertAll(jdbc.queryForList(sql));
    }
}
