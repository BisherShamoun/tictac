package com.example.tictacgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ArrayList<Integer> EmptyCells=new  ArrayList<Integer>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void BuClick(View view) {

        Button buSelected=(Button) view;
        int CellID=0;
        switch ((buSelected.getId())){

            case R.id.bu1:
                CellID=1;
            break;

            case R.id.bu2:
                CellID=2;
                break;

            case R.id.bu3:
                CellID=3;
                break;

            case R.id.bu4:
                CellID=4;
                break;

            case R.id.bu5:
                CellID=5;
                break;

            case R.id.bu6:
                CellID=6;
                break;

            case R.id.bu7:
                CellID=7;
                break;

            case R.id.bu8:
                CellID=8;
                break;

            case R.id.bu9:
                CellID=9;
                break;
        }
        PlayGame(CellID,buSelected);
    }

    int ActivePlayer=1;// 1 for first and 2 for second player
    ArrayList<Integer> player1=new ArrayList<Integer>();
    ArrayList<Integer> player2=new ArrayList<Integer>();


    void PlayGame(int CellID,Button buSelected){

        if (ActivePlayer==1){
            buSelected.setText("X");
            buSelected.setBackgroundColor(Color.GREEN);
            player1.add(CellID);
            ActivePlayer=2;
            if (EmptyCells.size()!=1){

                AutoPlay();

            }

          //  AutoPlay();

        }
       else if (ActivePlayer==2){
            buSelected.setText("O");
            buSelected.setBackgroundColor(Color.BLUE);
            player2.add(CellID);
            ActivePlayer=1;

        }
        buSelected.setEnabled(false);
        CheackWiner();
    }
    void CheackWiner(){
        int Winer=-1;
        //row 1
        if (player1.contains(1)&& player1.contains(2)&&player1.contains(3)){
            Winer=1;
        }
        if (player2.contains(1)&& player2.contains(2)&&player2.contains(3)){
            Winer=2;
        }

        //row2
        if (player1.contains(4)&& player1.contains(5)&&player1.contains(6)){
            Winer=1;
        }
        if (player2.contains(4)&& player2.contains(5)&&player2.contains(6)){
            Winer=2;
        }

        //row3
        if (player1.contains(7)&& player1.contains(8)&&player1.contains(9)){
            Winer=1;
        }
        if (player2.contains(7)&& player2.contains(8)&&player2.contains(9)){
            Winer=2;
        }

        //col1
        if (player1.contains(1)&& player1.contains(4)&&player1.contains(7)){
            Winer=1;
        }
        if (player2.contains(1)&& player2.contains(4)&&player2.contains(7)){
            Winer=2;
        }


        //col2
        if (player1.contains(2)&& player1.contains(5)&&player1.contains(8)){
            Winer=1;
        }
        if (player2.contains(2)&& player2.contains(5)&&player2.contains(8)){
            Winer=2;
        }

        //col3
        if (player1.contains(3)&& player1.contains(6)&&player1.contains(9)){
            Winer=1;
        }
        if (player2.contains(3)&& player2.contains(6)&&player2.contains(9)){
            Winer=2;
        }
       if (Winer !=-1){

           if (Winer==1){

               Toast.makeText(this,"player 1",Toast.LENGTH_LONG).show();

           }
           if (Winer==2){

               Toast.makeText(this,"player 2",Toast.LENGTH_LONG).show();

           }


       }
    }

    void AutoPlay(){

      //  ArrayList<Integer> EmptyCells=new  ArrayList<Integer>();

        for (int cellID=1;cellID<10;cellID++){
            if (!(player1.contains(cellID) || player2.contains(cellID))){
                EmptyCells.add(cellID);

            }
        }
        Random r=new Random();
      int  RandIndex=r.nextInt(EmptyCells.size()-0)+0;
        int CellID=EmptyCells.get(RandIndex);
        Button buSelected;
        switch (CellID){

            case 1:
                buSelected=(Button)findViewById(R.id.bu1);
                break;

            case 2:
                buSelected=(Button)findViewById(R.id.bu2);
                break;

            case 3:
                buSelected=(Button)findViewById(R.id.bu3);
                break;

            case 4:
                buSelected=(Button)findViewById(R.id.bu4);
                break;

            case 5:
                buSelected=(Button)findViewById(R.id.bu5);;
                break;

            case 6:
                buSelected=(Button)findViewById(R.id.bu6);
                break;

            case 7:
                buSelected=(Button)findViewById(R.id.bu7);
                break;

            case 8:
                buSelected=(Button)findViewById(R.id.bu8);
                break;

            case 9:
                buSelected=(Button)findViewById(R.id.bu9);
                break;
                default:
                    buSelected=(Button)findViewById(R.id.bu1);
                    break;
        }
        PlayGame(CellID,buSelected);




    }

}
