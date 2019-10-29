package com.example.supot.intentapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
public class OtherActivity extends AppCompatActivity {
    private String infoText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
        Intent iten = getIntent();
        infoText = iten.getStringExtra("Info");
        TextView  tw =(TextView)findViewById(R.id.textView2);
        tw.setText("Hello : " + infoText);
    }
    public void PrePage(View v) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
