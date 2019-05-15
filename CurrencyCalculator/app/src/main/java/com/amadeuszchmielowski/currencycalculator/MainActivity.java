package com.amadeuszchmielowski.currencycalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MainActivity extends AppCompatActivity {

    private double value_euro=0;
    private double value_pln=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView euro = findViewById(R.id.euroId);
        TextView pln = findViewById(R.id.euroId2);
        euro.setText("EUR: " + Double.toString(value_euro)+ "€");
        pln.setText("PLN: " + Double.toString(value_pln)+ "zł");
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public void clickButton(View main_view){
        EditText text = findViewById(R.id.inputnumbers);
        try {
            final double value_ = Double.parseDouble(text.getText().toString());
            ToggleButton switcher = findViewById(R.id.toggleButton);
            if (switcher.getText().toString().equals("EUR")){
                value_euro = value_;
                value_pln = value_*4.3;
            }
            else{
                value_pln = value_;
                value_euro = value_/4.3;
            }
            value_euro = round(value_euro, 2);
            value_pln = round(value_pln, 2);
            TextView euro = findViewById(R.id.euroId);
            TextView pln = findViewById(R.id.euroId2);
            euro.setText("EUR: " + Double.toString(value_euro)+ "€");
            pln.setText("PLN: " + Double.toString(value_pln)+ "zł");
        }
        catch (Exception e){
            Toast.makeText(MainActivity.this, "Give value", Toast.LENGTH_LONG).show();
        }

    }

}
