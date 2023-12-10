package com.example.oumayma_lahmer_mesure_glycmie.controller;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.oumayma_lahmer_mesure_glycmie.model.User;
import com.example.oumayma_lahmer_mesure_glycmie.model.Patient;
public class LoginController {

    //attribut de class
    private static User user;
    private static LoginController instance = null;
    private static final String SHARED_PREFERENCES="MySharedPreferenses";
    //pattern Sangleton
    //Constructeur privée + méthode de vérification
    private LoginController() {super();}
    public static final LoginController getInstance(Context context){
        if(LoginController.instance == null)
            instance = new LoginController();
        recapUser(context);
        return LoginController.instance;
        }
    public static void recapUser(Context context){
        SharedPreferences sp = context.getSharedPreferences(SHARED_PREFERENCES,Context.MODE_PRIVATE);
        String UserName = sp.getString("userName"," ");
        String pwd = sp.getString("password"," ");
        //update a user
        user = new User("userName","password");
    }


    //view -> model (envoi de donnée)
    public void createUser(String userName, String pwd,Context context){
        user = new User(userName,pwd);
        SharedPreferences sp = context.getSharedPreferences(SHARED_PREFERENCES,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("userName",userName);
        editor.putString("password",pwd);

        //commit
        editor.apply();
    }
    //recupération de donnée
    public String getUserName(){return user.getName();}
    public String getPassword(){return user.getPwd();}
}
