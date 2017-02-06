package com.example.amandine.sudoku_amandinebucas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Amandine on 05/02/2017.
 */

public class dessin extends View implements View.OnTouchListener {

    /*** Un grand carré d'un sudoku contient 9 cases***/
    final static int nbrcases = 9;

    int num = 0;
    int[][] grille = null;

    /******** Déclaration du constructeur *********/
    public dessin(Context context, AttributeSet attributeSet){
        super(context, attributeSet);

        /**** Appel de la méthode setOnTouchListener ****/
        this.setOnTouchListener(this);

    }

    /***** Méthode creationGrille ******/
    public void creationGrille(int[][] grille){
        this.grille = grille;
    }

    /***** Evenement onTouch ******/
    public boolean onTouch(View v, MotionEvent event) {

        /*** Evenement utilisant les coordonnées x et y***/
        int x =(int)event.getX();
        int y =(int)event.getY();

        int xUp;
        int yUp;

        /**** Switch sur les différentes action ****/
        switch (event.getAction()){
            /**** Début d'une pression ****/
            case MotionEvent.ACTION_DOWN:
                for(int i=1;i<=9;i++){
                    /** *i permet de parcourir les 9 boutons **/
                    if(x >= getWidth()/10*i-50 && x <=  getWidth()/10*i+50 && y >=  getWidth()+50 && y <=  getWidth()+150){
                        num = i;
                    }
                }
                break;

            /**** Fin d'une pression ****/
            case MotionEvent.ACTION_UP:
                xUp = x / (getWidth() /9);
                yUp = y / (getWidth() /9);
                if (xUp <9 && yUp <9){
                    grille[xUp][yUp] = num;
                }

                /*** Force le dessin ***/
                invalidate();

                num = 0;
                break;
        }

        this.invalidate();
        return true;
    }

    /***** Méthode onDraw ******/
    protected void onDraw(Canvas canvas) {
        Paint dessiner = new Paint();

        /*** Met en noir ***/
        dessiner.setColor(Color.BLACK);

        for(int i = 1; i<= nbrcases; i++){

            if(i % 3 == 0){
                dessiner.setStrokeWidth(6);
            }
            else{
                dessiner.setStrokeWidth(3);
            }

            /** Dessin des contours **/
            canvas.drawLine(getWidth() / 9 *i, 0, getWidth() / 9 * i, getWidth(), dessiner);
            canvas.drawLine(0, getWidth()/ 9 *i, getWidth(), getWidth() / 9 * i, dessiner);
        }

        Paint rectangle = new Paint();
        rectangle.setStyle(Paint.Style.STROKE);
        dessiner.setStrokeWidth(2);

        Paint paintString = new Paint();
        paintString.setTextSize(60);

        for (int i = 1; i<= nbrcases; i++){
            canvas.drawRect( getWidth() / 10 *i - 50, getWidth() + 50,  getWidth() / 10 * i + 50, getWidth()+ 150, rectangle);
            canvas.drawText(String.valueOf(i), getWidth() / 10 *i - 25, getWidth() + 125, paintString);
        }

        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                if(grille[i][j] != 0){
                    canvas.drawText(String.valueOf(grille[i][j]), getWidth() / 9 *i +65, getWidth() / 9 *j +85, paintString);
                }
            }
        }
    }
}
}
