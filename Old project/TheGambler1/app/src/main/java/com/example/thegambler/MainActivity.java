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

//    public void switchRouletteWheel(View v){
//        //start button for RouletteWheel
//        ImageButton RouletteWheelStartBTN = findViewById(R.id.RouletteWheelStartBTN);
//        RouletteWheelStartBTN.setOnClickListener(
//                new ImageButton.OnClickListener(){
//                    @Override
//                    public void onClick(View v) {
//                        Intent Wheelintent = new Intent(MainActivity.this, Wheel.class);
//                        startActivity(Wheelintent);
//                    }
//                }
//        );
//    }
//
//    public void switchBlackJack(View v){
//        //start button for BlackJack
//        ImageButton BlackJackStartBTN = findViewById(R.id.BlackJackStartBTN);
//        BlackJackStartBTN.setOnClickListener(
//                new ImageButton.OnClickListener(){
//                    @Override
//                    public void onClick(View v) {
//                        Intent BJintent = new Intent(MainActivity.this, BlackJack.class);
//                        startActivity(BJintent);
//                    }
//                }
//        );
//    }
//
//    public void switchSlotMachine(View v){
//        //start button for SlotMachine
//        ImageButton SlotMachineStartBTN = findViewById(R.id.SlotMachineStartBTN);
//        SlotMachineStartBTN.setOnClickListener(
//                new ImageButton.OnClickListener(){
//                    @Override
//                    public void onClick(View v) {
//                        Intent SMintent = new Intent(MainActivity.this, SlotMachine.class);
//                        startActivity(SMintent);
//                    }
//                }
//        );
//    }


    //previous code reference commented out due to everything being red -josh
    //intent reference from class
//    public void dialAction(View v) {
//        String number = "tel:6561515";
//        Intent dial = new Intent(Intent.ACTION_DIAL);
//        dial.setData(Uri.parse(number));
//        startActivity(dial);
//
//        String loc = "https://www.google.com/";
//        Intent go = new Intent(Intent.ACTION_VIEW);
//        go.setData(Uri.parse(loc));
//        startActivity(go);
//    }
//
//    public void switchAction(View v) {
//        Intent switchAction = new Intent(this, SlotMachine.class);
//        startActivity(switchAction);
//                } else {
//
//                    wheel1 = new Wheel(new Wheel.WheelListener() {
//                        @Override
//                        public void newImage(final int img) {
//                            runOnUiThread(new Runnable() {
//                                @Override
//                                public void run() {
//                                    img1.setImageResource(img);
//                                }
//                            });
//                        }
//                    }, 200, randomLong(0, 200));
//
//                    wheel1.start();
//
//                    wheel2 = new Wheel(new Wheel.WheelListener() {
//                        @Override
//                        public void newImage(final int img) {
//                            runOnUiThread(new Runnable() {
//                                @Override
//                                public void run() {
//                                    img2.setImageResource(img);
//                                }
//                            });
//                        }
//                    }, 200, randomLong(150, 400));
//
//                    wheel2.start();
//
//                    wheel3 = new Wheel(new Wheel.WheelListener() {
//                        @Override
//                        public void newImage(final int img) {
//                            runOnUiThread(new Runnable() {
//                                @Override
//                                public void run() {
//                                    img3.setImageResource(img);
//                                }
//                            });
//                        }
//                    }, 200, randomLong(150, 400));
//
//                    wheel3.start();
//
//                    btn.setText("Stop");
//                    msg.setText("");
//                    isStarted = true;
//                }
//            }
//        });
//
//
//    }
//    public void switchActionBlackJack(View view){
//        Intent swap = new Intent(this,BlackJack.class);
//        startActivity(swap);
//   }
}

