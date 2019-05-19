package com.amadeuszchmielowski.audio;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mplayer;
    AudioManager audioManager;

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

        audioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
        int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int currentVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);



        SeekBar volumeController = findViewById(R.id.seekBar);
        volumeController.setMax(maxVolume);
        volumeController.setProgress(currentVolume);

        volumeController.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.i("SeekBar", Integer.toString(progress));
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        final SeekBar timeController = findViewById(R.id.seekBar2);
        int maxLength = mplayer.getDuration();
        timeController.setMax(maxLength);

        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                timeController.setProgress(mplayer.getCurrentPosition());
            }
        }, 0, 10);

        timeController.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mplayer.seekTo(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                mplayer.pause();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}
