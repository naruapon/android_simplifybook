package com.example.supot.listviewimg;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.app.AlertDialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListViewAdapter adapter;
    String str;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final  String[] lstitle = new String[] { " Galaxy Note 8.0"," Samsung Galaxy S4",
                " Galaxy Note II"," Samsung Galaxy Tab",
                " Android Tablet"," Android SmartPhone",
                " Samsung Galaxy SIII"," iPad mini"," iPhone5"," Samsung Galaxy Note 10.1"};
        final  String[] subtitle = new String[] { getResources().getString(R.string.note),getResources().getString(R.string.galaxy_s_four),
                getResources().getString(R.string.galaxy_note_two),getResources().getString(R.string.galaxy_tab),
                getResources().getString(R.string.galaxy_tablet),getResources().getString(R.string.galaxy_smartpone),
                getResources().getString(R.string.galaxy_s_three),getResources().getString(R.string.ipad_mini),
                getResources().getString(R.string.ipone_5s),getResources().getString(R.string.note_ten_dot_one)};

        final int[]  image = new int[] { R.drawable.note_eigth, R.drawable.galaxys_four,
                R.drawable.note_two, R.drawable.galaxytab,
                R.drawable.tablet,R.drawable.android,R.drawable.galaxy_s_three,R.drawable.ipad_mini
                ,R.drawable.ipone_five,R.drawable.note_ten
        };
        // Locate the ListView in listview_main.xml
        final ListView lvw = (ListView) findViewById(R.id.listView);
        // Pass results to ListViewAdapter Class

        View headerView = getLayoutInflater().inflate(R.layout.listview_header, null);
        lvw.addHeaderView(headerView);


                adapter = new ListViewAdapter(this,lstitle,subtitle, image);
        // Binds the Adapter to the ListView
        lvw.setAdapter(adapter);
        lvw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                // Setting Dialog Title
                alertDialog.setTitle(lstitle[position-1]);

                // Setting Dialog Message
                alertDialog.setMessage(subtitle[position-1]);

                // Setting Icon to Dialog
                alertDialog.setIcon(image[position-1]);

                // Setting OK Button
                alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Write your code here to execute after dialog closed
                        Toast.makeText(getApplicationContext(), "You clicked on OK", Toast.LENGTH_SHORT).show();
                    }
                });
                // Showing Alert Message
                alertDialog.show();
            }
        });
    }
}
