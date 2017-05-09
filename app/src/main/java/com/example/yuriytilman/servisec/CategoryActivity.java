package com.example.yuriytilman.servisec;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import com.example.lesson6.R;

import java.io.Serializable;


public class CategoryActivity extends AppCompatActivity implements CategoryFragment.ServiceListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        //onItemClicked(0);
    }

    @Override
    public void onItemClicked(int id) {
        View fragmentContainer = findViewById(R.id.detailsFragment);
        Intent intent = getIntent();
        Services.Services_TYPE type = (Services.Services_TYPE) intent.getExtras().get(Services.TYPE);
        DescriptionFragment descriptionFragment = new DescriptionFragment();
        Services services = Services.services(getResources(), type)[id];

        if (fragmentContainer != null) {
            descriptionFragment.setServices(services);
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.detailsFragment, descriptionFragment);
            fragmentTransaction.commit();
        } else {
            Intent newIntent = new Intent(getApplicationContext(), DescriptionActivity.class);
            newIntent.putExtra(DescriptionActivity.EXTRA_NAIL_NUM, id);
            newIntent.putExtra(Services.TYPE, type);
            startActivity(newIntent);
        }
    }
}


