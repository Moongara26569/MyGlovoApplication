package com.example.myglovoapp.lst_restaurants;

import com.example.myglovoapp.beans.Restaurante;
import com.example.myglovoapp.beans.User;
import com.example.myglovoapp.login_client.ContractLoginClient;

import java.util.ArrayList;

public interface ContractLstRestaurantes {
    interface View{
        void successRestaurantes(ArrayList<Restaurante> lstRestaurantes);
        void failureLogin(String mess);
    }

    interface Presenter{
        void lstRestaurantes(String filtro);

    }

    interface Model{
        interface OnRestaurantesListener{
            void onFinished(ArrayList<Restaurante> lstRestaurantes);
            void onFailure(String err);
        }
        void lstRestaurantesAPI(String lstRestaurantes,
                                OnRestaurantesListener respuesta);
    }

}
