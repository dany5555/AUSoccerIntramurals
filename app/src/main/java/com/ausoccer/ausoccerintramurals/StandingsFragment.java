package com.ausoccer.ausoccerintramurals;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class StandingsFragment extends Fragment {

    ListView standingsList;
    StandingsModel standingsModel;
    StandingsAdapter standingsAdapter;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference standings = database.getReference("Standings");

    ArrayList<StandingsModel> standingsModelArrayList = new ArrayList<>();


    public StandingsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_standings, container, false);

        standingsList = v.findViewById(R.id.standings_list);

        standingsModel = new StandingsModel();
        standingsAdapter = new StandingsAdapter(getActivity(), standingsModelArrayList);
        standingsList.setAdapter(standingsAdapter);

        standings.orderByChild("points").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                standingsModelArrayList.clear();

                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    StandingsModel standingsModel = ds.getValue(StandingsModel.class);
                    standingsModelArrayList.add(standingsModel);
                }

                standingsList.setAdapter(standingsAdapter);
                standingsAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        return v;
    }

}
