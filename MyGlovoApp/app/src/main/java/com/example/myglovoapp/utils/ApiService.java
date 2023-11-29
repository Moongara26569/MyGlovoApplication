package com.example.myglovoapp.utils;


import com.example.myglovoapp.login_client.JsonUserData;
import com.example.myglovoapp.login_propietario.JsonPropietarioData;
import com.example.myglovoapp.lst_restaurants.JsonRestaurantesData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface ApiService {
    public static final String URL = "http://192.168.104.54:8080/untitled/";

    @Headers({
            "Accept: application/json",
            "Content-Type: application/json"
    })

    //Call<MyData> getDataUser(@Query("ACTION") String action);
    @GET("MyServlet")
    Call<JsonUserData> getDataUser(@Query("ACTION") String action,
                                   @Query("NOMBRE") String nombre,
                                   @Query("PASSWORD") String pass);
    Call<JsonPropietarioData> getDataPropietario(@Query("ACTION") String action,
                                          @Query("NOMBRE") String nombre,
                                          @Query("PASSWORD") String pass);
    @GET("MyServlet")
    Call<JsonRestaurantesData> getDataRestaurantes(@Query("ACTION") String action,
                                                   @Query("FILTRO") String filtro);

}
