package com.example.myglovoapp.beans;

public class User {
    private Integer id;
    private String username;
    private String token; // Puedes agregar otros campos según tus necesidades

    public User(String username, String token) {
        this.username = username;
        this.token = token;
    }
    public User() {
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
