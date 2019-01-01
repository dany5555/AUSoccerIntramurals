package com.ausoccer.ausoccerintramurals;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

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

    CustomListView goalkeepersList, defendersList, midfieldersList, forwardsList;
    SquadsModel squadsModel;
    SquadAdapter defendersAdapter, goalkeepersAdapter, midfieldersAdapter, forwardsAdapter;


    FirebaseDatabase database;
    DatabaseReference goalKeepersRef, defendersRef, midfieldersRef, forwardsRef;

    ArrayList<SquadsModel> defendersArrayList = new ArrayList<>();
    ArrayList<SquadsModel> goalkeepersArrayList = new ArrayList<>();
    ArrayList<SquadsModel> midfieldersArrayList = new ArrayList<>();
    ArrayList<SquadsModel> forwardsArrayList = new ArrayList<>();

    ArrayList<SquadsModel> fullArrayList = new ArrayList<>();



    public SquadFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_squad, container, false);

        defendersList = v.findViewById(R.id.defenders_list);
        goalkeepersList = v.findViewById(R.id.goalkeepers_list);
        midfieldersList = v.findViewById(R.id.midfielders_list);
        forwardsList = v.findViewById(R.id.forwards_list);

        squadsModel = new SquadsModel();
        defendersAdapter = new SquadAdapter(getActivity(), defendersArrayList);
        goalkeepersAdapter = new SquadAdapter(getActivity(), goalkeepersArrayList);
        midfieldersAdapter = new SquadAdapter(getActivity(), midfieldersArrayList);
        forwardsAdapter = new SquadAdapter(getActivity(), forwardsArrayList);

        //LayoutInflater inflater1 = getLayoutInflater();
        //ViewGroup header = (ViewGroup)inflater1.inflate(R.layout.listview_header, goalkeepersList, false);
        //goalkeepersList.addHeaderView(header);

        goalkeepersList.setAdapter(goalkeepersAdapter);
        defendersList.setAdapter(defendersAdapter);
        midfieldersList.setAdapter(defendersAdapter);
        forwardsList.setAdapter(defendersAdapter);

        goalkeepersList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                squadsModel = new SquadsModel();
                squadsModel = goalkeepersArrayList.get(position);

                String playerUid = squadsModel.getPlayerUid();
                String teamUid = squadsModel.getTeam();

                Intent intent = new Intent(getActivity(), PlayerProfileActivity.class);

                intent.putExtra("playerUid", playerUid);
                intent.putExtra("teamUid", teamUid);
                intent.putExtra("position", "Goalkeepers");

                startActivity(intent);
            }
        });

        defendersList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                squadsModel = new SquadsModel();
                squadsModel = defendersArrayList.get(position);

                String playerUid = squadsModel.getPlayerUid();
                String teamUid = squadsModel.getTeam();

                Intent intent = new Intent(getActivity(), PlayerProfileActivity.class);

                intent.putExtra("playerUid", playerUid);
                intent.putExtra("teamUid", teamUid);
                intent.putExtra("position", "Defenders");


                startActivity(intent);

            }
        });

        midfieldersList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                squadsModel = new SquadsModel();
                squadsModel = midfieldersArrayList.get(position);

                String playerUid = squadsModel.getPlayerUid();
                String teamUid = squadsModel.getTeam();

                Intent intent = new Intent(getActivity(), PlayerProfileActivity.class);

                intent.putExtra("playerUid", playerUid);
                intent.putExtra("teamUid", teamUid);
                intent.putExtra("position", "Midfielders");


                startActivity(intent);

            }
        });

        forwardsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                squadsModel = new SquadsModel();
                squadsModel = forwardsArrayList.get(position);

                String playerUid = squadsModel.getPlayerUid();
                String teamUid = squadsModel.getTeam();

                Intent intent = new Intent(getActivity(), PlayerProfileActivity.class);

                intent.putExtra("playerUid", playerUid);
                intent.putExtra("teamUid", teamUid);
                intent.putExtra("position", "Forwards");


                startActivity(intent);

            }
        });

        TeamProfileActivity teamProfileActivity = (TeamProfileActivity) getActivity();
        String teamUid = teamProfileActivity.getTeamUid();

        database = FirebaseDatabase.getInstance();
        goalKeepersRef = database.getReference("Squads").child(teamUid).child("Goalkeepers");
        defendersRef = database.getReference("Squads").child(teamUid).child("Defenders");
        midfieldersRef = database.getReference("Squads").child(teamUid).child("Midfielders");
        forwardsRef = database.getReference("Squads").child(teamUid).child("Forwards");

        goalKeepersRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                goalkeepersArrayList.clear();

                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    SquadsModel squadsModel = ds.getValue(SquadsModel.class);
                    goalkeepersArrayList.add(squadsModel);
                }

                goalkeepersList.setAdapter(goalkeepersAdapter);
                goalkeepersAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        defendersRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                defendersArrayList.clear();

                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    SquadsModel squadsModel = ds.getValue(SquadsModel.class);
                    defendersArrayList.add(squadsModel);
                }

                defendersList.setAdapter(defendersAdapter);
                defendersAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        midfieldersRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                midfieldersArrayList.clear();

                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    SquadsModel squadsModel = ds.getValue(SquadsModel.class);
                    midfieldersArrayList.add(squadsModel);
                }

                midfieldersList.setAdapter(midfieldersAdapter);
                midfieldersAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        forwardsRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                forwardsArrayList.clear();

                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    SquadsModel squadsModel = ds.getValue(SquadsModel.class);
                    forwardsArrayList.add(squadsModel);
                }

                forwardsList.setAdapter(forwardsAdapter);
                forwardsAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



        return v;
    }



}
