package com.example.oumayma_lahmer_mesure_glycmie.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.oumayma_lahmer_mesure_glycmie.R;

public class HomeActivity extends AppCompatActivity {
    private Button btnConsulter ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        init();
        //listenner explicite pour l'évenement de clic sur le btn Consulter
        btnConsulter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //intent permet de lancer d'un context de travail a une activité
                Intent intent = new Intent(HomeActivity.this,MainActivity.class);
                //intent sans retour
                // lancer l'intent
                startActivity(intent);
                finish();
            }
        });

    }
    private void init(){
        btnConsulter = (Button) findViewById(R.id.btnConsulter);
    }
}