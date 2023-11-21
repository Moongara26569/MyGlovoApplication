package com.example.myglovoapp.lst_restaurants;

import com.example.myglovoapp.beans.Restaurante;
import com.example.myglovoapp.beans.User;

import java.util.ArrayList;

public class JsonRestaurantesData {
    private String message;
    private ArrayList<Restaurante> lstRestaurantes;


    public String getMessage() {
        return message;
    }
    public ArrayList<Restaurante> getLstRestaurantes() {
        return lstRestaurantes;
    }
    public void setLstUsers(ArrayList<Restaurante> lstRestaurantes) {
        this.lstRestaurantes = lstRestaurantes;
    }

}
