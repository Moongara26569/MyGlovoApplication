package com.example.myglovoapp.login_propietario;

import com.example.myglovoapp.beans.Propietario;
import com.example.myglovoapp.beans.User;

import java.util.ArrayList;

public class JsonPropietarioData {
    private String message;
    private ArrayList<Propietario> lstPropietario;


    public String getMessage() {
        return message;
    }
    public ArrayList<Propietario> getLstPropietario() {
        return lstPropietario;
    }
    public void setLstUsers(ArrayList<Propietario> lstPropietario) {
        this.lstPropietario = lstPropietario;
    }
}
