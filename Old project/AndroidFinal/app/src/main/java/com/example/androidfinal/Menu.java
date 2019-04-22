package com.example.androidfinal;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatImageButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Menu extends Fragment {

    MenuCallBack activity;

    public interface MenuCallBack{
        public void swapOutSlot();
        public void swapOutBlack();
        public void swapOutRoulette();
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        activity= (MenuCallBack) context;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_menu, container,
                false);



        AppCompatImageButton slotBTN = view.findViewById(R.id.SlotMachineStartBTN);
        slotBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.swapOutSlot();
            }
        });

        AppCompatImageButton blackBTN = view.findViewById(R.id.BlackJackStartBTN);
        blackBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.swapOutBlack();
            }
        });

        AppCompatImageButton rouletteBTN = view.findViewById(R.id.RouletteWheelStartBTN);
        rouletteBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.swapOutRoulette();
            }
        });

        return view;
    }
}
