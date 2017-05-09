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
            newIntent.putExtra(DescriptionActivity.EXTRA_SERVICES, (Serializable) services);
            startActivity(newIntent);
        }


    }
    // /*   @Override
//    public void onListItemClick(ListView listView, View itemView, int position, long id) {
//        Log.d("CategoryActivity", "listView " + listView);
//        Log.d("CategoryActivity", "itemView " + itemView);
//        Log.d("CategoryActivity", "position " + position);
//        Log.d("CategoryActivity", "id " + id);
//        Intent intent = new Intent(CategoryActivity.this, DescriptionActivity.class);
//        intent.putExtra(DescriptionActivity.EXTRA_NAIL_NUM, (int) position);
//        intent.putExtra(Services.TYPE, type);
//        startActivity(intent);
//    }*/
//        /*ListView listNails = getListView();
//        Intent intent = getIntent();
//        type= (Services.Services_TYPE)intent.getExtras().get(Services.TYPE);//!!!!
//        MyAdapter listAdapter = new MyAdapter(
//                this,
//                getStringArray(Services.services(getResources(),  type)),
//                getIntegerArray(Services.services(getResources(), type)));
//        //ArrayAdapter<Services> listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Services.nails(getResources()));
//        listNails.setAdapter(listAdapter);*/
}


