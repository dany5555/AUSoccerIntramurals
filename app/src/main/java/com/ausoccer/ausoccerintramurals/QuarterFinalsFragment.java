package com.ausoccer.ausoccerintramurals;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ausoccer.ausoccerintramurals.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class QuarterFinalsFragment extends Fragment {


    public QuarterFinalsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_quarter_finals, container, false);


        return v;
    }

}
