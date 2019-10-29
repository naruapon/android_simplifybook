package com.example.supot.gridvwimg;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    GridAdapter adapter;
    int[] image = {
            R.drawable.note_eigth, R.drawable.galaxys_four,
            R.drawable.note_two, R.drawable.galaxytab, R.drawable.tablet,
            R.drawable.android, R.drawable.galaxy_s_three,
            R.drawable.ipad_mini, R.drawable.ipone_five,
            R.drawable.note_ten
    };

    String[] lstitle = new String[] {
            "Note 8.0","Galaxy S4","Note II","Galaxy Tab",
            "Tablet","SmartPhone", "Galaxy SIII","iPad mini"
            ,"iPhone5","Note 10.1" };

    String str;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final  String[] subtitle = new String[] { getResources().getString(R.string.note),getResources().getString(R.string.galaxy_s_four),
                getResources().getString(R.string.galaxy_note_two),getResources().getString(R.string.galaxy_tab),
                getResources().getString(R.string.galaxy_tablet),getResources().getString(R.string.galaxy_smartpone),
                getResources().getString(R.string.galaxy_s_three),getResources().getString(R.string.ipad_mini),
                getResources().getString(R.string.ipone_5s),getResources().getString(R.string.note_ten_dot_one)};

        GridView gridView = (GridView) findViewById(R.id.gridView);
        


        adapter = new GridAdapter(this,lstitle,image);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> parent,View v,
                                    int position, long id){

                int itemPosition  = position;

                //เลือกใน GridView เพื่อเลือกข้อความที่อยู่
                AlertDialog alertDialog = new AlertDialog.Builder
                        (MainActivity.this).create();

                alertDialog.setTitle(lstitle[position]);
                alertDialog.setMessage(subtitle[position]);
                alertDialog.setIcon(image[position]);


                alertDialog.setButton("OK", new DialogInterface.	OnClickListener(){
                    public void onClick(DialogInterface dialog, int which) {

                        Toast.makeText(getApplicationContext(), "You clicked on OK",
                                Toast.LENGTH_SHORT).show();
                    }
                });
                alertDialog.show();
            }
        });

    }
}


