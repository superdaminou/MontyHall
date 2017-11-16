package com.example.damien.montyhall;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Resultat extends AppCompatActivity {

    Button retour;
    TextView res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultat);

        res = (TextView) findViewById(R.id.Res);
        retour = (Button) findViewById(R.id.retour);

        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                retourMenu();
            }
        });
        Bundle extra = getIntent().getExtras();
        String choix = extra.getString("choix");
        if("voiture".equals(choix)){
            res.setText("Victoire");
        }else{
            res.setText("Perdu");
        }
    }


    public void retourMenu(){
        Intent retour = new Intent(this,Acceuil.class);
        startActivity(retour);
    }
}
