package com.example.myglovoapp.lstProductos;

import com.example.myglovoapp.beans.Producto;
import com.example.myglovoapp.beans.Restaurante;
import com.example.myglovoapp.lst_restaurants.ContractLstRestaurantes;

import java.util.ArrayList;

public interface ContractProductosData {
    interface View{
        void successProductos(ArrayList<Producto> lstProductos);
        void failureLogin(String mess);
    }

    interface Presenter{
        void lstProducto();

    }

    interface Model{
        interface OnProductosListener{
            void onFinished(ArrayList<Producto> lstProductos);
            void onFailure(String err);
        }
        void lstProductosAPI(String lstProductos,
                                ContractProductosData.Model.OnProductosListener respuesta);
    }
}
