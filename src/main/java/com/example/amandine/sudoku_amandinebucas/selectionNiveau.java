package com.example.amandine.sudoku_amandinebucas;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class selectionNiveau extends AppCompatActivity{

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection_niveau);

        /************************ Récupération de tous les éléments  ************************/
        final ListView liste = (ListView) findViewById(R.id.liste);

        /********************* Récupération du niveau ************************/
        String niveau = (String) this.getIntent().getExtras().get("key");

        /******************* Fichier de grilles *******************/
        final List<listeGrille> grilles = new ArrayList();

        /******************* GESTION DU FLOT DE DONNEES *******************/
        InputStream inputStream;

        /************* Si choix niveau 1 **************/
        if ("1".equals(niveau)) {
            /************* Récupère le fichier niveau1 **************/
            inputStream = getResources().openRawResource(R.raw.niveau1);

        /************* Si choix niveau 2 **************/
        } else if ("2".equals(niveau)) {
            /************* Récupèré le fichier niveau2 **************/
            inputStream = getResources().openRawResource(R.raw.niveau2);

        /************* Si choix niveau 3 **************/
        } else {
            /************* Récupère le fichier niveau3 **************/
            inputStream = getResources().openRawResource(R.raw.niveau3);
        }

        /************* Lecture du texte **************/
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(inputStream));

        int i = 1;
        String ligne = "";

        do {
            try {
                ligne = inputStreamReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            /******* Ajoute la grille ********/
            grilles.add(new listeGrille(i, Integer.parseInt(niveau), 0, ligne));
            i++;

        } while (ligne != null);

        /******** Adaptateur ************/
        adaptateur adapter = new adaptateur(this, grilles);
        liste.setAdapter(adapter);

        liste.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            /******** Clic sur un élément de la liste ************/
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final listeGrille grille = grilles.get(position);

                /******** Affichage du pourcentage réalisé concernant la grille sélectionnée ************/
                AlertDialog.Builder builder = new AlertDialog.Builder(selectionNiveau.this);
                builder.setTitle("Informations");
                builder.setMessage("Grille n°" + grille.getNumero() + " : " + grille.getPourcentage() + "%");
                builder.setCancelable(false);

                /**** Ferme l'affichage de l'information concernant la grille sélectionnée ****/
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                /**** Permet de continuer la grille sélectionnée, redirige vers la grille ****/
                builder.setNegativeButton("Continuer la grille", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(selectionNiveau.this, grilleSudoku.class);
                        intent.putExtra("grille", grille.getGrille());
                        startActivity(intent);
                    }
                });

                AlertDialog alert = builder.create();
                /****** Affiche le message ******/
                alert.show();
            }
        });
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

