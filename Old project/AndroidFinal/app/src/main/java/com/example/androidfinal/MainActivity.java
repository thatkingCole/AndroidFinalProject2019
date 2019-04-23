package com.example.androidfinal;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements
        SlotMachine.SlotMachineCallBack, Menu.MenuCallBack, blackjack.BlackCallBack, roulette.RouletteCallBack
{

    SlotMachine slotFrag = new SlotMachine();
    Menu menuFrag = new Menu();
    blackjack blackjackFrag = new blackjack();
    roulette rouletteFrag = new roulette();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction tran = getSupportFragmentManager().beginTransaction();
        tran.add(R.id.fragment_holder, slotFrag);
        tran.add(R.id.fragment_holder, menuFrag);
        tran.add(R.id.fragment_holder, blackjackFrag);
        tran.add(R.id.fragment_holder, rouletteFrag);

        tran.hide(slotFrag);
        tran.hide(blackjackFrag);
        tran.hide(rouletteFrag);
        tran.show(menuFrag);
        tran.commit();
    }


    public void swapOutSlot(){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.show(slotFrag);
        transaction.hide(menuFrag);
        transaction.commit();
    }

    @Override
    public void swapOutBlack() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.show(blackjackFrag);
        transaction.hide(menuFrag);
        transaction.commit();
    }

    public void swapOutRoulette(){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.show(rouletteFrag);
        transaction.hide(menuFrag);
        transaction.commit();
    }

    @Override
    public void swapOutMenu() {

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.hide(rouletteFrag);
        transaction.hide(blackjackFrag);
        transaction.hide(slotFrag);
        transaction.show(menuFrag);
        transaction.commit();

    }
}
