package com.example.supot.checknet;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Boolean InternetPresent = false;
    ConnectNet cn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnCheck = (Button) findViewById(R.id.checknet);
        cn = new ConnectNet(getApplicationContext());

        btnCheck .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InternetPresent = cn.checkInternetConnect();
                // check for Internet status
                if (InternetPresent) {
                    showDialog(MainActivity.this, "Connect success", "Internet Connection Present", true);
                } else {
                    showDialog(MainActivity.this, "No Connection", "Internet Connection Not Present.", false);
                }
            }
        });
    }
    public void showDialog(Context context, String header, String msg, Boolean status) {

        AlertDialog alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle(header);

        alertDialog.setMessage(msg);

        // Setting alert dialog icon
        if(status){
            alertDialog.setIcon(R.drawable.active);
        }else{
            alertDialog.setIcon(R.drawable.fail);
        }

        // Setting OK Button
        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        // Showing Alert Message
        alertDialog.show();
    }

}
