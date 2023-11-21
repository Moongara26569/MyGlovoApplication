package com.example.myglovoapp.utils;


import com.example.myglovoapp.login_client.DataLoginClient;

import retrofit2.Call;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface ApiService {
    Call<DataLoginClient> getDataUser(@Query("LOGIN") String login);
}
