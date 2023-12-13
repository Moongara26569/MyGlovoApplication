package com.example.myglovoapp.login_propietario;

import com.example.myglovoapp.beans.Propietario;
import com.example.myglovoapp.beans.User;
import com.example.myglovoapp.login_client.ContractLoginClient;

public interface ContractLoginPropietario {
    interface View{
        void successLogin(Propietario propietario);
        void failureLogin(String mess);
    }

    interface Presenter{
        void login(Propietario propietario);

    }

    interface Model{
        interface OnLoginPropietarioListener{
            void onFinished(Propietario propietario);
            void onFailure(String err);
        }
        void loginAPI(Propietario propietario,
                      ContractLoginPropietario.Model.OnLoginPropietarioListener onLoginPropietarioListener);
    }

}
