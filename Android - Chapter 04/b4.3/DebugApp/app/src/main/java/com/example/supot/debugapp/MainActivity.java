package com.example.supot.debugapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    int tab[] = {1,2,3,4,0,0, 5,6,7,8};
    int num[] = {9,12,6,4,8,3,5,6,7,8};
    double val;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for(int i=0; i<10; i++){
            try {
                val=num[i]/tab[i];
                Log.d("Debug step", num[i]+" divide "+tab[i]+" is  = " + val);
            } catch (Exception e) {
                Log.e(num[i] + " divide " + tab[i] + " error app ", e.getMessage());
            }
        }
    }
}
