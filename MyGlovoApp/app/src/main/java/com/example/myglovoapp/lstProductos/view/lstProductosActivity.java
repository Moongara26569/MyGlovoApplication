package com.example.myglovoapp.lstProductos.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.myglovoapp.R;
import com.example.myglovoapp.beans.Producto;
import com.example.myglovoapp.lstProductos.ContractProductosData;
import com.example.myglovoapp.lstProductos.presenter.lstProductosPresenter;

import java.util.ArrayList;

public class lstProductosActivity extends AppCompatActivity implements ContractProductosData.View {

    private lstProductosPresenter presenter = new lstProductosPresenter(this);

    private RecyclerView recyclerView;
    private MyAdapterProductos adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lst_productos);
        recyclerView = findViewById(R.id.lstProductos);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        presenter.lstProductos();
    }

    @Override
    public void successProductos(ArrayList<Producto> lstProductos) {

    }

    @Override
    public void failureLogin(String mess) {

    }
}