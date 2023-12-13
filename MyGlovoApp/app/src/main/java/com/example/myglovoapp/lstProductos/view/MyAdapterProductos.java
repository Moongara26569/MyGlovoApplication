package com.example.myglovoapp.lstProductos.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myglovoapp.R;
import com.example.myglovoapp.beans.Producto;
import com.example.myglovoapp.lst_restaurants.view.MyViewHolder;

import java.util.ArrayList;

public class MyAdapterProductos extends RecyclerView.Adapter<MyViewHolderProductos> {
    Context context;
    ArrayList<Producto> lstProductos;

    public MyAdapterProductos(Context context, ArrayList<Producto> lstProductos) {
        this.context = context;
        this.lstProductos = lstProductos;
    }

    @NonNull
    @Override
    public MyViewHolderProductos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolderProductos(LayoutInflater.from(context).inflate(R.layout.producto_view,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderProductos holder, int position) {
        holder.nombreProducto.setText(lstProductos.get(position).getNombre());
        holder.desProducto.setText(lstProductos.get(position).getDesc());
        holder.imageViewProducto.setImageResource(lstProductos.get(position).getIdProducto());


    }

    @Override
    public int getItemCount() {
        return lstProductos.size();
    }
}
