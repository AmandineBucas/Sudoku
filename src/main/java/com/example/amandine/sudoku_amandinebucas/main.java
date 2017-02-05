package com.example.amandine.sudoku_amandinebucas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
import android.content.Intent;
import android.app.Activity;

public class main extends AppCompatActivity implements View.OnClickListener{

    /*******************************
     * DECLARATION DES WIDGETS
     *******************************/
    Button niveau1;
    Button niveau2;
    Button niveau3;

    TextView textView;
    TextView textView2;
    TextView textView3;

    Activity contexte;

    /**********************************
     * METHODE ONCREATE
     **********************************/
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /******************* Le contexte de l'adaptateur **********************/
        this.contexte = this;

        /************************ Récupération de tous les éléments  ************************/
        niveau1 = (Button) findViewById(R.id.niveau1);
        niveau1.setOnClickListener(this);
        niveau2 = (Button) findViewById(R.id.niveau2);
        niveau2.setOnClickListener(this);
        niveau3 = (Button) findViewById(R.id.niveau3);
        niveau3.setOnClickListener(this);

        textView = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView3 = (TextView) findViewById(R.id.textView3);
    }

        /********************************** METHODES ONCLICK  *************************************/
        public void onClick(View v) {
                /********** ONCLICK NIVEAU 1 **********/
                if(v == niveau1 ){
                Intent intent = new Intent(this, selectionNiveau.class);
                String niveau1 = "1";
                intent.putExtra("key", niveau1);

                /**** Ouvre "selectionNiveau.class" ****/
                startActivity(intent);
                }

                /********** ONCLICK NIVEAU 2 ***********/
                if(v == niveau2 ){
                Intent intent = new Intent(this, selectionNiveau.class);
                String niveau2 = "2";
                intent.putExtra("key", niveau2);

                /**** Ouvre "selectionNiveau.class" ****/
                startActivity(intent);
                }

                /********** ONCLICK NIVEAU 3 **********/
                if(v == niveau3 ){
                Intent intent = new Intent(this, selectionNiveau.class);
                String niveau3 = "3";
                intent.putExtra("key", niveau3);

                /**** Ouvre "selectionNiveau.class" ****/
                startActivity(intent);
                }
    }

    /****************************** METHODE HIDETOPBAR *******************************/
    public void hideTopBar() {

        /**** Supprime la barre du haut *****/
        View aView = getWindow().getDecorView();
        aView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }

    /****************************** METHODE ONRESUME *********************************/
    public void onResume() {
        super.onResume();

        /**** Cache la barre du haut avec appel de la méthode ****/
        hideTopBar();
    }

}


