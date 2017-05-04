package com.example.yuriytilman.servisec;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;import com.example.lesson6.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class DescriptionFragment extends Fragment {
    private Services servic;

    public void setServices(Services servic) {
        this.servic = servic;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_description, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        if (view != null) {
            TextView title = (TextView) view.findViewById(R.id.service_title);
            TextView description = (TextView) view.findViewById(R.id.nail_description);
            ImageView imageViews = (ImageView) view.findViewById(R.id.nail_photo);

            if (servic != null){
                title.setText(servic.getName());
                description.setText(servic.getDescription());
                imageViews.setImageResource(servic.getImageResourceId());
            }

        }
    }
}
