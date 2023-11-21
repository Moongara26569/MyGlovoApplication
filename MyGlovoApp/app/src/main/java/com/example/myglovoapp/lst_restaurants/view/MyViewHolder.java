package com.example.myglovoapp.lst_restaurants.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myglovoapp.R;

public class MyViewHolder extends RecyclerView.ViewHolder {
    ImageView imageView;
    TextView nombre, categoria;
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imageView);
        nombre = itemView.findViewById(R.id.nombreRestaurante);
        categoria = itemView.findViewById(R.id.restaurantCategory);
    }
}
