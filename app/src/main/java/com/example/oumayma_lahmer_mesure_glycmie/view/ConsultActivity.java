package com.example.oumayma_lahmer_mesure_glycmie.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.oumayma_lahmer_mesure_glycmie.R;

public class ConsultActivity extends AppCompatActivity {
    private TextView tvReponse;
    private Button btnReturn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consult);
        init();
        //get intent existe par defaut a compatActivity elle retourner l'intent qui a lencée lactivité courante de type Intent
        //la retoure de getIntent est est une instance de la class Intent
        Intent intent = getIntent();
        String reponse = intent.getStringExtra("reponse");
        tvReponse.setText(reponse);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            //intent implicite
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                //intent avec retour
                if( reponse != null)
                    setResult(RESULT_OK,intent);
                else setResult(RESULT_CANCELED,intent);
                finish();
            }
        });
    }
    private void init(){
        tvReponse = (TextView)findViewById(R.id.tvReponse);
        btnReturn =(Button) findViewById(R.id.btnReturn);
    }
}