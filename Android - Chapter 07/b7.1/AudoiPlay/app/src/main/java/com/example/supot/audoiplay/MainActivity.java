package com.example.supot.audoiplay;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements MediaPlayer.OnPreparedListener, MediaController.MediaPlayerControl,View.OnClickListener {
    private MediaPlayer mPlayer;
    private MediaController mControl;
    private String filename;
    private Button btn_play;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_play = (Button)findViewById(R.id.btn_play);
        btn_play.setOnClickListener(this);
        mPlayer = new MediaPlayer();
        mPlayer.setOnPreparedListener(this);
        mControl = new MediaController(this);
    }
    @Override
    public void onPrepared(MediaPlayer mp) {
        mControl.setMediaPlayer(this);
        mControl.setAnchorView(findViewById(R.id.Controller));
        mControl.setEnabled(true);
        mControl.show();
    }

    @Override
    public void onClick(View v) {
       filename = "android.resource://" + this.getPackageName() + "/raw/song";

        try {

            mPlayer.setDataSource(this, Uri.parse(filename));
            mPlayer.prepare();
            mPlayer.start();
        } catch (IOException e) {
            Toast.makeText(getApplicationContext(), "Could not open file " + filename + " for playback."+ e,
                    Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mControl.show();
        return super.onTouchEvent(event);
    }
    @Override
    public void start() {
        mPlayer.start();
    }

    @Override
    public void pause() {
        mPlayer.pause();
    }

    @Override
    public int getDuration() {
        return mPlayer.getDuration();
    }

    @Override
    public int getCurrentPosition() {
        return mPlayer.getCurrentPosition();
    }

    @Override
    public void seekTo(int pos) {
        mPlayer.seekTo(pos);
    }

    @Override
    public boolean isPlaying() {
        return mPlayer.isPlaying();
    }

    @Override
    public int getBufferPercentage() {
        int percentage = (mPlayer.getCurrentPosition() * 100) / mPlayer.getDuration();
        return percentage;
    }

    @Override
    public boolean canPause() {
        return true;
    }

    @Override
    public boolean canSeekBackward() {
        return true;
    }

    @Override
    public boolean canSeekForward() {
        return true;
    }

    @Override
    public int getAudioSessionId() {
        return 0;
    }
}
