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
public class Matchday5Fragment extends Fragment {

    ListView listView;
    MatchesModel matchesModel;
    MatchesAdapter matchesAdapter;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference matchday5 = database.getReference("Matches").child("Matchday5");




    ArrayList<MatchesModel> matchesModelArrayList = new ArrayList<>();


    public Matchday5Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =inflater.inflate(R.layout.fragment_matchday5, container, false);

        listView = v.findViewById(R.id.matchday_5_list);



        matchesModel = new MatchesModel();
        matchesAdapter = new MatchesAdapter(getActivity(), matchesModelArrayList);
        listView.setAdapter(matchesAdapter);

        matchday5.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                matchesModelArrayList.clear();

                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    MatchesModel matchesModel = ds.getValue(MatchesModel.class);
                    matchesModelArrayList.add(matchesModel);
                }

                listView.setAdapter(matchesAdapter);
                matchesAdapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        return v;
    }

}
