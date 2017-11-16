package com.example.damien.montyhall;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Acceuil extends AppCompatActivity {


    Button porte1;
    Button porte2;
    Button porte3;
    Button info;

    private List<String> porteList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceuil);

        porte1 = (Button) findViewById(R.id.buttonPorte1);
        porte2 = (Button) findViewById(R.id.buttonPorte2);
        porte3 = (Button) findViewById(R.id.buttonPorte3);
        info = (Button) findViewById(R.id.buttonInfo);

        porteList = Arrays.asList("voiture","chevre", "chevre");
        Collections.shuffle(porteList);


        porte1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                choixPorte(0);
            }
        });

        porte2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choixPorte(1);
            }
        });


        porte3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choixPorte(2);
            }
        });

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ouvrirInfo("https://fr.wikipedia.org/wiki/Problème_de_Monty_Hall");
            }
        });
    }

    public void ouvrirInfo(String url){
        Uri page = Uri.parse(url); Intent intent = new Intent(Intent.ACTION_VIEW); intent.setData(page);
        startActivity(intent);
    }

    public void choixPorte(int porte){
        Intent choixPorte = new Intent(this, SecondChoix.class);
        choixPorte.putExtra("choixUser", porteList.get(porte));
        if ("voiture".equals(porteList.get(porte))){
            choixPorte.putExtra("porteRestante", "chevre");
        }else{
            choixPorte.putExtra("porteRestante", "voiture");
        }


        startActivity(choixPorte);

    }
}
