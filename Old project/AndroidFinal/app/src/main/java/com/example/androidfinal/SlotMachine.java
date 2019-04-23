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
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;


public class SlotMachine extends Fragment {

    SlotMachineCallBack activity;

    public TextView msg;
    public TextView chipMsg;
    public ImageView img1, img2, img3;
    public Wheel wheel1, wheel2, wheel3;
    public Button btn;
    public Button home;
    public boolean isStarted;
    public int chipCount;

    public static final Random RANDOM = new Random();

    public static long randomLong(long lower, long upper) {
        return lower + (long) (RANDOM.nextDouble() * (upper - lower));
    }

    public interface SlotMachineCallBack {
        public void swapOutMenu();
    }

    public SlotMachine() {
        super();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (SlotMachineCallBack) context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.slot_machine_frag, container,
                false);

        chipCount = 100;

        home = view.findViewById(R.id.homeBTN);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.swapOutMenu();
            }
        });

        img1 = view.findViewById(R.id.img1);
        img2 = view.findViewById(R.id.img2);
        img3 = view.findViewById(R.id.img3);
        btn = view.findViewById(R.id.btn);
        msg = view.findViewById(R.id.msg);

        if (btn != null) {
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
                            try {
                                msg.setText("You win 100 chips");
                                chipCount += 100;
                            } catch (NullPointerException e) {
                                System.out.println("Error!");
                            }
                        } else if (wheel1.currentIndex == wheel2.currentIndex || wheel2.currentIndex == wheel3.currentIndex
                                || wheel1.currentIndex == wheel3.currentIndex) {
                            try {
                                msg.setText("You win 10 chips");
                                chipCount += 10;

                            } catch (NullPointerException e) {
                                System.out.println("Error!");
                            }

                        } else {
                            try {
                                msg.setText("You lose try again!");
                            } catch (NullPointerException e) {
                                System.out.println("Error!");
                            }
                        }

                        btn.setText("Spin!");
                        isStarted = false;

                    } else {

                        wheel1 = new Wheel(new Wheel.WheelListener() {
                            @Override
                            public void newImage(final int img) {
                                getActivity().runOnUiThread(new Runnable() {
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
                                getActivity().runOnUiThread(new Runnable() {
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
                                getActivity().runOnUiThread(new Runnable() {
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

            return view;
    }

}

