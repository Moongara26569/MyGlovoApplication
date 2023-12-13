package com.example.myglovoapp.lstProductos.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myglovoapp.R;

public class MyViewHolderProductos extends RecyclerView.ViewHolder {
    ImageView imageViewProducto;
    TextView nombreProducto, desProducto;
    public MyViewHolderProductos(@NonNull View itemView) {
        super(itemView);
        imageViewProducto = itemView.findViewById(R.id.imageViewProducto);
        nombreProducto = itemView.findViewById(R.id.nombreProducto);
        desProducto = itemView.findViewById(R.id.desProducto);

    }
}
