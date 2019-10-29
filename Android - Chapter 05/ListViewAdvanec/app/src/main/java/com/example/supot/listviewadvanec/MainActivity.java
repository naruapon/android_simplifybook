package com.example.supot.listviewadvanec;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.AdapterView;

import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListViewAdapter customAdapter;
   // ArrayList dataModels;
    private ArrayList<DataModel> modelArrayList;

    String str;
    int itemPosition;
    private String[] lstitle = new String[] { "Galaxy Note 8.0","Samsung Galaxy S4",
            "Galaxy Note II","Samsung Galaxy Tab",
            "Android Tablet","Android SmartPhone",
            "Samsung Galaxy SIII","iPad mini","iPhone5","Samsung Galaxy Note 10.1"};

    private String[] subtitle = new String[] { "Galaxy Note 8.0","Samsung Galaxy S4",
            "Galaxy Note II","Samsung Galaxy Tab",
            "Android Tablet","Android SmartPhone",
            "Samsung Galaxy SIII","iPad mini","iPhone5","Samsung Galaxy Note 10.1"};

    private int[] image = new int[] { R.drawable.note_eigth, R.drawable.galaxys_four,
            R.drawable.note_two, R.drawable.galaxytab,
            R.drawable.tablet,R.drawable.android,R.drawable.galaxy_s_three,R.drawable.ipad_mini
            ,R.drawable.ipone_five,R.drawable.note_ten
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       final ListView lvw = (ListView) findViewById(R.id.listView);

        modelArrayList = getModel(false);
        customAdapter = new ListViewAdapter(this,modelArrayList);
        lvw.setAdapter(customAdapter);
//        lvw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
//                 itemPosition  = position;
//                switch(itemPosition) {
//                    case 0:
//                        str=getResources().getString(R.string.note);
//                        break;
//                    case 1:
//                        str=getResources().getString(R.string.galaxy_s_four);
//                        break;
//                    case 2:
//                        str=getResources().getString(R.string.galaxy_note_two);
//                        break;
//                    case 3:
//                        str=getResources().getString(R.string.galaxy_tab);
//                        break;
//                    case 4:
//                        str=getResources().getString(R.string.galaxy_tablet);
//                        break;
//                    case 5:
//                        str=getResources().getString(R.string.galaxy_smartpone);
//                        break;
//                    case 6:
//                        str=getResources().getString(R.string.galaxy_s_three);
//                        break;
//                    case 7:
//                        str=getResources().getString(R.string.ipad_mini);
//                        break;
//                    case 8:
//                        str=getResources().getString(R.string.ipone_5s);
//                        break;
//                    case 9: str=getResources().getString(R.string.note_ten_dot_one);
//                        break;
//                }
//                AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
//                // Setting Dialog Title
//                alertDialog.setTitle(lstitle[itemPosition]);
//
//                // Setting Dialog Message
//                alertDialog.setMessage(str);
//
//                // Setting Icon to Dialog
//                alertDialog.setIcon(image[itemPosition]);
//
//                // Setting OK Button
//                alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int which) {
//                        // Write your code here to execute after dialog closed
//                        Toast.makeText(getApplicationContext(), "You clicked on OK", Toast.LENGTH_SHORT).show();
//                    }
//                });
//                // Showing Alert Message
//                alertDialog.show();
//            }
//        });
        Button selectAllButton = (Button)findViewById(R.id.button);
        selectAllButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                modelArrayList = getModel(true);
                customAdapter = new ListViewAdapter(MainActivity.this,modelArrayList);
                lvw.setAdapter(customAdapter);

            }
        });

    }

    private ArrayList<DataModel> getModel(boolean isSelect){
        ArrayList<DataModel> list = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            DataModel model = new DataModel();
            model.setSelected(isSelect);
            model.setNamel(lstitle[i]);
            model.setSubtitll(subtitle[i]);
            model.setImgl(image[i]);
            list.add(model);
        }
        return list;
    }
}
