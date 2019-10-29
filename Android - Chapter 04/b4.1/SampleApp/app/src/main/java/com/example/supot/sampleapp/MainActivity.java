package com.example.supot.sampleapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private String strTxt;
    private TextView tw;
    private EditText Edt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void show(View v) {
        tw = (TextView)findViewById(R.id.textView);
        Edt =(EditText)findViewById(R.id.editText);
        strTxt = Edt.getText().toString();
        tw.setText("Hello: " + strTxt);
    }
}
