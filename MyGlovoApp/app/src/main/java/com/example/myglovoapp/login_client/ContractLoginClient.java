package com.example.myglovoapp.login_client;

import com.example.myglovoapp.beans.Cliente;

public interface ContractLoginClient {
    interface View{
        void successLogin(String mess);
        void failureLogin(String mess);
    }

    interface Presenter{
        void login(String email, String pass);

    }

     interface Model{
        interface OnLoginClientListener{
            void onFinished(String email, String pass);
            void onFailure(String err);
        }
        void loginAPI(String email, String pass,
                      OnLoginClientListener onLoginUserListener);
    }


}
