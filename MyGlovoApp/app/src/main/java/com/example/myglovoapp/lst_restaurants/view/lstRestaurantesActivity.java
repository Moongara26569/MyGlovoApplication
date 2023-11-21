package com.example.myglovoapp.lst_restaurants.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.myglovoapp.R;
import com.example.myglovoapp.beans.Restaurante;

import java.util.ArrayList;
import java.util.List;

public class lstRestaurantesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lst_restaurantes);

        RecyclerView recyclerView = findViewById(R.id.lstRestaurantes);

        List<Restaurante> restaurantes = new ArrayList<Restaurante>();
        restaurantes.add(new Restaurante(1, "Nómada", "Restaurante Nómada", "123456789", "Mundo",R.drawable.ic_launcher_background));
        restaurantes.add(new Restaurante(2, "La Quebradora", "Restaurante Nómada", "123456789", "Mexicana",R.drawable.ic_launcher_background));
        restaurantes.add(new Restaurante(3, "Burger37", "Restaurante Nómada", "123456789", "Hamburguesería",R.drawable.ic_launcher_background));


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapter(getApplicationContext(),restaurantes));
    }
}