package com.example.myglovoapp.login_client.model;

import android.util.Log;

import com.example.myglovoapp.beans.Cliente;
import com.example.myglovoapp.login_client.ContractLoginClient;
import com.example.myglovoapp.login_client.DataLoginClient;
import com.example.myglovoapp.login_client.presenter.LoginClientPresenter;
import com.example.myglovoapp.utils.ApiService;
import com.example.myglovoapp.utils.RetrofitCliente;

import java.io.IOException;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginClientModel implements ContractLoginClient.Model{
    //aqui se interactua con el servidor
    private static final String IP_BASE = "10.0.2.2:8080";
    private LoginClientPresenter presenter;
    public LoginClientModel(LoginClientPresenter presenter){

        this.presenter = presenter;
    }


    @Override
    public void loginAPI(String email, String pass, OnLoginClientListener onLoginUserListener) {
        ApiService apiService = RetrofitCliente.getClient("http://" + IP_BASE + "/GlovoBackend/").
                create(ApiService.class);

        Call<DataLoginClient> call = apiService.getDataUser ("CLIENT.LOGIN");
        call.enqueue(new Callback<DataLoginClient>() {
            @Override
            public void onResponse(Call<DataLoginClient> call, Response<DataLoginClient> response) {

            }

            @Override
            public void onFailure(Call<DataLoginClient> call, Throwable t) {

            }
        });
    }
}
