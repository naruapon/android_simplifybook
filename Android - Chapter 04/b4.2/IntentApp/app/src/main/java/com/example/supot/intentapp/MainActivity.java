package com.example.supot.intentapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
public class MainActivity extends AppCompatActivity {
    private String InfoText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void NextPage(View v) {
        EditText Edt =(EditText)findViewById(R.id.editText);
        InfoText = Edt.getText().toString();
        Intent itnt = new Intent(this,OtherActivity.class);
        itnt.putExtra("Info", InfoText);
        startActivity(itnt);
    }
}
