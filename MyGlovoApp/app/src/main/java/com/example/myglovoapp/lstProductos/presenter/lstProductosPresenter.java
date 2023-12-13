package com.example.myglovoapp.lstProductos.presenter;

import com.example.myglovoapp.beans.Producto;
import com.example.myglovoapp.lstProductos.ContractProductosData;
import com.example.myglovoapp.lstProductos.model.lstProductosModel;

import java.util.ArrayList;

public class lstProductosPresenter implements ContractProductosData.Presenter, ContractProductosData.Model.OnProductosListener {
    private ContractProductosData.View view;
    private lstProductosPresenter model;

    public lstProductosPresenter(ContractProductosData.View view) {
        this.view = view;
        this.model = new lstProductosModel(this);
    }

    @Override
    public void lstProducto() {
        model.lstProductosAPI(this);
    }

    @Override
    public void onFinished(ArrayList<Producto> lstProductos) {
        view.successProductos(lstProductos);
    }

    @Override
    public void onFailure(String err) {

    }
}
