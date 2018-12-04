package com.ausoccer.ausoccerintramurals;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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

    CustomListView goalkeepersList, defendersList, midfieldersList, forwardsList;
    SquadModel squadModel;
    SquadAdapter defendersAdapter, goalkeepersAdapter, midfieldersAdapter, forwardsAdapter;


    FirebaseDatabase database;
    DatabaseReference goalKeepersRef, defendersRef, midfieldersRef, forwardsRef;

    ArrayList<SquadModel> defendersArrayList = new ArrayList<>();
    ArrayList<SquadModel> goalkeepersArrayList = new ArrayList<>();
    ArrayList<SquadModel> midfieldersArrayList = new ArrayList<>();
    ArrayList<SquadModel> forwardsArrayList = new ArrayList<>();

    ArrayList<SquadModel> fullArrayList = new ArrayList<>();



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

        squadModel = new SquadModel();
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
                squadModel = new SquadModel();
                squadModel = goalkeepersArrayList.get(position);

                String playerUid = squadModel.getPlayerUid();
                String teamUid = squadModel.getTeam();

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
                squadModel = new SquadModel();
                squadModel = defendersArrayList.get(position);

                String playerUid = squadModel.getPlayerUid();
                String teamUid = squadModel.getTeam();

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
                squadModel = new SquadModel();
                squadModel = midfieldersArrayList.get(position);

                String playerUid = squadModel.getPlayerUid();
                String teamUid = squadModel.getTeam();

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
                squadModel = new SquadModel();
                squadModel = forwardsArrayList.get(position);

                String playerUid = squadModel.getPlayerUid();
                String teamUid = squadModel.getTeam();

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
                    SquadModel squadModel = ds.getValue(SquadModel.class);
                    goalkeepersArrayList.add(squadModel);
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
                    SquadModel squadModel = ds.getValue(SquadModel.class);
                    defendersArrayList.add(squadModel);
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
                    SquadModel squadModel = ds.getValue(SquadModel.class);
                    midfieldersArrayList.add(squadModel);
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
                    SquadModel squadModel = ds.getValue(SquadModel.class);
                    forwardsArrayList.add(squadModel);
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
