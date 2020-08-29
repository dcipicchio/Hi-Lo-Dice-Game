package com.example.diceroller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ImageView imageViewDie;
    private ImageView imageViewDie2;

    private TextView dealerView;
    private TextView playerView;

    private Button rollButton;
    private Button highButton;
    private Button lowButton;
    private Button newRound;

    private Random rand = new Random();

    private int dealerTotal;
    private int playerTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int dealerTotal = 0;
        int playerTotal = 0;
        setContentView(R.layout.activity_main);

        imageViewDie = findViewById(R.id.image_view_dice);
        imageViewDie2 = findViewById(R.id.image_view_dice2);

        dealerView = findViewById(R.id.dealerTotal);
        playerView = findViewById(R.id.playerTotal);

        highButton = findViewById(R.id.high);
        highButton.setEnabled(false);
        highButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rollDie();
                highButton.setEnabled(false);
                lowButton.setEnabled(false);
                high();
            }
        });

        lowButton = findViewById(R.id.low);
        lowButton.setEnabled(false);
        lowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rollDie();
                highButton.setEnabled(false);
                lowButton.setEnabled(false);
                low();
            }
        });


        rollButton = findViewById(R.id.button4);
        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rollDie();
            }
        });

        newRound = findViewById(R.id.newRound);
        newRound.setEnabled(false);
        newRound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reset();
            }
        });
    }


    private void reset() {
        dealerTotal = 0;
        playerTotal = 0;
        rollButton.setEnabled(true);
        rollButton.setText("Dealer's Turn");
        highButton.setEnabled(false);
        lowButton.setEnabled(false);
        playerView.setText("Player's total: ");
        dealerView.setText("Dealer's total: ");
        newRound.setEnabled(false);
    }

    private void rollDie() {
        int randomNum1 = rand.nextInt(6) + 1;
        int randomNum2 = rand.nextInt(6) + 1;
        int total = randomNum1 + randomNum2;
        switch (randomNum1) {
            case 1:
                imageViewDie.setImageResource(R.drawable.dice1);
                break;
            case 2:
                imageViewDie.setImageResource(R.drawable.dice2);
                break;
            case 3:
                imageViewDie.setImageResource(R.drawable.dice3);
                break;
            case 4:
                imageViewDie.setImageResource(R.drawable.dice4);
                break;
            case 5:
                imageViewDie.setImageResource(R.drawable.dice5);
                break;
            case 6:
                imageViewDie.setImageResource(R.drawable.dice6);
                break;
        }
        switch (randomNum2) {
            case 1:
                imageViewDie2.setImageResource(R.drawable.dice1);
                break;
            case 2:
                imageViewDie2.setImageResource(R.drawable.dice2);
                break;
            case 3:
                imageViewDie2.setImageResource(R.drawable.dice3);
                break;
            case 4:
                imageViewDie2.setImageResource(R.drawable.dice4);
                break;
            case 5:
                imageViewDie2.setImageResource(R.drawable.dice5);
                break;
            case 6:
                imageViewDie2.setImageResource(R.drawable.dice6);
                break;
        }
        if(rollButton.getText().equals("Dealer's Turn"))
        {
            dealerTotal = total;
            dealerView.setText("Dealer total: " + dealerTotal);
            rollButton.setText("Player's turn");
            rollButton.setEnabled(false);
        }else{
            playerTotal = total;
            playerView.setText("Player's total: " + playerTotal);
            rollButton.setText("");
            rollButton.setEnabled(false);
        }
        highButton.setEnabled(true);
        lowButton.setEnabled(true);

    }

    private void high(){
        if(playerTotal > dealerTotal){
            win();
        }
        else if(playerTotal < dealerTotal)
        {
            lose();
        }
        else{
            draw();
        }
    }

    private void low(){
        if(playerTotal < dealerTotal){
            win();
        }
        else if(playerTotal > dealerTotal){
            lose();
        }else{
            draw();
        }
    }

    private void win() {
        Toast.makeText(this, "You won!",Toast.LENGTH_LONG).show();
        newRound.setEnabled(true);

    }

    private void lose(){
        Toast.makeText(this, "You lost!", Toast.LENGTH_LONG).show();
        newRound.setEnabled(true);

    }

    public void draw(){
        Toast.makeText(this, "Draw!", Toast.LENGTH_LONG).show();
        newRound.setEnabled(true);
    }


}