package com.example.recyclopedia;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

/**
 * Created by Mariz on 2/19/2017.
 */
public class FeatureFragment extends Fragment {

    // The onCreateView method is called when Fragment should create its View object hierarchy,
    // either dynamically or via XML layout inflation.
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        return inflater.inflate(R.layout.fragment_feature, parent, false);
    }

    // This event is triggered soon after onCreateView().
    // Any view setup should occur here.  E.g., view lookups and attaching view listeners.
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // Setup any handles to view objects here
        // EditText etFoo = (EditText) view.findViewById(R.id.etFoo);

        ImageView img_logo = (ImageView) view.findViewById(R.id.imageView);
        ImageButton btn_search = (ImageButton) view.findViewById(R.id.search_button);
        ImageButton btn_encyclopedia = (ImageButton) view.findViewById(R.id.encyclopedia_button);
        ImageButton btn_game = (ImageButton) view.findViewById(R.id.game_button);
        ImageButton btn_calendar = (ImageButton) view.findViewById(R.id.calendar_button);

        img_logo.setImageResource(R.drawable.logo);


    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
