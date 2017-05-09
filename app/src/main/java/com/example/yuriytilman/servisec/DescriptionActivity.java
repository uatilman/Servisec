package com.example.yuriytilman.servisec;

import android.app.Service;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.lesson6.R;

public class DescriptionActivity extends AppCompatActivity {
    public static final String EXTRA_NAIL_NUM = "nailNam";
    public static final String EXTRA_SERVICES = "cervices";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        // Получить вид услуги ногтевого сервиса
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            DescriptionFragment descriptionFragment = (DescriptionFragment) getSupportFragmentManager().findFragmentById(R.id.detailsFragment);
            int nailNumber = bundle.getInt(EXTRA_NAIL_NUM, 0);
            Services.Services_TYPE type = (Services.Services_TYPE) bundle.get(Services.TYPE);
            Services services = Services.services(getResources(), type)[nailNumber];
            descriptionFragment.setServices(services);
        }
    }
}
