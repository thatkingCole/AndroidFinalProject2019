package com.example.androidfinal;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
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
    Button start;
    Button home;
    int UserTotal;
    int CompTotal;
    TextView userscore;
    TextView compscore;
    int[] myDeck = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10,
            1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};

    public interface BlackCallBack {
        public void swapOutMenu();
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
        start = view.findViewById(R.id.startBTN);
        home = view.findViewById(R.id.homeBTN);
        userscore = view.findViewById(R.id.userscoreTV);
        compscore = view.findViewById(R.id.hostscoreTV);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random rand = new Random();
                int carddrawuser = rand.nextInt(52);
                int UserDrawOne = myDeck[carddrawuser] + UserTotal;
                int UserDrawTwo = myDeck[carddrawuser] + UserTotal;
                UserTotal = UserDrawOne+UserDrawTwo;
                userscore.setText("Score: "+UserTotal);

                int carddrawcomp = rand.nextInt(52);
                int CompDraw = myDeck[carddrawcomp] + CompTotal;
                CompTotal = CompDraw;
                compscore.setText("Host: "+CompTotal);
                hold.setVisibility(View.VISIBLE);
                draw.setVisibility(View.VISIBLE);
                start.setVisibility(View.INVISIBLE);
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.swapOutMenu();
            }
        });

        draw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
        });

        hold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random rand = new Random();
                int carddrawcomp = rand.nextInt(52);
                int CompDraw = myDeck[carddrawcomp] + CompTotal;
                CompTotal = CompDraw;
                compscore.setText("Host: "+CompTotal);
                gameCheck();
            }
        });



        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserTotal = 0;
                CompTotal = 0;
                userscore.setText("Score: ");
                compscore.setText("Host: ");
                hold.setVisibility(View.INVISIBLE);
                draw.setVisibility(View.INVISIBLE);
                start.setVisibility(View.VISIBLE);
            }
        });
        return view;
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

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (BlackCallBack) context;
    }



    //user decides if they want to draw
    //if user or computer has score greater than or equal to 21 game over
    public void dialogLost(){
        AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
        dialog.setMessage("Host won, game reset")
                .setTitle("Game Over")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        dialog.show();
    }

    public void dialogWin(){
        AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
        dialog.setMessage("You won, game reset")
                .setTitle("Game Over")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        dialog.show();
    }

}
