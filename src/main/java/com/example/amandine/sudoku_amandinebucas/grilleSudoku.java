package com.example.amandine.sudoku_amandinebucas;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class grilleSudoku extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grille_sudoku);

    }

    /**********************************
     * METHODE ONDRAW
     **********************************/
    public void onDraw(Canvas canvas){
        Paint dessin = new Paint();

        /************** Couleur des bordures ***************/
        dessin.setColor(Color.BLACK);

        /************ Lignes **************/
        dessin.setStrokeWidth(5);
        canvas.drawLine(50, 50, 950, 50, dessin);
        canvas.drawLine(50, 150, 950, 150, dessin);
        canvas.drawLine(50, 250, 950, 250, dessin);
        dessin.setStrokeWidth(10);
        canvas.drawLine(50, 350, 950, 350, dessin);
        dessin.setStrokeWidth(5);
        canvas.drawLine(50, 450, 950, 450, dessin);
        canvas.drawLine(50, 550, 950, 550, dessin);
        dessin.setStrokeWidth(10);
        canvas.drawLine(50, 650, 950, 650, dessin);
        dessin.setStrokeWidth(5);
        canvas.drawLine(50, 750, 950, 750, dessin);
        canvas.drawLine(50, 850, 950, 850, dessin);
        canvas.drawLine(50, 950, 950, 950, dessin);

        /************ Lignes **************/
        canvas.drawLine(50, 50, 50, 950, dessin);
        canvas.drawLine(150, 50, 150, 950, dessin);
        canvas.drawLine(250, 50, 250, 950, dessin);
        dessin.setStrokeWidth(10);
        canvas.drawLine(350, 50, 350, 950, dessin);
        dessin.setStrokeWidth(5);
        canvas.drawLine(450, 50, 450, 950, dessin);
        canvas.drawLine(550, 50, 550, 950, dessin);
        dessin.setStrokeWidth(10);
        canvas.drawLine(650, 50, 650, 950, dessin);
        dessin.setStrokeWidth(5);
        canvas.drawLine(750, 50, 750, 950, dessin);
        canvas.drawLine(850, 50, 850, 950, dessin);
        canvas.drawLine(950, 50, 950, 950, dessin);
    }
}

