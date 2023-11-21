package com.example.myglovoapp.login_client.presenter;

import com.example.myglovoapp.beans.User;
import com.example.myglovoapp.login_client.ContractLoginClient;
import com.example.myglovoapp.login_client.model.LoginClientModel;

public class LoginClientPresenter implements ContractLoginClient.Presenter, ContractLoginClient.Model.OnLoginClientListener{
    //comunica la view con el model
    private ContractLoginClient.View view;
    private LoginClientModel model;

    public LoginClientPresenter(ContractLoginClient.View view) {

        this.view = view;
        this.model = new LoginClientModel(this);
    }

    @Override
    public void login(User user) {
        model.loginAPI(user,this);
    }

    @Override
    public void onFinished(User user) {
        view.successLogin(user);
    }

    @Override
    public void onFailure(String err) {

    }
}
