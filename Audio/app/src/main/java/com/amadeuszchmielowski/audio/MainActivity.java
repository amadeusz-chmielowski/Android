package com.amadeuszchmielowski.audio;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mplayer;

    public void playAudio(View view) {
        mplayer.start();
    }

    public void pauseAudio(View view) {
        mplayer.pause();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mplayer = MediaPlayer.create(this, R.raw.audio_fire);

        SeekBar volumeController = findViewById(R.id.seekBar);
        

    }
}
