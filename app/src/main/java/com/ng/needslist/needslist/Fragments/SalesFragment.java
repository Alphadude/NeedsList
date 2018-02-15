package com.ng.needslist.needslist.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ng.needslist.needslist.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SalesFragment extends Fragment {
    private CardView sales;


    public SalesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_sales, container, false);
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_tender_page, container, false);
        sales = (CardView)rootView.findViewById(R.id.card_view);
        return rootView;
    }

}
