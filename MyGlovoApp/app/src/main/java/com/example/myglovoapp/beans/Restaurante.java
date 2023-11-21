package com.example.myglovoapp.beans;

public class Restaurante {
    private int idRestaurante;
    private String nombre;
    private String desc;
    private String tlfn;
    private String categoria;

    public Restaurante(int idRestaurante, String nombre, String desc, String tlfn, String categoria, int ic_launcher_background) {
        this.idRestaurante = idRestaurante;
        this.nombre = nombre;
        this.desc = desc;
        this.tlfn = tlfn;
        this.categoria = categoria;
    }

    public int getIdRestaurante() {
        return idRestaurante;
    }

    public void setIdRestaurante(int idRestaurante) {
        this.idRestaurante = idRestaurante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getTlfn() {
        return tlfn;
    }

    public void setTlfn(String tlfn) {
        this.tlfn = tlfn;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
