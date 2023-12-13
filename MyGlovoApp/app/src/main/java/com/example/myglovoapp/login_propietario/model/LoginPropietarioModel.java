package com.example.myglovoapp.login_propietario.model;

import android.util.Log;

import com.example.myglovoapp.beans.Propietario;
import com.example.myglovoapp.login_client.JsonUserData;
import com.example.myglovoapp.login_client.presenter.LoginClientPresenter;
import com.example.myglovoapp.login_propietario.ContractLoginPropietario;
import com.example.myglovoapp.login_propietario.JsonPropietarioData;
import com.example.myglovoapp.login_propietario.presenter.LoginPropietarioPresenter;
import com.example.myglovoapp.utils.ApiService;
import com.example.myglovoapp.utils.RetrofitCliente;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPropietarioModel implements ContractLoginPropietario.Model {
    private static final String IP_BASE = "10.0.2.2:8080";
    private LoginPropietarioPresenter presenter;
    public LoginPropietarioModel(LoginPropietarioPresenter presenter){
        this.presenter = presenter;
    }

    @Override
    public void loginAPI(Propietario propietario, OnLoginPropietarioListener respuesta) {
        /*
        String nombre = propietario.getNombre();
        String pass = propietario.getPassword();
        ApiService apiService = RetrofitCliente.getClient(ApiService.URL).create(ApiService.class);
        Call<JsonPropietarioData> call =   apiService.getDataPropietario("PROPIETARIO.LOGIN", nombre,pass);
        call.enqueue(new Callback<JsonPropietarioData>() {
            @Override
            public void onResponse(Call<JsonPropietarioData> call, Response<JsonPropietarioData> response) {
                if (response.isSuccessful()) {
                    JsonPropietarioData misDatos = response.body();
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
            public void onFailure(Call<JsonPropietarioData> call, Throwable t) {

            }
        });
        */

    }
}

