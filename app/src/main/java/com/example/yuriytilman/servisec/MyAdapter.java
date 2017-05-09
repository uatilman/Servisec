package com.example.yuriytilman.servisec;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;import com.example.lesson6.R;

/**
 * Created by Yuriy Tilman on 02.05.2017.
 */

public class MyAdapter extends BaseAdapter {
    private final Activity mActivity;
    private final String[] mItemName;
    private final Integer[] mImagesId;

    public MyAdapter(Activity activity, String[] itemName, Integer[] imagesId) {
        this.mActivity = activity;
        this.mItemName = itemName;
        this.mImagesId = imagesId;
    }


    @Override
    public int getCount() {
        return mItemName.length;
    }

    @Override
    public Object getItem(int position) {
        return mItemName[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = mActivity.getLayoutInflater();
        View myView = inflater.inflate(R.layout.my_list_item, null, true);

        TextView textView = (TextView) myView.findViewById(R.id.list_description);
        ImageView imageView = (ImageView) myView.findViewById(R.id.logo);

        textView.setText(mItemName[position]);
        imageView.setImageResource(mImagesId[position]);

        return myView;
    }
}
