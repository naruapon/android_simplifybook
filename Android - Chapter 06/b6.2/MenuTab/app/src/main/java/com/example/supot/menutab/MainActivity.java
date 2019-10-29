package com.example.supot.menutab;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements ActionBar.TabListener{
    private  TextView txttitle, txtsubtitle;
    private ImageView image;
    private  String [] title,subtitle;
    private int[] imageflag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txttitle = (TextView) findViewById(R.id.textView);
        txtsubtitle = (TextView) findViewById(R.id.textView2);
        image= (ImageView) findViewById(R.id.imageView);
        title = new String[] { getResources().getString(R.string.tab1),
          getResources().getString(R.string.tab2),
           getResources().getString(R.string.tab3)};
        subtitle = new String[] {
            getResources().getString(R.string.detail1),
            getResources().getString(R.string.detail2),
            getResources().getString(R.string.detail3)
    };
        imageflag = new int[] {
            R.drawable.note_two, R.drawable.galaxytab, R.drawable.tablet
    };


        ActionBar ab = getSupportActionBar();
        ab.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        // Three tab to display in actionbar
        ab.addTab(ab.newTab().setText(R.string.tab1).setTabListener(this));
        ab.addTab(ab.newTab().setText(R.string.tab2).setTabListener(this));
        ab.addTab(ab.newTab().setText(R.string.tab3).setTabListener(this));
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {

      txttitle.setText(title[tab.getPosition()]);
        txtsubtitle.setText(subtitle[tab.getPosition()]);
        image.setImageResource(imageflag[tab.getPosition()]);
          }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }
}
