package com.example.myglovoapp.login_client.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

import com.example.myglovoapp.R;
import com.example.myglovoapp.beans.Cliente;
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
                    presenter.login(username,password);
                }
            }
        });


    }

    @Override
    public void successLogin(String mess) {

        Toast.makeText(this, mess,Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, lstRestaurantesActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void failureLogin(String mess) {
        Toast.makeText(this, mess,Toast.LENGTH_LONG).show();

    }
}