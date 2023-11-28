package com.example.myglovoapp.lst_restaurants.model;

import android.util.Log;

import com.example.myglovoapp.beans.Restaurante;
import com.example.myglovoapp.login_client.JsonUserData;
import com.example.myglovoapp.lst_restaurants.ContractLstRestaurantes;
import com.example.myglovoapp.lst_restaurants.JsonRestaurantesData;
import com.example.myglovoapp.lst_restaurants.presenter.lstRestaurantesPresenter;
import com.example.myglovoapp.utils.ApiService;
import com.example.myglovoapp.utils.RetrofitCliente;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Headers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.HttpException;
import retrofit2.Response;

public class lstRestaurantesModel implements ContractLstRestaurantes.Model {
    private static final String IP_BASE = "10.0.2.2:8080";
    private lstRestaurantesPresenter presenter;

    public lstRestaurantesModel(lstRestaurantesPresenter presenter){
        this.presenter = presenter;
    }


    @Override
    public void lstRestaurantesAPI(String filtro, OnRestaurantesListener respuesta) {
        ApiService apiService = RetrofitCliente.getClient(ApiService.URL).create(ApiService.class);

        Call<JsonRestaurantesData> call =  apiService.getDataRestaurantes("RESTAURANTE.ALLRESTAURANTS",filtro);
        call.enqueue(new Callback<JsonRestaurantesData>() {
            @Override
            public void onResponse(Call<JsonRestaurantesData> call, Response<JsonRestaurantesData> response) {
                if (response.isSuccessful()) {

                    JsonRestaurantesData misDatos = response.body();
                    if(misDatos != null){
                        Log.d("datos", "Mis datos contienen elementos");
                        Log.d("datos JSON", new Gson().toJson(misDatos));
                    }
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
                Log.d("Error Back", "Algo mal del back no sé");

                // Log adicional para imprimir más detalles sobre el Throwable
                Log.e("Throwable Details", Log.getStackTraceString(t));

                // Resto del código para manejar la excepción (como en tu bloque original)
                if (call.isExecuted() && !call.isCanceled() && t instanceof HttpException) {
                    HttpException httpException = (HttpException) t;
                    Response<?> response = httpException.response();

                    if (response != null && response.errorBody() != null) {
                        try {
                            Log.e("Response Error Body", response.errorBody().string());
                            Log.e("Response Code", String.valueOf(response.code()));
                            Log.e("Response Message", response.message());

                            Headers headers = response.headers();
                            for (int i = 0; i < headers.size(); i++) {
                                Log.e("Header", headers.name(i) + ": " + headers.value(i));
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        Log.e("Response Error", "La respuesta o el cuerpo de error son nulos");
                    }
                } else {
                    Log.e("Response Error", "No es una instancia de HttpException");
                }
            }



        });
    }
}
