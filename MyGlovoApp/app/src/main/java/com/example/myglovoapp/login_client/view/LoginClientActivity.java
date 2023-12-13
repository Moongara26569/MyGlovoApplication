package com.example.myglovoapp.login_client.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

import com.example.myglovoapp.R;
import com.example.myglovoapp.beans.User;
import com.example.myglovoapp.login_client.ContractLoginClient;
import com.example.myglovoapp.login_client.presenter.LoginClientPresenter;
import com.example.myglovoapp.lst_restaurants.view.lstRestaurantesActivity;

public class LoginClientActivity extends AppCompatActivity implements ContractLoginClient.View{
    //codigo de ui

    ContractLoginClient.Presenter presenter;
    EditText clientUsername,clientPassword;
    Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_client);

        presenter = new LoginClientPresenter(this);

        clientUsername = findViewById(R.id.clientUsername);
        clientPassword = findViewById(R.id.clientPassword);
        btn_login = findViewById(R.id.btn_login);

        //click login

        btn_login.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                //validate inputs
                String username = clientUsername.getText().toString();
                String password = clientPassword.getText().toString();

                if(TextUtils.isEmpty(username) || TextUtils.isEmpty(password)){
                    failureLogin("Rellene todos los campos");
                }else{
                    User user  = new User();
                    user.setUsername(username);
                    user.setToken(password);
                    presenter.login(user);
                }
            }
        });


    }

    @Override
    public void successLogin(User user) {

        Toast.makeText(this, "Bienvenido a Glovo",Toast.LENGTH_LONG).show();//TODO TERMINAR INICIO DE SESION
        /*
        // esto guarda las preferencias, solo se guarde si de verdad ha salido bien
        SharedPreferences preferences = getSharedPreferences("user_session", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("user_data", user.getId().toString());
        editor.apply();
        */

        Intent intent = new Intent(this, lstRestaurantesActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void failureLogin(String mess) {
        Toast.makeText(this, mess,Toast.LENGTH_LONG).show();

    }
}