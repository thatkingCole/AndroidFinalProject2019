package com.example.thegambler;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton rouletteWheelBTM = findViewById(R.id.RouletteWheelStartBTN);
        rouletteWheelBTM.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this, Roulette.class));
            }
        });
        ImageButton SlotMachineBTM = findViewById(R.id.SlotMachineStartBTN);
        SlotMachineBTM.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this, SlotMachine.class));
            }
        });
        ImageButton BlackJackBTM = findViewById(R.id.BlackJackStartBTN);
        BlackJackBTM.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this, BlackJack.class));
            }
        });

    }
}

