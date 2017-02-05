package com.example.amandine.sudoku_amandinebucas;

import android.os.Bundle;

/**
 * Created by Amandine on 03/02/2017.
 */

class listeGrille {

    /************************** Getters / Setters : Numero *************************/
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    /************************** Getters / Setters : Niveau *************************/

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    /************************ Getters / Setters : Pourcentage **********************/

    public int getPourcentage() {
        return pourcentage;
    }

    public void setPourcentage(int pourcentage) {
        this.pourcentage = pourcentage;
    }

    /************************** Getters / Setters : Grille ************************/

    public String getGrille() {
        return grille;
    }

    public void setGrille(String grille) {
        this.grille = grille;
    }

    /************ Initialisation du numéro, niveau et du pourcentage ****************/
    private int numero;
    private int niveau;
    private int pourcentage;

    private String grille;

    /*********************** Initialisation du constructeur *************************/
    public listeGrille(int numero, int niveau, int pourcentage, String grille){

        this.numero = numero;
        this.niveau = niveau;
        this.pourcentage = pourcentage;
        this.grille = grille;
    }
}

