package com.amadeuszchmielowski.connect3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // 0 = yello, 1 = red
    int activePlayer=0;
    boolean gameActive = true;

    int[] gameState = {-1, -1, -1, -1, -1, -1, -1, -1, -1};

    int[][] wining_positions = {
            {0,1,2},
            {3,4,5},
            {6,7,8},
            {0,3,6},
            {1,4,7},
            {2,5,8},
            {0,4,8},
            {2,4,6}
    };

    public void dropIn(View view){
        ImageView counter = (ImageView) view;
        int place = Integer.parseInt(counter.getTag().toString());

        if(gameState[place] == -1 && gameActive) {
            gameState[place] = activePlayer;
            counter.setTranslationY(-5000f);
            if (activePlayer == 0) {
                counter.setImageResource(R.drawable.yellow);
                activePlayer = 1;
            } else {
                counter.setImageResource(R.drawable.red);
                activePlayer = 0;
            }
            counter.animate().translationYBy(5000f).rotation(360f).setDuration(500);
            for(int[] winingPosition: wining_positions){
                if(gameState[winingPosition[0]] == gameState[winingPosition[1]] &&
                        gameState[winingPosition[1]] == gameState[winingPosition[2]] &&
                            gameState[winingPosition[0]] != -1){
                    //same one has won
                    gameActive = false;
                    TextView winner_msg = findViewById(R.id.winner);
                    String winner = "Red";
                    if(gameState[winingPosition[0]] == 0){
                        winner = "Yellow";
                    }
                    winner_msg.setText(winner +" player has won");


                    LinearLayout layout = findViewById(R.id.playAgainLayout);
                    layout.setAlpha(0f);
                    layout.setVisibility(View.VISIBLE);
                    layout.animate().alpha(1f).setStartDelay(300).setDuration(1000);
                }
                else{
                    boolean draw = true;
                    for(int value:gameState){
                        if(value == -1) draw = false;
                    }
                    if(draw){

                        TextView winner_msg = findViewById(R.id.winner);

                        winner_msg.setText("It's a draw");

                        LinearLayout layout = findViewById(R.id.playAgainLayout);
                        layout.setAlpha(0f);
                        layout.setVisibility(View.VISIBLE);
                        layout.animate().alpha(1f).setStartDelay(300).setDuration(1000);
                    }
                }
            }
        }
    }

    public void playAgain(View view){

        try {
            activePlayer=0;
            int new_gameState = -1;
            gameActive = true;
            LinearLayout layout = findViewById(R.id.playAgainLayout);
            layout.setVisibility(View.INVISIBLE);

            for(int i =0; i<gameState.length; i++){
                gameState[i] = new_gameState;
            }

            android.support.v7.widget.GridLayout grid = findViewById(R.id.mainGrid);
            for(int i =0; i<grid.getChildCount(); i++){
                ((ImageView) grid.getChildAt(i)).setImageResource(0);
            }
        }
        catch (Exception e){
            Log.i("Kurczak", e.toString());
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
