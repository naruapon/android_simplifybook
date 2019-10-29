package com.example.supot.samplefragment;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity  extends FragmentActivity implements ListFragment.onMobileSelectedListener  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (findViewById(R.id.displayList) != null) {

            if(savedInstanceState != null) {
                return;
            }

            ListFragment listFragment = new ListFragment();
            listFragment.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction().add(R.id.displayList, listFragment).commit();
        }
        if(findViewById(R.id.displayDetail) != null){

            getFragmentManager().popBackStack();
            DetailFragment detailFragment = new DetailFragment();

            detailFragment.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction().add(R.id.displayDetail, detailFragment).commit();


        }
    }

    @Override
    public void onMobileSelected(String Model, int position) {
        Log.v("AndroidFragmentActivity", Model);

        DetailFragment detailFragment = (DetailFragment)
                getSupportFragmentManager().findFragmentById(R.id.displayDetail);

        if (detailFragment != null) {
            detailFragment.updateMobileContent(Model, position);
        } else {
            DetailFragment newFragment = new DetailFragment();
            // Bundle args = new Bundle();

            newFragment.setMobileContent(Model, position);

            // newFragment.setArguments(args);

            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

            // Replace whatever is in the fragment_container view with this fragment,

            // and add the transaction to the back stack so the user can navigate back

            ft.replace(R.id.displayList, newFragment);

            ft.addToBackStack(null);

            ft.commit();


        }
    }
}
