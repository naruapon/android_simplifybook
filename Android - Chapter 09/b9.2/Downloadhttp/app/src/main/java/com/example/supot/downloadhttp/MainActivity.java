package com.example.supot.downloadhttp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    Button btnDownLoad;
    private EditText inputurl;
    String strurl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        inputurl=(EditText) findViewById(R.id.editText);
        btnDownLoad = (Button) findViewById(R.id.btnLoad);
        btnDownLoad.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
//            	loadfile =new  Downloadurl();
//            	 loadfile.DownloadFile("http://marketing.reviva.co.th/images/263_Photo.jpg","pic.jpg");
                //loadfile.DownloadFile("http://www.arenathailand.com/marketing/images/Mutipoint.pdf","doc.pdf");
                InputStream in = null;
                Bitmap bmp = null;
                ImageView iv = (ImageView) findViewById(R.id.imageView);
                strurl = inputurl.getText().toString();
                int responseCode = -1;
                try {
                    URL url = new URL(strurl);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    con.setDoInput(true);
                    con.connect();
                    responseCode = con.getResponseCode();
                    if (responseCode == HttpURLConnection.HTTP_OK) {
                        //download
                        in = con.getInputStream();
                        bmp = BitmapFactory.decodeStream(in);
                        in.close();
                        iv.setImageBitmap(bmp);
                    }

                } catch(Exception e){
                    Toast.makeText(MainActivity.this, "Download image error"+e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
