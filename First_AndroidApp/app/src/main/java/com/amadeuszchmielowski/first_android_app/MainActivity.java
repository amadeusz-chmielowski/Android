package com.amadeuszchmielowski.first_android_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public void clickFunction(View view) {
        EditText text = findViewById(R.id.myTextField);
        EditText text2 = findViewById(R.id.editText2);
        Log.i("Info", text.getText().toString() + " " + text2.getText().toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
