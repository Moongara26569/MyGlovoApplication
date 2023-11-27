package com.example.myglovoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myglovoapp.login_client.view.LoginClientActivity;
import com.example.myglovoapp.login_propietario.view.LoginPropietarioActivity;

public class MainActivity extends AppCompatActivity {

    /*
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
    */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.landing_page);

        Button btnCliente = findViewById(R.id.btn_client_login);
        Button btnPropietario = findViewById(R.id.btn_propietario_login);

        btnCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoginClientActivity.class);
                startActivity(intent);
            }
        });

        btnPropietario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoginPropietarioActivity.class);
                startActivity(intent);
            }
        });
    }

}