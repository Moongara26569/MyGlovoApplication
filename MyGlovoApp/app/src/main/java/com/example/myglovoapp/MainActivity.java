package com.example.myglovoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.myglovoapp.login_client.view.LoginClientActivity;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boolean usuarioNecesitaIniciarSesion = true;

        if (usuarioNecesitaIniciarSesion) {
            Intent intent = new Intent(this, LoginClientActivity.class);
            startActivity(intent);

            finish();
        }
    }
}