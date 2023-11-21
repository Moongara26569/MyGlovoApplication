package com.example.myglovoapp.login_client;

import com.example.myglovoapp.beans.User;

public interface ContractLoginClient {
    interface View{
        void successLogin(User user);
        void failureLogin(String mess);
    }

    interface Presenter{
        void login(User user);

    }

     interface Model{
        interface OnLoginClientListener{
            void onFinished(User user);
            void onFailure(String err);
        }
        void loginAPI(User user,
                      OnLoginClientListener onLoginUserListener);
    }


}
