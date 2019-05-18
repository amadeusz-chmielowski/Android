package com.amadeuszchmielowski.higherorlower;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public int firstNumber = 0;
    public int secondNumber = 0;
    private int number = 0;


    public void makeToast(String string){

        Toast.makeText(MainActivity.this, string, Toast.LENGTH_LONG).show();
    }
    public void clicer(View view){
        Random generator = new Random();
        try {
            EditText text = findViewById(R.id.numbers);
            int value = Integer.valueOf(text.getText().toString());
            if(value == number){
               makeToast("Congrats!");
                number = generator.nextInt(secondNumber)+1;
            }
            else if(value > number){
                makeToast("Lower!");
            }
            else{
                makeToast("Higher");
            }
            text.setText("");
        }
        catch (Exception ex){
            makeToast(ex.toString());
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        firstNumber = getResources().getInteger(R.integer.firstNumber_);
        secondNumber = getResources().getInteger(R.integer.secondNumber_);
        Random generator = new Random();
        setContentView(R.layout.activity_main);
        String text = getString(R.string.top_title, firstNumber, secondNumber);
        TextView topTitle = findViewById(R.id.topTitle);
        topTitle.setText(text);
        number = generator.nextInt(secondNumber)+1;
    }
}
