package com.example.myglovoapp.lst_restaurants.model;

import android.util.Log;

import com.example.myglovoapp.beans.Restaurante;
import com.example.myglovoapp.login_client.JsonUserData;
import com.example.myglovoapp.lst_restaurants.ContractLstRestaurantes;
import com.example.myglovoapp.lst_restaurants.JsonRestaurantesData;
import com.example.myglovoapp.lst_restaurants.presenter.lstRestaurantesPresenter;
import com.example.myglovoapp.utils.ApiService;
import com.example.myglovoapp.utils.RetrofitCliente;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class lstRestaurantesModel implements ContractLstRestaurantes.Model {
    private static final String IP_BASE = "10.0.2.2:8080";
    private lstRestaurantesPresenter presenter;

    public lstRestaurantesModel(lstRestaurantesPresenter presenter){
        this.presenter = presenter;
    }


    @Override
    public void lstRestaurantesAPI(String lstRestaurantes, OnRestaurantesListener respuesta) {
        ApiService apiService = RetrofitCliente.getClient(ApiService.URL).create(ApiService.class);

        Call<JsonRestaurantesData> call =  apiService.getDataRestaurantes("RESTAURANTE.ALLRESTAURANTS");
        call.enqueue(new Callback<JsonRestaurantesData>() {
            @Override
            public void onResponse(Call<JsonRestaurantesData> call, Response<JsonRestaurantesData> response) {
                if (response.isSuccessful()) {
                    JsonRestaurantesData misDatos = response.body();
                    if(misDatos!=null && misDatos.getLstRestaurantes().size()>0){
                        respuesta.onFinished(misDatos.getLstRestaurantes());
                    }else{
                        Log.e("Error de datos", "1");
                    }
                }else{
                    Log.e("Response Error", "Not succesful");
                }
            }

            @Override
            public void onFailure(Call<JsonRestaurantesData> call, Throwable t) {
                Log.e("Response Error", "Cuerpo de error: " + t.getMessage());
            }


        });
    }
}
