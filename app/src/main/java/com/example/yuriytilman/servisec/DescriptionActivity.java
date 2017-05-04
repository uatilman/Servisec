package com.example.yuriytilman.servisec;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.example.lesson6.R;

public class DescriptionActivity extends AppCompatActivity {
    public static final String EXTRA_NAIL_NUM = "nailNam";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        // Получить вид услуги ногтевого сервиса
        Bundle bundle = getIntent().getExtras();




      if (bundle != null) {
          int nailNumber = bundle.getInt(EXTRA_NAIL_NUM);
          Services.Services_TYPE type = (Services.Services_TYPE) bundle.get(Services.TYPE);
          Services services = Services.services(getResources(), type)[nailNumber];
          DescriptionFragment descriptionFragment =
                  (DescriptionFragment)getSupportFragmentManager().findFragmentById(R.id.detailsFragment);
/*          descriptionFragment.setServicesNumber(nailNumber);
          descriptionFragment.setType(type);*/
          descriptionFragment.setServices(services);


      }
/*
//			Log.d("DescriptionActivity", "nailNumber " + nailNumber);
//			Log.d("DescriptionActivity", "services " + services.getName());
//			Log.d("DescriptionActivity", "nailNumber " + services.getDescription());
//			Log.d("DescriptionActivity", "nailNumber " + services.getImageResourceId());
            // Заполнить ихображение услуги ногтевого сервиса
            ImageView photo = (ImageView) findViewById(R.id.nail_photo);
            photo.setImageResource(services.getImageResourceId());
            photo.setContentDescription(services.getName());

            // Заполнение наименования услуги ногтевого сервиса
            TextView name = (TextView) findViewById(R.id.nail_name);
            name.setText(services.getName());

            // Заполнение описания услуги ногтевого сервиса
            TextView description = (TextView) findViewById(R.id.nail_description);
            description.setText(services.getDescription());
        }*/
    }

}
