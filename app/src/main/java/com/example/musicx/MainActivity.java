package com.example.musicx;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    MediaPlayer player;
    Button Bplay;
    Button Bpause;
    public void play(View v){
        player.start();
    //    Bplay.setVisibility(v.GONE);
    //    Bpause.setVisibility(v.VISIBLE);
    }

    public void pause(View v){
        player.pause();
     //   Bpause.setVisibility(v.GONE);
     //   Bplay.setVisibility(v.VISIBLE);
    }

    public void stop(View v){
        player.stop();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        player=MediaPlayer.create(this,R.raw.scam);
        Bplay=(Button) findViewById(R.id.playB);
        Bpause=(Button) findViewById(R.id.pauseB);

        final  SeekBar s= findViewById(R.id.seekBar);
        s.setMax(player.getDuration());

        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                s.setProgress(player.getCurrentPosition());
            }
        },0,1000);

        s.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                player.seekTo(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}