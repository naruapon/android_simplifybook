package com.example.supot.downloadimg;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class MainActivity extends AppCompatActivity {
    public static final int SHOW_DIALOG_DOWNLOAD = 0;
    public static final int RequestPermissionCode = 1;
    private EditText inputurl;
    private ProgressDialog showProgress;
    private ImageView downloadedImg;
    String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputurl=(EditText)findViewById(R.id.editText);
        downloadedImg = (ImageView) findViewById(R.id.imageView);

        Button btnDownload = (Button) findViewById(R.id.downloadbtn);
        btnDownload.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                DownloadImage();

            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case RequestPermissionCode:
                if (grantResults.length> 0) {
                    boolean StoragePermission = grantResults[0] ==
                            PackageManager.PERMISSION_GRANTED;

                    if (StoragePermission ) {
                        Toast.makeText(MainActivity.this, "Permission Granted",
                                Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(MainActivity.this,"Permission Denied",Toast.LENGTH_LONG).show();
                    }
                }
                break;
        }
    }

    private void DownloadImage() {
        //	 inputurl="http://marketing.reviva.co.th/images/263_Photo.jpg";
        url = inputurl.getText().toString();
        new DownloadImgAsync().execute(url);
        new DownloadImageTask(downloadedImg).execute(url);
    }
    @Override
    protected Dialog onCreateDialog(int i) {
        switch (i) {
            case SHOW_DIALOG_DOWNLOAD:
                showProgress = new ProgressDialog(this);
                showProgress.setMessage("Downloading Please wait... ");
                showProgress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                showProgress.setCancelable(false);
                showProgress.show();
                return showProgress;
            default:
                return null;
        }
    }
    class DownloadImgAsync extends AsyncTask<String, String, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            showDialog(SHOW_DIALOG_DOWNLOAD);
        }

        @Override
        protected String doInBackground(String... aurl) {
            int count;
            if(checkPermission()){

                try {
                    URL url = new URL(aurl[0]);
                    URLConnection conexion = url.openConnection();
                    conexion.connect();

                    int lenghtOfFile = conexion.getContentLength();
                    Log.d("ANDRO_ASYNC", "Lenght of file: " + lenghtOfFile);

                    InputStream input = new BufferedInputStream(url.openStream());
                    OutputStream output = new FileOutputStream("/sdcard/263_Photo.jpg");
                    byte data[] = new byte[1024];
                    long total = 0;

                    while ((count = input.read(data)) != -1) {
                        total += count;
                        publishProgress(""+(int)((total*100)/lenghtOfFile));
                        output.write(data, 0, count);
                    }

                    output.flush();
                    output.close();
                    input.close();

                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Download image error"+e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            } else {
                // requestPermission();
                ActivityCompat.requestPermissions(MainActivity.this, new
                        String[]{WRITE_EXTERNAL_STORAGE}, RequestPermissionCode);
            }
            return null;
        }

        public boolean checkPermission() {
            int result = ContextCompat.checkSelfPermission(getApplicationContext(),
                    WRITE_EXTERNAL_STORAGE);
            return result == PackageManager.PERMISSION_GRANTED;
        }
        protected void onProgressUpdate(String... progress) {
            Log.d("ANDRO_ASYNC",progress[0]);
            showProgress.setProgress(Integer.parseInt(progress[0]));
        }

        @Override
        protected void onPostExecute(String unused) {
            dismissDialog(SHOW_DIALOG_DOWNLOAD);
        }
    }

    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap imgIcon = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                imgIcon = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return imgIcon;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }

    }
}
