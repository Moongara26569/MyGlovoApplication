package com.example.myglovoapp.login_client.presenter;

import com.example.myglovoapp.beans.Cliente;
import com.example.myglovoapp.login_client.ContractLoginClient;
import com.example.myglovoapp.login_client.model.LoginClientModel;

public class LoginClientPresenter implements ContractLoginClient.Presenter{
    //comunica la view con el model
    ContractLoginClient.View view;

    public LoginClientPresenter(ContractLoginClient.View view) {
        this.view = view;
    }

    @Override
    public void login(String username, String pass) {
        //email ana@gmail.com
        //pass 1234

        //aqui habría que recorrer los datos de la bd

        if(username.equals("ana@gmail.com") && pass.equals("1234")){
            view.successLogin("Bienvenido a Glovo");
        }else{
            view.failureLogin("Nombre de usuario o contraseña incorrectos");
        }

    }
}
