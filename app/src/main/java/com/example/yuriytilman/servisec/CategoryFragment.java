package com.example.yuriytilman.servisec;


import android.app.ListFragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragment extends ListFragment {

    private Services.Services_TYPE type;
    private ServiceListener listner;

    public interface ServiceListener {
        void onItemClicked(int id);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //ListView listView = getListView();
        Intent intent = getActivity().getIntent();
        type= (Services.Services_TYPE)intent.getExtras().get(Services.TYPE);//!!!!
        MyAdapter listAdapter = new MyAdapter(
                getActivity(),
                getStringArray(Services.services(getResources(),  type)),
                getIntegerArray(Services.services(getResources(), type)));
        //ArrayAdapter<Services> listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Services.nails(getResources()));
        //listView.
                setListAdapter(listAdapter);
        return super.onCreateView(inflater, container, savedInstanceState);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listner = (ServiceListener) context;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        if (listner != null) {
            listner.onItemClicked(position);
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
