package com.example.myglovoapp.login_propietario.presenter;

import com.example.myglovoapp.beans.Propietario;
import com.example.myglovoapp.login_propietario.ContractLoginPropietario;
import com.example.myglovoapp.login_propietario.model.LoginPropietarioModel;

public class LoginPropietarioPresenter implements ContractLoginPropietario.Presenter, ContractLoginPropietario.Model.OnLoginPropietarioListener {
    private ContractLoginPropietario.View view;
    private LoginPropietarioModel model;

    public LoginPropietarioPresenter(ContractLoginPropietario.View view){
        this.view = view;
        this.model = new LoginPropietarioModel(this);
    }

    @Override
    public void login(Propietario propietario) {
        model.loginAPI(propietario,this);
    }

    @Override
    public void onFinished(Propietario propietario) {
        view.successLogin(propietario);
    }

    @Override
    public void onFailure(String err) {

    }
}
