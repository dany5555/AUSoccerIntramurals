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
public class SquadFragment extends Fragment {

    ListView squadList;
    SquadModel squadModel;
    SquadAdapter squadAdapter;


    FirebaseDatabase database;
    DatabaseReference squad;

    ArrayList<SquadModel> squadModelArrayList = new ArrayList<>();


    public SquadFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_squad, container, false);

        squadList = v.findViewById(R.id.squad_list);

        squadModel = new SquadModel();
        squadAdapter = new SquadAdapter(getActivity(), squadModelArrayList);
        squadList.setAdapter(squadAdapter);

        TeamProfileActivity teamProfileActivity = (TeamProfileActivity) getActivity();
        String teamUid = teamProfileActivity.getTeamUid();

        database = FirebaseDatabase.getInstance();
        squad = database.getReference("Squads").child(teamUid).child("Defenders");

        squad.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                squadModelArrayList.clear();

                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    SquadModel squadModel = ds.getValue(SquadModel.class);
                    squadModelArrayList.add(squadModel);
                }

                squadList.setAdapter(squadAdapter);
                squadAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



        return v;
    }

}
