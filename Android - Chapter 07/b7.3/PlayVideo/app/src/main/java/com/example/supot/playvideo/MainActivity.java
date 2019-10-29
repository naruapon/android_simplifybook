package com.example.supot.playvideo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        VideoView PlayerVedio = (VideoView) findViewById(R.id.videoView);
        MediaController mController  =  new MediaController(this);
        PlayerVedio.setVideoPath("android.resource://" + this.getPackageName() + "/raw/video");
        mController.setAnchorView(PlayerVedio);
        PlayerVedio.setMediaController(mController);
        PlayerVedio.start();
    }
}
