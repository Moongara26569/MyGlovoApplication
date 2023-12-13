package com.example.myglovoapp.login_propietario.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myglovoapp.R;
import com.example.myglovoapp.beans.Propietario;
import com.example.myglovoapp.beans.User;
import com.example.myglovoapp.login_propietario.ContractLoginPropietario;
import com.example.myglovoapp.login_propietario.presenter.LoginPropietarioPresenter;
import com.example.myglovoapp.lstProductos.view.lstProductosActivity;
import com.example.myglovoapp.lst_restaurants.view.lstRestaurantesActivity;

public class LoginPropietarioActivity extends AppCompatActivity implements ContractLoginPropietario.View {

    ContractLoginPropietario.Presenter presenter;
    EditText ownerUsername, ownerPassword;
    Button btn_loginPropietario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_propietario);

        presenter = new LoginPropietarioPresenter(this);

        ownerUsername = findViewById(R.id.ownerUsername);
        ownerPassword = findViewById(R.id.ownerPassword);
        btn_loginPropietario = findViewById(R.id.btn_loginPropietario);

        btn_loginPropietario.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                String username = ownerUsername.getText().toString();
                String password = ownerPassword.getText().toString();

                if(TextUtils.isEmpty(username) || TextUtils.isEmpty(password)){
                    failureLogin("Rellene todos los campos");
                }else{
                    Propietario propietario  = new Propietario();
                    propietario.setNombre(username);
                    propietario.setPassword(password);
                    presenter.login(propietario);
                }
            }
        });
    }

    @Override
    public void successLogin(Propietario propietario) {//TODO guardar id restaurante
        Toast.makeText(this, "Bienvenido a tu Restaurante",Toast.LENGTH_LONG).show();//TODO TERMINAR INICIO DE SESION
        /*
        // esto guarda las preferencias, solo se guarde si de verdad ha salido bien
        SharedPreferences preferences = getSharedPreferences("user_session", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("propietario_data", propietario.getId().toString());
        editor.apply();
        */

        Intent intent = new Intent(this, lstProductosActivity.class);
        startActivity(intent);
        finish();

    }

    @Override
    public void failureLogin(String mess) {
        Toast.makeText(this, mess,Toast.LENGTH_LONG).show();

    }
}