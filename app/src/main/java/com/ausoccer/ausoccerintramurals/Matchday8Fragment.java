package com.ausoccer.ausoccerintramurals;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.ausoccer.ausoccerintramurals.R;
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
public class Matchday8Fragment extends Fragment {

    ListView listView;
    MatchesModel matchesModel;
    MatchesAdapter matchesAdapter;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference matchday8 = database.getReference("Matches").child("Matchday8");

    String matchday = "Matchday8";





    ArrayList<MatchesModel> matchesModelArrayList = new ArrayList<>();


    public Matchday8Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_matchday8, container, false);

        listView = v.findViewById(R.id.matchday_8_list);



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

                    String id = matchesModel.getMatchUid();

                    intent.putExtra("id", id);
                    intent.putExtra("matchday", matchday);

                    startActivity(intent);


                    //displayEditDialog(matchesModel.getHomeTeamName(), matchesModel.getAwayTeamName(), matchesModel.getHomeTeamLogoUrl(), matchesModel.getAwayTeamLogoUrl(),
                    //matchesModel.getMatchDate(), matchesModel.getMatchTime(), matchesModel.getMatchNumber(), matchesModel.getUid());
                } else {
                    matchesModel = new MatchesModel();
                    matchesModel = matchesModelArrayList.get(i);

                    String id = matchesModel.getMatchUid();

                    Intent intent = new Intent(getActivity(), MatchDataActivity.class);

                    intent.putExtra("matchday", matchday);
                    intent.putExtra("id", id);

                    startActivity(intent);

                }

            }
        });

        matchday8.orderByChild("matchNumber").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //matchesModelArrayList.clear();

                if (listView.getAdapter() == null) {
                    MatchesAdapter adapter2 = new MatchesAdapter(getActivity(), matchesModelArrayList);
                    listView.setAdapter(adapter2);
                } else {
                    ((MatchesAdapter)listView.getAdapter()).refill(matchesModelArrayList);
                }

                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    MatchesModel matchesModel = ds.getValue(MatchesModel.class);
                    matchesModelArrayList.add(matchesModel);
                }

                // listView.setAdapter(matchesAdapter);
                //matchesAdapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        return v;
    }

}
