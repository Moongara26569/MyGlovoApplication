package com.example.myglovoapp.beans;

public class Direccion {
    private int idDireccion;
    private String direccion;
    private int idCliente;

    public int getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(int idDireccion) {
        this.idDireccion = idDireccion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public Direccion(int idDireccion, String direccion, int idCliente) {
        this.idDireccion = idDireccion;
        this.direccion = direccion;
        this.idCliente = idCliente;
    }
}
