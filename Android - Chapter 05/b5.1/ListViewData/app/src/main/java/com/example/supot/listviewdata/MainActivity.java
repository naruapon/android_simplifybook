package com.example.supot.listviewdata;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView lvw;
    String val;
    String[] lstitle;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvw = (ListView)findViewById(R.id.listView);

               lstitle = new String[]
                { "Samsung Galaxy Note 8.0","Samsung Galaxy S4",
                        "Galaxy Note II","Samsung Galaxy Tab", "Android Tablet","Samsung Galaxy SmartPhone",
                        "Samsung Galaxy SIII","iPad mini","iPhone5S","Note 10.1"
                };
        adapter = new ArrayAdapter<String> (this, android.R.layout.simple_list_item_2, android.R.id.text1, lstitle);
        lvw.setAdapter(adapter);
        lvw.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                val =(String) parent.getItemAtPosition(position);

                Toast.makeText(getApplicationContext(), "Item value is : "+val
                        , Toast.LENGTH_LONG) .show();
            }
        });

    }
}
