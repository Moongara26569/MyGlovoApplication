package com.example.myglovoapp.lst_restaurants.presenter;

import com.example.myglovoapp.beans.Restaurante;
import com.example.myglovoapp.login_client.model.LoginClientModel;
import com.example.myglovoapp.lst_restaurants.ContractLstRestaurantes;
import com.example.myglovoapp.lst_restaurants.model.lstRestaurantesModel;

import java.util.ArrayList;

public class lstRestaurantesPresenter implements ContractLstRestaurantes.Presenter, ContractLstRestaurantes.Model.OnRestaurantesListener {
    private ContractLstRestaurantes.View view;
    private lstRestaurantesModel model;

    public lstRestaurantesPresenter(ContractLstRestaurantes.View view) {
        this.view = view;
        this.model = new lstRestaurantesModel(this);
    }

    @Override
    public void lstRestaurantes(String filtro) {
        model.lstRestaurantesAPI("",this);
    }

    @Override
    public void onFinished(ArrayList<Restaurante> lstRestaurantes) {
        view.successRestaurantes(lstRestaurantes);
    }

    @Override
    public void onFailure(String err) {

    }
}
