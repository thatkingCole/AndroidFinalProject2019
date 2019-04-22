//Author: Josh Schmitz
//Description: Black Jack Game

package com.example.thegambler;

import android.app.AppComponentFactory;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Random;


public class BlackJack extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_black_jack);
    }

    public void switchAction(View v) {
        Intent swap = new Intent(v.getContext(), MainActivity.class);
        startActivity(swap);
    }
    Button draw = findViewById(R.id.drawBTN);

    public void drawAction(View v) {
        draw.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Random rand = new Random();
                        int UserTotal = 0;
                        int[] myDeck = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};
                        int carddraw = rand.nextInt(52);
                        int newDraw = myDeck[carddraw] + UserTotal;

                    }
                }
        );
    }
    Button hold = (Button) findViewById(R.id.drawBTN);
    public void holdAction(View v) {

        hold.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                            hold.setVisibility(View.INVISIBLE);
                            draw.setVisibility(View.INVISIBLE);
                    }
                }
        );
    }
}
