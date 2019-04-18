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
                        int UserDraw = myDeck[carddrawuser] + UserTotal;
                        UserTotal = UserDraw;

                        userscore.setText("Score: "+UserTotal);

                        int carddrawcomp = rand.nextInt(52);
                        int CompDraw = myDeck[carddrawcomp] + CompTotal;
                        CompTotal = CompDraw;

                        compscore.setText("Computer: "+compscore);


                        if(UserTotal>21){
                            //print game over you lose
                            dialogLost();
                        }

                        if(CompTotal>21){
                            //print game over you win
                            dialogWin();
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
//                        hold.setVisibility(View.INVISIBLE);
//                        draw.setVisibility(View.INVISIBLE);

                        while (CompTotal < 21) {//computer keeps drawing until they hit 21 or bust
                            Random rand = new Random();
                            int carddrawcomp = rand.nextInt(52);
                            int CompDraw = myDeck[carddrawcomp] + CompTotal;
                            CompTotal = CompDraw;
                            compscore.setText("Computer: "+compscore);
                            if (CompTotal < 21) {//if comp>21 you win
                                dialogWin();
                            }
                        }
                    }
                }
        );
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
