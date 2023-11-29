package com.example.myglovoapp.login_client.model;

import android.util.Log;

import com.example.myglovoapp.beans.User;
import com.example.myglovoapp.login_client.ContractLoginClient;
import com.example.myglovoapp.login_client.JsonUserData;
import com.example.myglovoapp.login_client.presenter.LoginClientPresenter;
import com.example.myglovoapp.utils.ApiService;
import com.example.myglovoapp.utils.RetrofitCliente;

import java.io.IOException;

import okhttp3.ResponseBody;
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
    public void loginAPI(User user, OnLoginClientListener respuesta) {
        //Aqui irá la solicitud a base de datos.
        String username = user.getUsername();
        String pass = user.getToken();

        // Crear una instancia de ApiService
        ApiService apiService = RetrofitCliente.getClient(ApiService.URL).create(ApiService.class);

        Call<JsonUserData> call =   apiService.getDataUser("USUARIO.LOGIN", username,pass );
        call.enqueue(new Callback<JsonUserData>() {
            @Override
            public void onResponse(Call<JsonUserData> call, Response<JsonUserData> response) {
                if (response.isSuccessful()) {
                    JsonUserData misDatos = response.body();
                    if (misDatos != null && misDatos.getLstUsers() != null && !misDatos.getLstUsers().isEmpty()) {
                        if (misDatos != null && misDatos.getLstUsers().size() > 0) {
                            Log.e("Datos", misDatos.getLstUsers().get(0).getUsername());
                            respuesta.onFinished(misDatos.getLstUsers().get(0));
                        } else {
                            Log.e("Error de datos", "1");
                        }
                    } else {
                        Log.e("Error de datos", "Datos incorrectos en la respuesta JSON");
                    }
                } else {
                    Log.e("Response Error", "Not successful. Código de estado: " + response.code());
                    ResponseBody errorBody = response.errorBody();
                    String errorBodyString = null;
                    try {
                        errorBodyString = errorBody.string();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    Log.e("Response Error", "Not successful. Cuerpo de respuesta: " + errorBodyString);
                }
            }

            @Override
            public void onFailure(Call<JsonUserData> call, Throwable t) {
                Log.e("Response Error", "Cuerpo de error: " + t.getMessage());
            }

        });
        }
}
