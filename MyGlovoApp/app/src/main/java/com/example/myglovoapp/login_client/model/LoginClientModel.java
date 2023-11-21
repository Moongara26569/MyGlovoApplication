package com.example.myglovoapp.login_client.model;

import android.util.Log;

import com.example.myglovoapp.beans.Cliente;
import com.example.myglovoapp.login_client.ContractLoginClient;
import com.example.myglovoapp.login_client.DataLoginClient;
import com.example.myglovoapp.login_client.presenter.LoginClientPresenter;

import java.io.IOException;
import java.util.ArrayList;

public class LoginClientModel implements ContractLoginClient.Model{
    //aqui se interactua con el servidor
    private static final String IP_BASE = "169.254.225.61:8080";
    private LoginClientPresenter presenter;
    public LoginClientModel(LoginClientPresenter presenter){

        this.presenter = presenter;
    }


    @Override
    public void loginAPI(String email, String pass, OnLoginClientListener onLoginUserListener) {

    }
}
