package com.example.rick.mymediaplayer;

import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.os.Handler;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.example.rick.mymediaplayer.utils.StringTimeCreate;
import com.example.rick.mymediaplayer.utils.Time;

/**
 * Created by Rick on 2/15/2018.
 */

public final class MediaThread implements Runnable {

    private MediaPlayer mediaPlayer;
    private Handler mediaHandler;
    private SeekBar skbMusicBar;
    private TextView txvCurrentTime;

    public MediaThread(MainActivity mainActivity) {
        this.mediaPlayer = mainActivity.getMediaPlayer();
        this.skbMusicBar = mainActivity.getSkbMusicBar();
        this.txvCurrentTime = mainActivity.getTxvCurrentTime();
        mediaHandler = new Handler();
    }

    @Override
    public void run() {
        if (mediaPlayer != null) {
            int currentTime = mediaPlayer.getCurrentPosition() / Time.ONE_SECOND_IN_MILLISECONDS;
            skbMusicBar.setProgress(currentTime);
            String strCurrentTime = StringTimeCreate.getTimeUsingSeconds(currentTime);
            txvCurrentTime.setText(strCurrentTime);
        }
        mediaHandler.postDelayed(this, Time.ONE_SECOND_IN_MILLISECONDS);
    }

}
