package com.example.rick.mymediaplayer;

import android.app.Activity;
import android.media.MediaPlayer;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.rick.mymediaplayer.utils.Time;

/**
 * Created by Rick on 2/15/2018.
 */

public final class MediaControlsHandler implements View.OnClickListener,
        CompoundButton.OnCheckedChangeListener, SeekBar.OnSeekBarChangeListener {

    private MainActivity mainActivity;
    private MediaPlayer mediaPlayer;
    private ToggleButton btnPlayPause;
    private Button btnPrevious;
    private Button btnNext;

    public MediaControlsHandler(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        this.mediaPlayer = mainActivity.getMediaPlayer();
        this.btnPlayPause = mainActivity.getBtnPlayPause();
        this.btnPrevious = mainActivity.getBtnPrevious();
        this.btnNext = mainActivity.getBtnNext();
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        if (isChecked) {
            mediaPlayer.start();
        } else {
            mediaPlayer.pause();
        }

    }

    @Override
    public void onClick(View v) {

        if (btnPrevious == v) {
            Toast.makeText(mainActivity.getApplicationContext(),"Pushed previous!",Toast.LENGTH_SHORT).show();
        }

        if (btnNext == v) {
            Toast.makeText(mainActivity.getApplicationContext(),"Pushed next!",Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        mediaPlayer.seekTo(seekBar.getProgress() * Time.ONE_SECOND_IN_MILLISECONDS);
    }

}
