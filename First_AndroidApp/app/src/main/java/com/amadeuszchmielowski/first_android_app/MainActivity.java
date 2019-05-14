package com.amadeuszchmielowski.first_android_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private boolean flag = false;

    public void clickFunction(View view) {

        EditText text = findViewById(R.id.myTextField);
        EditText text2 = findViewById(R.id.editText2);
        ImageView image = findViewById(R.id.imageView);
        if (flag == false){
            image.setImageResource(R.drawable.background_hdpi);
            flag = true;
        }
        else{
            image.setImageResource(R.drawable.settings);
            flag = false;
        }

        text.setText(text2.getText().toString());
        Toast.makeText(MainActivity.this, text2.getText().toString(), Toast.LENGTH_SHORT).show();
        Log.i("Info", text.getText().toString() + " " + text2.getText().toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
