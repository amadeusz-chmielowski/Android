package com.amadeuszchmielowski.gridleyout;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void buttonTapped(View view){
        try {
            int id = view.getId();
            String ourId = "";
            ourId = view.getResources().getResourceEntryName(id);
            Toast.makeText(getApplicationContext(), Integer.toString(id), Toast.LENGTH_LONG);
            int resourceId = getResources().getIdentifier(ourId, "raw", "com.amadeuszchmielowski.gridleyout");
            MediaPlayer mplayer = MediaPlayer.create(this, resourceId);
            mplayer.start();
        }
        catch (Exception e)
        {
            Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
