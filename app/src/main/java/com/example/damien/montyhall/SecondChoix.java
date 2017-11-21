package com.example.damien.montyhall;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondChoix extends AppCompatActivity {

    Button garder;
    Button changer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_choix);
        Bundle extra = getIntent().getExtras();
        String choixUser = extra.getString("choixUser");
        String porteRestante = extra.getString("porteRestante");

        final String[] choixTab = {choixUser, porteRestante};
        garder = (Button) findViewById(R.id.buttonGarder);
        changer = (Button) findViewById(R.id.buttonChanger);


        garder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ouvrir(choixTab[0]);
            }
        });

        changer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ouvrir(choixTab[1]);
            }
        });
    }

    public void ouvrir(String choix){
        Intent Resultat = new Intent(this, Resultat.class);
        Resultat.putExtra("choix",choix);
        startActivity(Resultat);



    }
}
