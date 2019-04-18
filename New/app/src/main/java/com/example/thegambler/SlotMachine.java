package com.example.thegambler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class SlotMachine extends AppCompatActivity {

    public TextView msg;
    public TextView chipMsg;
    public ImageView img1, img2, img3;
    public Wheel wheel1, wheel2, wheel3;
    public Button btn;
    public boolean isStarted;
    public int chipCount;

    public static final Random RANDOM = new Random();

    public static long randomLong(long lower, long upper) {
        return lower + (long) (RANDOM.nextDouble() * (upper - lower));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chipCount = 100;

//        img1 = findViewById(R.id.img1);
//        img2 = findViewById(R.id.img2);
//        img3 = findViewById(R.id.img3);
//        btn = findViewById(R.id.btn);
//        msg = findViewById(R.id.msg);
//        chipMsg = findViewById(R.id.chipCount);

        //chipMsg.setText("Your current chip count is: "+ chipCount);

        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);
        img3 = findViewById(R.id.img3);
        btn = findViewById(R.id.btn);
        msg = findViewById(R.id.msg);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isStarted) {
                    chipCount -= 10;
                    //chipMsg.setText("Your current chip count is: ");
                    wheel1.stopWheel();
                    wheel2.stopWheel();
                    wheel3.stopWheel();

                    if (wheel1.currentIndex == wheel2.currentIndex && wheel2.currentIndex == wheel3.currentIndex) {
                        msg.setText("You win 100 chips");
                        chipCount += 100;
                    }
                    else if (wheel1.currentIndex == wheel2.currentIndex || wheel2.currentIndex == wheel3.currentIndex
                            || wheel1.currentIndex == wheel3.currentIndex) {
                        msg.setText("You win 10 chips");
                        chipCount += 10;
                    } else {
                        msg.setText("You lose try again!");
                    }

                    btn.setText("Spin!");
                    isStarted = false;

                } else {

                    wheel1 = new Wheel(new Wheel.WheelListener() {
                        @Override
                        public void newImage(final int img) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    img1.setImageResource(img);
                                }
                            });
                        }
                    }, 200, randomLong(0, 200));

                    wheel1.start();

                    wheel2 = new Wheel(new Wheel.WheelListener() {
                        @Override
                        public void newImage(final int img) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    img2.setImageResource(img);
                                }
                            });
                        }
                    }, 200, randomLong(150, 400));

                    wheel2.start();

                    wheel3 = new Wheel(new Wheel.WheelListener() {
                        @Override
                        public void newImage(final int img) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    img3.setImageResource(img);
                                }
                            });
                        }
                    }, 200, randomLong(150, 400));

                    wheel3.start();

                    btn.setText("Stop");
                    msg.setText("");
                    isStarted = true;
                }
            }
        });
    }
}
