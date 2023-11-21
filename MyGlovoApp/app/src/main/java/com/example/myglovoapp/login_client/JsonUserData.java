package com.example.myglovoapp.login_client;

import com.example.myglovoapp.beans.User;

import java.util.ArrayList;

public class JsonUserData {
    private String message;
    private ArrayList<User> lstUsers;


    public String getMessage() {
        return message;
    }
    public ArrayList<User> getLstUsers() {
        return lstUsers;
    }
    public void setLstUsers(ArrayList<User> lstUsers) {
        this.lstUsers = lstUsers;
    }
}