package com.demo.user.pojo;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String name;

    public User(long id, String name) {
        this.id = id;
        this.name = name;
    }
}
