package com.example.myglovoapp.beans;

public class Cliente {
    private int idCliente;
    private String nombre;

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Cliente(int idCliente, String nombre) {
        this.idCliente = idCliente;
        this.nombre = nombre;
    }
}