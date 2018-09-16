package com.ausoccer.ausoccerintramurals;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Matchday3Fragment extends Fragment {

    ListView listView;
    MatchesModel matchesModel;
    MatchesAdapter matchesAdapter;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference matchday3 = database.getReference("Matches").child("Matchday3");
    String matchday = "Matchday3";


    ArrayList<MatchesModel> matchesModelArrayList = new ArrayList<>();



    public Matchday3Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_matchday3, container, false);

        listView = v.findViewById(R.id.matchday_3_list);

        matchesModel = new MatchesModel();
        matchesAdapter = new MatchesAdapter(getActivity(), matchesModelArrayList);
        listView.setAdapter(matchesAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                if (user != null) {
                    matchesModel = new MatchesModel();
                    matchesModel = matchesModelArrayList.get(i);

                    Intent intent = new Intent(getActivity(), MatchDataActivityAdmin.class);

                    String homeTeamName = matchesModel.getHomeTeamName();
                    String homeTeamLogoUrl = matchesModel.getHomeTeamLogoUrl();
                    String awayTeamName = matchesModel.getAwayTeamName();
                    String awayTeamLogoUrl = matchesModel.getAwayTeamLogoUrl();
                    String matchDateAndResult = matchesModel.getMatchDateAndResult();
                    String matchTimeAndStatus = matchesModel.getMatchTimeAndStatus();
                    String groupName = matchesModel.getGroupName();
                    String id = matchesModel.getUid();

                    intent.putExtra("homeTeamName", homeTeamName);
                    intent.putExtra("homeTeamLogo", homeTeamLogoUrl);
                    intent.putExtra("awayTeamName", awayTeamName);
                    intent.putExtra("awayTeamLogo", awayTeamLogoUrl);
                    intent.putExtra("matchDateAndResult", matchDateAndResult);
                    intent.putExtra("matchTimeAndStatus", matchTimeAndStatus);
                    intent.putExtra("groupName", groupName);
                    intent.putExtra("id", id);
                    intent.putExtra("matchday", matchday);


                    startActivity(intent);


                    //displayEditDialog(matchesModel.getHomeTeamName(), matchesModel.getAwayTeamName(), matchesModel.getHomeTeamLogoUrl(), matchesModel.getAwayTeamLogoUrl(),
                    //matchesModel.getMatchDateAndResult(), matchesModel.getMatchTimeAndStatus(), matchesModel.getGroupName(), matchesModel.getUid());
                } else {
                    matchesModel = new MatchesModel();
                    matchesModel = matchesModelArrayList.get(i);

                    String homeTeamName = matchesModel.getHomeTeamName();
                    String homeTeamLogoUrl = matchesModel.getHomeTeamLogoUrl();
                    String awayTeamName = matchesModel.getAwayTeamName();
                    String awayTeamLogoUrl = matchesModel.getAwayTeamLogoUrl();
                    String matchDateAndResult = matchesModel.getMatchDateAndResult();
                    String matchTimeAndStatus = matchesModel.getMatchTimeAndStatus();
                    String groupName = matchesModel.getGroupName();
                    String id = matchesModel.getUid();

                    Intent intent = new Intent(getActivity(), MatchDataActivity.class);

                    intent.putExtra("homeTeamName", homeTeamName);
                    intent.putExtra("homeTeamLogo", homeTeamLogoUrl);
                    intent.putExtra("awayTeamName", awayTeamName);
                    intent.putExtra("awayTeamLogo", awayTeamLogoUrl);
                    intent.putExtra("matchDateAndResult", matchDateAndResult);
                    intent.putExtra("matchTimeAndStatus", matchTimeAndStatus);
                    intent.putExtra("groupName", groupName);
                    intent.putExtra("id", id);




                    startActivity(intent);

                }

            }
        });

        matchday3.addValueEventListener(new ValueEventListener() {
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
