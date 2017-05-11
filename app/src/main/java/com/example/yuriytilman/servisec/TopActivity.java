package com.example.yuriytilman.servisec;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import com.example.lesson6.R;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class TopActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout hearLay;
    private LinearLayout nailLay;
    private LinearLayout addressLay;

    HttpURLConnection urlConnection;


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
        Intent intent;
        if (view.equals(nailLay)) {
            intent = new Intent(this, CategoryActivity.class);
            intent.putExtra(Services.TYPE, Services.Services_TYPE.NAIL);
            startActivity(intent);
        } else if (view.equals(hearLay)) {
            intent = new Intent(this, CategoryActivity.class);
            intent.putExtra(Services.TYPE, Services.Services_TYPE.HAIR);
            startActivity(intent);
        } else {

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        URL url = new URL("http://192.168.1.40/juD/");
                        urlConnection = (HttpURLConnection) url.openConnection();
                        BufferedInputStream in = new BufferedInputStream(urlConnection.getInputStream());
                        int c;
                        in.read();
                        System.out.println((byte)in.read());
                       while ((c = in.read()) != -1) {
                            System.out.print((char) c);
                        }
//комментарий для тестирования git

                        urlConnection.disconnect();
                    } catch (IOException e) {
                    } finally {
                        urlConnection.disconnect();
                    }

                }
            }).start();


            //**intent = new Intent(this, AddressActivity.class);
            //**ткст тест intent = new Intent(this, AddressActivity.class);
        }
        //startActivity(intent);
    }
}
