package com.amadeuszchmielowski.animations;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.Timer;

public class MainActivity extends AppCompatActivity {


    public void fadeAway(View view){
        ImageView image = findViewById(R.id.Jake);

        image.animate()
                .translationXBy(10000f)
                .translationYBy(10000f)
                .rotationBy(3600f)
                .setDuration(2000);
        image.animate().scaleX(0.5f).scaleY(0.5f).setDuration(1000);
        //ImageView finn = findViewById(R.id.Finn);
        //image.animate().alpha(0f).setDuration(2000);
       // finn.animate().setDuration(2000).scaleX(0.1f).scaleX(0.1f);
        //finn.animate().alpha(0f).setStartDelay(0).setDuration(2000);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView image = findViewById(R.id.Jake);

        image.setTranslationX(-10000f);
        image.setTranslationY(-10000f);
    }
}
