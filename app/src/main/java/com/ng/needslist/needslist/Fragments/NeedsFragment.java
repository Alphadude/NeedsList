package com.ng.needslist.needslist.Fragments;


import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ng.needslist.needslist.R;

import static com.ng.needslist.needslist.R.drawable.ic_map;

/**
 * A simple {@link Fragment} subclass.
 */
public class NeedsFragment extends Fragment {

    private ImageView dp;
    private TextView user, message;


    public NeedsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_needs, container, false);
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_tender_page, container, false);
        dp = (ImageView)rootView.findViewById(R.id.userimage);
        //dp.setImageResource();
        return rootView;
    }

}
