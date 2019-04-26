package com.example.androidfinal;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements
        SlotMachine.SlotMachineCallBack, Menu.MenuCallBack, blackjack.BlackCallBack, roulette.RouletteCallBack, table.tableCallBack
{

    SlotMachine slotFrag = new SlotMachine();
    Menu menuFrag = new Menu();
    blackjack blackjackFrag = new blackjack();
    roulette rouletteFrag = new roulette();
    table tableFrag = new table();

    boolean red;
    boolean black;
    boolean even;
    boolean odd;
    boolean firstH;
    boolean secondH;
    boolean firstT;
    boolean secondT;
    boolean thridT;
    int userIn;
    String userColor;
    int userBet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction tran = getSupportFragmentManager().beginTransaction();
        tran.add(R.id.fragment_holder, slotFrag);
        tran.add(R.id.fragment_holder, menuFrag);
        tran.add(R.id.fragment_holder, blackjackFrag);
        tran.add(R.id.fragment_holder, rouletteFrag);
        tran.add(R.id.fragment_holder, tableFrag);

        tran.hide(slotFrag);
        tran.hide(blackjackFrag);
        tran.hide(rouletteFrag);
        tran.hide(tableFrag);
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

    @Override
    public void swapOutToTable() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.hide(rouletteFrag);
        transaction.show(tableFrag);
        transaction.commit();
    }

    @Override
    public int betCalc(int correct, String color) {
        int returnBet = 0;

        if ((correct == userIn) && color.matches(userColor)) {
            returnBet += userBet * 35;
        }
        else{
            returnBet += 0;
        }

        if (red || userColor.matches("red") && color.matches("red")) {
                returnBet += userBet * 1;
        }


                if (black || userColor.matches("black") && color.matches("black")) {
                    returnBet = userBet * 1;
                }


            if (firstH && correct <= 18) {
                returnBet += userBet * 2;
            }


            if (secondH && correct >= 19) {
                returnBet += userBet * 2;
            }


            if (firstT && correct <= 12) {
                returnBet += userBet * 3;
                }

            if (secondT && correct > 12 && correct <= 24) {
                returnBet += userBet * 3;
                }

            if (thridT && correct > 24 && correct <= 36) {
                returnBet += userBet * 3;

            }
            if (odd && correct%2 != 0) {
                returnBet += userBet * 1;
            }

            if (even && correct%2 == 0){
                returnBet += userBet * 1;
            }

        return returnBet;
    }

    @Override
    public int totalbet() {
        int counter = 0;
        if(red){
            counter++;
        }
        if(black){
            counter++;
        }
        if(even){
            counter++;
        }
        if(odd){
            counter++;
        }
        if(firstH){
            counter++;
        }
        if(secondH){
            counter++;
        }
        if(firstT){
            counter++;
        }
        if(secondT){
            counter++;
        }
        if(thridT) {
            counter++;
        }
        if(userIn != -1){
            counter++;
        }
        if(!userColor.isEmpty()){
            counter++;
        }
        return counter * userBet;
    }

    @Override
    public void swapOutBack(boolean red1, boolean black1, boolean even1, boolean odd1, boolean firstH1, boolean secondH1, boolean firstT1, boolean secondT1, boolean thridT1, int userIn1, String userColor1, int bet1) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.hide(tableFrag);
        transaction.show(rouletteFrag);
        transaction.commit();

        red = red1;
        black = black1;
        even = even1;
        odd = odd1;
        firstH = firstH1;
        secondH = secondH;
        firstT = firstT1;
        secondT = secondT1;
        thridT = thridT1;
        userIn = userIn1;
        userColor = userColor1;
        userBet = bet1;


    }


}
