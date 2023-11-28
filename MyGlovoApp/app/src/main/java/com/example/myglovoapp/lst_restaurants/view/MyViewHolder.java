package com.example.myglovoapp.lst_restaurants.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myglovoapp.R;

public class MyViewHolder extends RecyclerView.ViewHolder {
    ImageView imageView;
    TextView nombre, categoria;
    RatingBar ratingBar;
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imageView);
        nombre = itemView.findViewById(R.id.nombreRestaurante);
        categoria = itemView.findViewById(R.id.restaurantCategory);
        ratingBar = (RatingBar) itemView.findViewById(R.id.ratingBar);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                //si se quiere guardar en bd la valoración se hará en este método
                Toast.makeText(itemView.getContext(),"Usted ha votado con: "+rating,Toast.LENGTH_LONG).show();
            }
        });
    }
}
