package com.example.androidfinal;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;


public class table extends Fragment {


    tableCallBack activity;

    Button back;

    CheckBox red;
    CheckBox black;
    CheckBox even;
    CheckBox odd;
    CheckBox firstHalf;
    CheckBox secondHalf;
    CheckBox firstThird;
    CheckBox secondThird;
    CheckBox thirdThird;
    EditText userGuess;
    EditText userColor;
    EditText userBet;
    int user;
    int bet;


    public interface tableCallBack{
         public void swapOutBack( boolean red, boolean black, boolean even, boolean odd, boolean firstH, boolean secondH, boolean firstT, boolean secondT, boolean thridT, int userIn, String userColor, int bet);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_table, container,
                false);
        back = view.findViewById(R.id.backBTN);

        red = view.findViewById(R.id.redCheck);
        black = view.findViewById(R.id.blackCheck);
        even = view.findViewById(R.id.evenCheck);
        odd = view.findViewById(R.id.oddCheck);
        firstHalf = view.findViewById(R.id.firstCheck);
        secondHalf = view.findViewById(R.id.secondCheck);
        firstThird = view.findViewById(R.id.first3Check);
        secondThird = view.findViewById(R.id.second3Check);
        thirdThird = view.findViewById(R.id.third3Check);
        userGuess = view.findViewById(R.id.enterNum);
        userColor = view.findViewById(R.id.userColor);
        userBet = view.findViewById(R.id.betAmount);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String temp = userGuess.getText().toString();

                if (temp.matches("")) {
                    user = -1;
                }
                else{
                    user = Integer.parseInt(userGuess.getText().toString());

                }
                temp = userBet.getText().toString();
                if(temp.matches("")) {
                    bet = 0;
                }
                else {
                    bet = Integer.parseInt(userBet.getText().toString());

                }
                activity.swapOutBack(red.isChecked(), black.isChecked(), even.isChecked(), odd.isChecked(), firstHalf.isChecked(), secondHalf.isChecked(), firstThird.isChecked(), secondThird.isChecked(), thirdThird.isChecked(), user, userColor.getText().toString().toLowerCase(), bet);
            }
        });


        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (tableCallBack) context;


    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
