package com.example.myglovoapp.lst_restaurants.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myglovoapp.R;
import com.example.myglovoapp.beans.Restaurante;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    Context context;
    ArrayList<Restaurante> lstRestaurantes;

    public MyAdapter(Context context, ArrayList<Restaurante> lstRestaurantes) {
        this.context = context;
        this.lstRestaurantes = lstRestaurantes;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.restaurant_view,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.nombre.setText(lstRestaurantes.get(position).getNombre());
        holder.categoria.setText(lstRestaurantes.get(position).getCategoria());
        holder.imageView.setImageResource(lstRestaurantes.get(position).getIdRestaurante());
        //holder.ratingBar.setRating(lstRestaurantes.get(position).getPuntuacion());

    }

    @Override
    public int getItemCount() {
        return lstRestaurantes.size();
    }
}
