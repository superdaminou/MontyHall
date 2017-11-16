package com.example.damien.montyhall;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Resultat extends AppCompatActivity {


    TextView res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultat);

        res = (TextView) findViewById(R.id.Res);

        Bundle extra = getIntent().getExtras();
        String choix = extra.getString("choix");
        if("voiture".equals(choix)){
            res.setText("Victoire");
        }else{
            res.setText("Perdu");
        }
    }
}
