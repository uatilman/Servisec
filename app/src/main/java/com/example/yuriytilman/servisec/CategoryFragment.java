package com.example.yuriytilman.servisec;


import android.app.Activity;
import android.app.ListFragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class CategoryFragment extends ListFragment {

    private Services.Services_TYPE type;
    private ServiceListener listener;

    public interface ServiceListener {
        void onItemClicked(int id);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Intent intent = getActivity().getIntent();
        type= (Services.Services_TYPE)intent.getExtras().get(Services.TYPE);
        MyAdapter myAdapter = new MyAdapter(
                getActivity(),
                getStringArray(Services.services(getResources(),  type)),
                getIntegerArray(Services.services(getResources(), type)));
        //ArrayAdapter<Services> listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Services.nails(getResources()));
        //listView.
                setListAdapter(myAdapter);
        return super.onCreateView(inflater, container, savedInstanceState);

    }

/*    @Override // работает с 23 апи (или22?)
    public void onAttach(Context context) {
        super.onAttach(context);
        listner = (ServiceListener) context;
    }*/

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        listener = (ServiceListener) activity;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        if (listener != null) {
            listener.onItemClicked(position);
        }
    }
    public String[] getStringArray(Services services[]) {
        String names[] = new String[services.length];
        for (int i = 0; i < names.length; i++) {
            names[i] = services[i].getName();
        }
        return names;
    }

    public Integer[] getIntegerArray(Services services[]) {
        Integer imageResourceId[] = new Integer[services.length];
        for (int i = 0; i < imageResourceId.length; i++) {
            imageResourceId[i] = services[i].getImageResourceId();
        }
        return imageResourceId;
    }
}
