package com.example.rick.mymediaplayer;

import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private MediaMetadataRetriever mediaMetadataRetriever;
    private Handler mediaHandler;
    private ToggleButton btnPlayPause;
    private Button btnPrevious;
    private Button btnNext;
    private SeekBar skbMusicBar;
    private TextView txvAlbum;
    private TextView txvSong;
    private TextView txvArtist;
    
    private final int ONE_SECOND = 1000;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(this,R.raw.dont_get_in_my_way);
        mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaHandler = new Handler();
        btnPlayPause = findViewById (R.id.btnPlayPause);
        btnPrevious = findViewById (R.id.btnPrevious);
        btnNext = findViewById (R.id.btnNext);
        skbMusicBar = findViewById (R.id.skbMusicBar);
        txvAlbum = findViewById (R.id.txvAlbum);
        txvArtist = findViewById (R.id.txvArtist);
        txvSong = findViewById (R.id.txvSong);

        skbMusicBar.setMin(0);
        skbMusicBar.setMax(mediaPlayer.getDuration() / ONE_SECOND);

        MainActivity.this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (mediaPlayer != null) {
                    int currentPos = mediaPlayer.getCurrentPosition() / ONE_SECOND;
                    System.out.println("Current position: " + currentPos);
                    skbMusicBar.setProgress(currentPos);
                }
                mediaHandler.postDelayed(this, ONE_SECOND);
            }
        });

        btnPlayPause.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    mediaPlayer.start();
                } else {
                    mediaPlayer.pause();
                }

            }
        });

        btnPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        skbMusicBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mediaPlayer.seekTo(seekBar.getProgress() * ONE_SECOND);
            }
        });

    }

}
