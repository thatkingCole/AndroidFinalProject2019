//Author: Josh Schmitz
//Description: Black Jack Game

package com.example.thegambler;

import android.app.AppComponentFactory;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;


public class BlackJack extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_black_jack);
    }

    //swap between activities
    public void switchAction(View v) {
        Intent swap = new Intent(v.getContext(), MainActivity.class);
        startActivity(swap);
    }
    Button draw = (Button) findViewById(R.id.drawBTN); //defines button draw
    Button hold = (Button) findViewById(R.id.holdBTN); //defines button hold
    int[] myDeck = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10,
                    1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};
    int UserTotal;
    int CompTotal;
    int CardTotal = 52;
    //user decides if they want to draw
    //if user or computer has score greater than or equal to 21 game over
    public void drawAction(View v) {
        draw.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Random rand = new Random();
                        int carddrawuser = rand.nextInt(CardTotal);
                        int UserDraw = myDeck[carddrawuser] + UserTotal;
                        UserTotal = UserDraw;
                        TextView userscore = findViewById(R.id.userscoreTV);
                        userscore.setText("Score: "+UserTotal);

                        int carddrawcomp = rand.nextInt(CardTotal);
                        int CompDraw = myDeck[carddrawcomp] + CompTotal;
                        CompTotal = CompDraw;
                        TextView compscore = findViewById(R.id.hostscoreTV);
                        compscore.setText("Computer: "+compscore);

                        CardTotal--;


                        if(UserTotal>21){
                            //print game over you lose

                        }

                        if(CompTotal>21){
                            //print game over you win
                        }

                    }
                }
        );
    }

    //hides draw and hold button if computer has score less than 21 they continue to draw
    public void holdAction(View v) {

        hold.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                            hold.setVisibility(View.INVISIBLE);
                            draw.setVisibility(View.INVISIBLE);

                        if(CompTotal<21){
                            //computer keeps drawing until they hit 21 or bust
                            //if comp>21 you win

                        }
                    }
                }
        );
    }
}
