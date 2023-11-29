package com.example.myglovoapp.lst_restaurants.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myglovoapp.R;
import com.example.myglovoapp.beans.Restaurante;
import com.example.myglovoapp.lst_restaurants.ContractLstRestaurantes;
import com.example.myglovoapp.lst_restaurants.model.lstRestaurantesModel;
import com.example.myglovoapp.lst_restaurants.presenter.lstRestaurantesPresenter;

import java.util.ArrayList;
import java.util.List;

public class lstRestaurantesActivity extends AppCompatActivity implements ContractLstRestaurantes.View {
    private lstRestaurantesPresenter presenter = new lstRestaurantesPresenter(this);
    private RecyclerView recyclerView;
    private MyAdapter adapter;
    Button filterItaliana;
    Button filterMexicana;
    Button filterParrilla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lst_restaurantes);
        filterItaliana=findViewById(R.id.filterItaliana);
        filterMexicana=findViewById(R.id.filterMexicana);
        filterParrilla=findViewById(R.id.filterParrilla);
        filterItaliana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TuActividad", "Filtro Italiana presionado");
                presenter.lstRestaurantes("ITALIANA");
            }
        });

        filterMexicana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TuActividad", "Filtro Mexicana presionado");
                presenter.lstRestaurantes("MEXICANA");
            }
        });

        filterParrilla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TuActividad", "Filtro Parrilla presionado");
                presenter.lstRestaurantes("PARRILLA");
            }
        });



        recyclerView = findViewById(R.id.lstRestaurantes);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        presenter.lstRestaurantes("");



    }

    @Override
    public void successRestaurantes(ArrayList<Restaurante> lstRestaurantes) {
        recyclerView.setAdapter(new MyAdapter(getApplicationContext(),lstRestaurantes));
    }

    @Override
    public void failureLogin(String mess) {

    }

   /* @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }*/
}