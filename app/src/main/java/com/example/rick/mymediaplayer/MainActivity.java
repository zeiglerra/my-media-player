package com.example.rick.mymediaplayer;

import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.example.rick.mymediaplayer.utils.StringTimeCreate;
import com.example.rick.mymediaplayer.utils.Time;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private MediaMetadataRetriever mediaMetadataRetriever;
    private ToggleButton btnPlayPause;
    private Button btnPrevious;
    private Button btnNext;
    private SeekBar skbMusicBar;
    private TextView txvAlbum;
    private TextView txvSong;
    private TextView txvArtist;
    private TextView txvCurrentTime;
    private TextView txvEndTime;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(this,R.raw.dont_get_in_my_way);
        mediaMetadataRetriever = new MediaMetadataRetriever();
        btnPlayPause = findViewById (R.id.btnPlayPause);
        btnPrevious = findViewById (R.id.btnPrevious);
        btnNext = findViewById (R.id.btnNext);
        skbMusicBar = findViewById (R.id.skbMusicBar);
        txvAlbum = findViewById (R.id.txvAlbum);
        txvArtist = findViewById (R.id.txvArtist);
        txvSong = findViewById (R.id.txvSong);
        txvCurrentTime = findViewById(R.id.txvCurrentTime);
        txvEndTime = findViewById(R.id.txvEndTime);

        skbMusicBar.setMin(0);
        final int duration = mediaPlayer.getDuration() / Time.ONE_SECOND_IN_MILLISECONDS;
        skbMusicBar.setMax(duration);

        String strDurationTime = StringTimeCreate.getTimeUsingSeconds(duration);
        txvEndTime.setText(strDurationTime);

        MediaControls mediaControls = new MediaControls(this);
        btnPlayPause.setOnCheckedChangeListener(mediaControls);
        btnPrevious.setOnClickListener(mediaControls);
        btnNext.setOnClickListener(mediaControls);

        MediaThread mediaThread = new MediaThread(this);
        MainActivity.this.runOnUiThread(mediaThread);

    }

    public MediaPlayer getMediaPlayer() { return mediaPlayer; }
    public MediaMetadataRetriever getMediaMetadataRetriever() { return mediaMetadataRetriever; }
    public ToggleButton getBtnPlayPause() { return btnPlayPause; }
    public Button getBtnPrevious() { return btnPrevious;}
    public Button getBtnNext() { return btnNext; }
    public SeekBar getSkbMusicBar() { return skbMusicBar; }
    public TextView getTxvAlbum() { return txvAlbum; }
    public TextView getTxvSong() { return txvSong; }
    public TextView getTxvArtist() { return txvArtist; }
    public TextView getTxvCurrentTime() { return txvCurrentTime; }
    public TextView getTxvEndTime() { return txvEndTime; }

}
