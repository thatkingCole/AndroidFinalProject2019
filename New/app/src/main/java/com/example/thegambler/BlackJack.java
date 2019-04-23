//Author: Josh Schmitz
//Description: Black Jack Game

package com.example.thegambler;

import android.app.AlertDialog;
import android.app.AppComponentFactory;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toolbar;

import com.example.AndroidFinalProject2019.R;

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
    Button start = findViewById(R.id.startBTN);
    Button reset = (Button) findViewById(R.id.resetBTN); //defines button reset
    int[] myDeck = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10,
                    1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};
    int UserTotal;
    int CompTotal;
    TextView userscore = findViewById(R.id.userscoreTV);
    TextView compscore = findViewById(R.id.hostscoreTV);

    //user decides if they want to draw
    //if user or computer has score greater than or equal to 21 game over
    public void drawAction(View v) {
        draw.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Random rand = new Random();
                        int carddrawuser = rand.nextInt(52);
                        int UserDrawOne = myDeck[carddrawuser] + UserTotal;
                        UserTotal = UserDrawOne;
                        userscore.setText("Score: "+UserTotal);

                        if(UserTotal>21){
                            //print game over you lose
                            dialogLost();
                            CompTotal = 0;
                            compscore.setText("Host: "+CompTotal);
                            UserTotal = 0;
                            userscore.setText("Score: "+UserTotal);
                            hold.setVisibility(View.INVISIBLE);
                            draw.setVisibility(View.INVISIBLE);
                            start.setVisibility(View.VISIBLE);
                        }

                    }
                }
        );
    }
    public void dialogLost(){
        new AlertDialog.Builder(this)
                .setTitle("Game Over")
                .setMessage("You went over 21 please reset game to play again")
                .setPositiveButton("Ok",null);
    }

    public void dialogWin(){
        new AlertDialog.Builder(this)
                .setTitle("Game Over")
                .setMessage("Host went over 21 please reset game to play again")
                .setPositiveButton("Ok",null);
    }

    //hides draw and hold button if computer has score less than 21 they continue to draw
    public void holdAction(View v) {
        hold.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Random rand = new Random();
                        int carddrawcomp = rand.nextInt(52);
                        int CompDraw = myDeck[carddrawcomp] + CompTotal;
                        CompTotal = CompDraw;
                        compscore.setText("Host: "+CompTotal);
                        gameCheck();
                    }
                }
        );
    }
    public void gameCheck(){
        if (CompTotal > 21) {
            dialogWin();
            CompTotal = 0;
            compscore.setText("Host: "+CompTotal);
            UserTotal = 0;
            userscore.setText("Score: "+UserTotal);
            hold.setVisibility(View.INVISIBLE);
            draw.setVisibility(View.INVISIBLE);
            start.setVisibility(View.VISIBLE);
        }
        else if (CompTotal > UserTotal && CompTotal < 21) {
            dialogLost();
            CompTotal = 0;
            compscore.setText("Host: "+CompTotal);
            UserTotal = 0;
            userscore.setText("Score: "+UserTotal);
            hold.setVisibility(View.INVISIBLE);
            draw.setVisibility(View.INVISIBLE);
            start.setVisibility(View.VISIBLE);
        }
        else {

        }

    }

    public void resetGame(View v){
        reset.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        userscore.setText("Score: ");
                        compscore.setText("Computer: ");
                    }
                }
        );
    }
}
