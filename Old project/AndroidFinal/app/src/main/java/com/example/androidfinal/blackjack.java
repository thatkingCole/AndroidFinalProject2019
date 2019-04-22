package com.example.androidfinal;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;


public class blackjack extends Fragment {

    BlackCallBack activity;
    Button draw;
    Button hold;
    Button reset;
    int UserTotal;
    int CompTotal;
    TextView userscore;
    TextView compscore;
    int[] myDeck = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10,
            1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};

    public interface BlackCallBack {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_blackjack, container,
                false);

        draw = view.findViewById(R.id.drawBTN);
        hold = view.findViewById(R.id.holdBTN);
        reset = view.findViewById(R.id.resetBTN); //defines button reset
        userscore = view.findViewById(R.id.userscoreTV);
        compscore = view.findViewById(R.id.hostscoreTV);

        draw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    draw.setOnClickListener(
                            new Button.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Random rand = new Random();
                                    int carddrawuser = rand.nextInt(52);
                                    int UserDraw = myDeck[carddrawuser] + UserTotal;
                                    UserTotal = UserDraw;

                                    userscore.setText("Score: " + UserTotal);

                                    int carddrawcomp = rand.nextInt(52);
                                    int CompDraw = myDeck[carddrawcomp] + CompTotal;
                                    CompTotal = CompDraw;

                                    compscore.setText("Computer: " + compscore);


                                    if (UserTotal > 21) {
                                        //print game over you lose
                                        dialogLost();
                                    }

                                    if (CompTotal > 21) {
                                        //print game over you win
                                        dialogWin();
                                    }
                                }
                            }
                    );
                }
        });
        hold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                while (CompTotal < 21) {//computer keeps drawing until they hit 21 or bust
                    Random rand = new Random();
                    int carddrawcomp = rand.nextInt(52);
                    int CompDraw = myDeck[carddrawcomp] + CompTotal;
                    CompTotal = CompDraw;
                    compscore.setText("Computer: " + compscore);
                    if (CompTotal < 21) {//if comp>21 you win
                        dialogWin();
                    }
                }
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userscore.setText("Score: ");
                compscore.setText("Computer: ");
            }
        });
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (BlackCallBack) context;
    }


    public void switchAction(View v) {
        Intent swap = new Intent(v.getContext(), MainActivity.class);
        startActivity(swap);
    }

    //user decides if they want to draw
    //if user or computer has score greater than or equal to 21 game over

    public void dialogLost() {
        new AlertDialog.Builder(getActivity())
                .setTitle("Game Over")
                .setMessage("You went over 21 please reset game to play again")
                .setPositiveButton("Ok", null);
    }

    public void dialogWin() {
        new AlertDialog.Builder(getActivity())
                .setTitle("Game Over")
                .setMessage("Host went over 21 please reset game to play again")
                .setPositiveButton("Ok", null);
    }

}
