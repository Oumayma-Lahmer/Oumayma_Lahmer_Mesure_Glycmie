package com.example.oumayma_lahmer_mesure_glycmie.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.oumayma_lahmer_mesure_glycmie.R;
import com.example.oumayma_lahmer_mesure_glycmie.controller.Controller;

public class MainActivity extends AppCompatActivity {
    private EditText etValeur ;
    private SeekBar sbAge ;
    private TextView tvAge;
    private RadioButton rbIsFasting;
    private RadioButton rbIsNotFasting;
    private Button btnConsulter;
    private TextView  tvResult;

    //l'instance unique et accessible du contrôleur
    private Controller ctrl = Controller.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        //Listener de seekBar
        sbAge.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //afficher dans le log de Android studio pour voir les changements détectés sur le sekBar
                Log.i("information","onProgressChanged"+progress);
                //Mise a jour du textView par la valeur : progress à chaque changement
                tvAge.setText("Votr age: "+ progress);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        // Listener de bouton consulter explecite
        // ce code remplacer le listenner implicite de bouton consulter
        // en peut alors effacer android:onClick="calculer" dans le fichier activity_main.xml
        btnConsulter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int age;
                float valeurMesuree;
                boolean verifAge= false;
                boolean verifValeur=false;
                if(sbAge.getProgress()!= 0){
                    verifAge=true;
                }
                else {
                    //alert d'erreur: l'age ne peut pas etre nul
                    Toast.makeText(MainActivity.this,"veuillez verifier votre age", Toast.LENGTH_SHORT).show();
                }
                if(! etValeur.getText().toString().isEmpty()) verifValeur=true;
                else {
                    //alert d'erreur: le champ de valeur mesurée ne peut pas etre vide
                    Toast.makeText(MainActivity.this,"veuillez verifier la valeur mesurée", Toast.LENGTH_LONG).show();
                }
                if(verifAge && verifValeur){
                    age = sbAge.getProgress();
                    valeurMesuree = Float.valueOf(etValeur.getText().toString());
                    boolean isFasting = rbIsFasting.isChecked();

                    // view > controller (user action)
                    ctrl.createPatient(age,isFasting,valeurMesuree);

                    // controller > view (update)
                    tvResult.setText(ctrl.getResult());
                }
            }
        });

    }
    private void init(){
        etValeur = (EditText) findViewById(R.id.etValeur);
        tvAge = (TextView) findViewById(R.id.tvAge);
        sbAge =(SeekBar) findViewById(R.id.sbAge);
        rbIsFasting= (RadioButton) findViewById(R.id.rbisFasting);
        rbIsNotFasting= (RadioButton) findViewById(R.id.rbisNotFasting);
        btnConsulter=(Button) findViewById(R.id.btnConsulter);
        tvResult =(TextView) findViewById(R.id.tvresult);
    }


}