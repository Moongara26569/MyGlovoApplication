package com.example.myglovoapp.lstProductos.model;

import com.example.myglovoapp.lstProductos.ContractProductosData;
import com.example.myglovoapp.lstProductos.presenter.lstProductosPresenter;

public class lstProductosModel implements ContractProductosData.Model {
    private static final String IP_BASE = "10.0.2.2:8080";//TODO TERMINAR PRODUCTOS VIEW
    private lstProductosPresenter presenter;

    public lstProductosModel(lstProductosPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void lstProductosAPI(String lstProductos, OnProductosListener respuesta) {

    }
}
