package com.example.amandine.sudoku_amandinebucas;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.TwoLineListItem;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Amandine on 03/02/2017.
 */

public class adaptateur extends BaseAdapter {

    /*********** Là où on va remplir la liste ***********/
    List<listeGrille> maListe = new ArrayList<listeGrille>();

    Context contexte;

    /*********** Constructeur ***********/
    public adaptateur(Context contexte, List<listeGrille> maListe) {
        this.contexte = contexte;
        this.maListe = maListe;
    }

    /***************** Nombre d'items présents dans la liste *********************/
    public int getCount() {
        return maListe.size();
    }

    /****************** Prend l'item ainsi que sa position ************************/
    public listeGrille getItem(int position) {
        return maListe.get(position);
    }

    /**** Prend l'id de l'objet de la rangée, avec la poisition dans la liste ****/
    public long getItemId(int position) {
        return maListe.indexOf(getItem(position));
    }

    /****************** Affiche l'objet à la position du set ************************/
    public View getView(int position, View convertView, ViewGroup parent) {

        VuePorteuse vue = null;

        /******* convertView vaut null ********/
        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater) contexte.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

            convertView = mInflater.inflate(R.layout.adaptateur, parent, false);

            /********** Déclaration des textView ************/
            vue = new VuePorteuse();
            vue.textNumero = (TextView) convertView.findViewById(R.id.numeroniveau);
            vue.textPourcentage = (TextView) convertView.findViewById(R.id.pourcentage);

            /********* Attribution à la vue du convertView *********/
            convertView.setTag(vue);
        } else {
            /******** Récupération de la vue ************/
            vue = (VuePorteuse) convertView.getTag();
        }

        /*** Si le résultat est inférieur à 40, le pourcentage sera en rouge ***/
     /*   if (meslistes.get(position).getPourcentage() < 40)
            text2.setTextColor(Color.RED);
        /** Sinon, il sera affiché en vert **/
    /*    else
            text2.setTextColor(Color.GREEN);

        /********** Change le style de l'écriture avec le font "Munro" ***********/
        /*Typeface typeface = Typeface.createFromAsset(contexte.getAssets(), "fonts/Munro.ttf");
        textPourcentage.setTypeface(typeface);*/


        /********* Récupération de l'objet *********/
        listeGrille Grille = (listeGrille) getItem(position);

        /********** Affichage du niveau, numero, pourcentage ************/
        /********** Récupération grâce aux gets *************/
        vue.textNumero.setText(String.valueOf("Niveau° "+Grille.getNiveau()+" - Grille : "+ Grille.getNumero()));
        vue.textPourcentage.setText(String.valueOf(Grille.getPourcentage()+"%"));

        return convertView;
    }
}

class VuePorteuse{
    public TextView textNumero;
    public TextView textPourcentage;
}


