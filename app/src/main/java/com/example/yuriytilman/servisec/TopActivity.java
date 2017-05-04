package com.example.yuriytilman.servisec;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;import com.example.lesson6.R;

public class TopActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout hearLay;
    private LinearLayout nailLay;
    private LinearLayout addressLay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top);
        hearLay = (LinearLayout) findViewById(R.id.lay_hear);
        nailLay = (LinearLayout) findViewById(R.id.lay_nail);
        addressLay = (LinearLayout) findViewById(R.id.lay_address);

        hearLay.setOnClickListener(this);
        nailLay.setOnClickListener(this);
        addressLay.setOnClickListener(this);


       /* DescriptionFragment detailsFragment = new DescriptionFragment();
        //detailsFragment.setWorkoutID(id);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.detailsFragment, detailsFragment);
        fragmentTransaction.commit();*/

    }


    @Override
    public void onClick(View view) {
        if (view.equals(nailLay)) {
            Intent intent = new Intent(this, CategoryActivity.class);
            intent.putExtra(Services.TYPE, Services.Services_TYPE.NAIL);
            startActivity(intent);
        } else if (view.equals(hearLay)) {
            Intent intent = new Intent(this,  CategoryActivity.class);
            intent.putExtra(Services.TYPE, Services.Services_TYPE.HAIR);
            startActivity(intent);
        } else if (view.equals(addressLay)) {




            Intent intent = new Intent(this, AddressActivity.class);
            startActivity(intent);
        }
    }

}
