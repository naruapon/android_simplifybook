package com.example.supot.vidioplayexternal;

import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import java.io.IOException;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;

public class MainActivity extends AppCompatActivity {
    private VideoView PlayerVedio;
    private String filePathvedio;
    public static final int RequestPermissionCode = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        VideoView PlayerVedio = (VideoView) findViewById(R.id.videoView);
        MediaController  mController  =  new MediaController(this);
      //  PlayerVedio.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.video);
        if(checkPermission()) {
            filePathvedio = Environment.getExternalStorageDirectory().getAbsolutePath()+"/Movies/video.mp4";

            PlayerVedio.setVideoURI(Uri.parse(filePathvedio));
        } else {
            // requestPermission();
            ActivityCompat.requestPermissions(MainActivity.this, new
                    String[]{READ_EXTERNAL_STORAGE}, RequestPermissionCode);
        }
        mController.setAnchorView(PlayerVedio);
        PlayerVedio.setMediaController(mController);
        PlayerVedio.start();
    }
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case RequestPermissionCode:
                boolean StoragePermission = grantResults[0] ==
                        PackageManager.PERMISSION_GRANTED;

                if (StoragePermission) {
                    Toast.makeText(MainActivity.this, "Permission Granted",
                            Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this,"Permission Denied",Toast.LENGTH_LONG).show();
                }

                break;
        }
    }
    public boolean checkPermission() {
        int result = ContextCompat.checkSelfPermission(getApplicationContext(),
                READ_EXTERNAL_STORAGE);

        return result == PackageManager.PERMISSION_GRANTED;

    }
}
