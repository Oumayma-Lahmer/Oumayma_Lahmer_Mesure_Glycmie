package com.example.oumayma_lahmer_mesure_glycmie.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.oumayma_lahmer_mesure_glycmie.R;
import com.example.oumayma_lahmer_mesure_glycmie.controller.LoginController;

public class HomeActivity extends AppCompatActivity {
    private Button btnConsulter ;
    private EditText etPassword;
    private EditText etUserName;
    private LoginController loginController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        init();
        etUserName.setText(loginController.getUserName());
        etPassword.setText(loginController.getPassword());
        //listenner explicite pour l'évenement de clic sur le btn Consulter
        btnConsulter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //intent permet de lancer d'un context de travail a une activité
                Intent intent = new Intent(HomeActivity.this,MainActivity.class);
                //intent sans retour
                // lancer l'intent
                startActivity(intent);
                finish();}});}
    private void init(){
        btnConsulter = (Button) findViewById(R.id.btnConsulter);
        etPassword = (EditText) findViewById(R.id.etPassword);
        etUserName = (EditText) findViewById(R.id.etUserName);
        loginController = LoginController.getInstance(HomeActivity.this);
    }
}