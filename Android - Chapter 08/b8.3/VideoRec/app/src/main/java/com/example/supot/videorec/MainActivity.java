package com.example.supot.videorec;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;

import static android.Manifest.permission.CAMERA;
import static android.Manifest.permission.RECORD_AUDIO;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class MainActivity extends AppCompatActivity {
    Uri outputFileUri;
    private int VIDEO_CAPTURE = 100;
    public static final int RequestPermissionCode = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button)findViewById(R.id.btn_capture);
    }
    public void CaptureVideo(View v) {
        if(checkPermission()){
            File FileDir = new File(Environment.getExternalStorageDirectory().
                    getAbsolutePath() + "video.mp4");
            Intent intentVideo = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
            intentVideo.putExtra(MediaStore.EXTRA_OUTPUT, outputFileUri);
            startActivityForResult(intentVideo, VIDEO_CAPTURE);
            outputFileUri = Uri.fromFile(FileDir);
        } else {
            // requestPermission();
            ActivityCompat.requestPermissions(MainActivity.this, new
                    String[]{WRITE_EXTERNAL_STORAGE, RECORD_AUDIO,CAMERA}, RequestPermissionCode);
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case RequestPermissionCode:
                if (grantResults.length> 0) {
                    boolean StoragePermission = grantResults[0] ==
                            PackageManager.PERMISSION_GRANTED;
                    boolean RecordPermission = grantResults[1] ==
                            PackageManager.PERMISSION_GRANTED;
                    boolean CarmeraPermission = grantResults[2] ==
                            PackageManager.PERMISSION_GRANTED;

                    if (StoragePermission && RecordPermission && CarmeraPermission) {
                        Toast.makeText(MainActivity.this, "Permission Granted",
                                Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(MainActivity.this,"Permission Denied",Toast.LENGTH_LONG).show();
                    }
                }
                break;
        }
    }
    public boolean checkPermission() {
        int result = ContextCompat.checkSelfPermission(getApplicationContext(),
                WRITE_EXTERNAL_STORAGE);
        int result1 = ContextCompat.checkSelfPermission(getApplicationContext(),
                RECORD_AUDIO);
        int result2 = ContextCompat.checkSelfPermission(getApplicationContext(),
                CAMERA);
        return result == PackageManager.PERMISSION_GRANTED &&
                result1 == PackageManager.PERMISSION_GRANTED &&
                result2 == PackageManager.PERMISSION_GRANTED;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent data) {
        if (requestCode == VIDEO_CAPTURE && resultCode == RESULT_OK) {

            Toast.makeText(this, outputFileUri.toString(),Toast //ผ่าน Toast
                    .LENGTH_LONG).show();

        }else if (resultCode == RESULT_CANCELED) {

            Toast.makeText(this, "Video recording cancel.", Toast
                    .LENGTH_LONG).show();
        } else {

            Toast.makeText(this, "Failed video Capture",Toast
                    .LENGTH_LONG).show();
        }
    }
}
