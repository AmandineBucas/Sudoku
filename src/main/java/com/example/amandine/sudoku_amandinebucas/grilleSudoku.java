package com.example.amandine.sudoku_amandinebucas;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Chronometer;

public class grilleSudoku extends AppCompatActivity {

    /*** Génération d'une grille de 81 cases ***/
    int[][] grille = new int[9][9];

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grille_sudoku);

        /*** Démarrage du chronomètre ***/
        startChronometre(findViewById(R.id.chronometer2));

        String maGrille = (String) this.getIntent().getExtras().get("grille");
        int cpt = 0;
        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                grille[j][i] = Integer.parseInt(""+maGrille.charAt(cpt));
                cpt++;

            }
        }

        dessin dessin = (dessin) findViewById(R.id.dessin);

        dessin.creationGrille(grille);

    }

    /****************************** METHODE STARTCHRONOMETRE *******************************/
    public void startChronometre(View view){
        ((Chronometer)findViewById(R.id.chronometer2)).start();
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



