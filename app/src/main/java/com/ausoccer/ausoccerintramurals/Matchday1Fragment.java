package com.ausoccer.ausoccerintramurals;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

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
public class Matchday1Fragment extends Fragment {

    ListView listView;
    MatchesModel matchesModel;
    MatchesAdapter matchesAdapter;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference matchday1 = database.getReference("Matches").child("Matchday1");

    EditText editHomeTeamName, editAwayTeamName, editHomeTeamLogoUrl, editAwayTeamLogoUrl, editMatchDate, editMatchTime, editGroupName;




    ArrayList<MatchesModel> matchesModelArrayList = new ArrayList<>();


    public Matchday1Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =inflater.inflate(R.layout.fragment_matchday1, container, false);

        listView = v.findViewById(R.id.matchday_1_list);



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
                    displayEditDialog(matchesModel.getHomeTeamName(), matchesModel.getAwayTeamName(), matchesModel.getHomeTeamLogoUrl(), matchesModel.getAwayTeamLogoUrl(),
                            matchesModel.getMatchDateAndResult(), matchesModel.getMatchTimeAndStatus(), matchesModel.getGroupName(), matchesModel.getUid());
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
                    Toast.makeText(getContext(), "Not signed in. A non signed in activity should start", Toast.LENGTH_SHORT).show();

                }

            }
        });

        matchday1.orderByChild("groupName").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                matchesModelArrayList.clear();

                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    MatchesModel matchesModel = ds.getValue(MatchesModel.class);
                    //matchesModel.setOrderMethod(matchesModel.getMatchDateAndResult() + " " + matchesModel.getMatchTimeAndStatus());
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

    private void displayEditDialog(String homeTeamName, String awayTeamName, String homeTeamLogoUrl, String awayTeamLogoUrl, String matchDateAndResult, String matchTimeAndStatus,String groupName, final String uid) {
        final Dialog d = new Dialog(getContext());
        d.setContentView(R.layout.edit_match_dialog);
        d.show();

        editHomeTeamName = d.findViewById(R.id.home_team_name_edit);
        editAwayTeamName = d.findViewById(R.id.away_team_name_edit);
        editHomeTeamLogoUrl = d.findViewById(R.id.home_team_logo_url_edit);
        editAwayTeamLogoUrl = d.findViewById(R.id.away_team_logo_url_edit);
        editMatchDate = d.findViewById(R.id.match_date_edit);
        editMatchTime = d.findViewById(R.id.match_time_edit);
        editGroupName = d.findViewById(R.id.edit_group_name);

        editHomeTeamName.setText(homeTeamName);
        editAwayTeamName.setText(awayTeamName);
        editHomeTeamLogoUrl.setText(homeTeamLogoUrl);
        editAwayTeamLogoUrl.setText(awayTeamLogoUrl);
        editMatchDate.setText(matchDateAndResult);
        editMatchTime.setText(matchTimeAndStatus);
        editGroupName.setText(groupName);

        Button editSaveButton = d.findViewById(R.id.submit_edit_button);
        Button deleteButton = d.findViewById(R.id.delete_button);

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteMatch(uid);
                d.dismiss();
            }
        });

        editSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateMatch(uid);
                d.dismiss();
            }
        });

    }

    private void updateMatch(String uid) {
        final String newHomeTeamName = editHomeTeamName.getText().toString().trim();
        final String newAwayTeamName = editAwayTeamName.getText().toString().trim();
        final String newHomeTeamLogoUrl = editHomeTeamLogoUrl.getText().toString().trim();
        final String newAwayTeamLogoUrl = editAwayTeamLogoUrl.getText().toString().trim();
        final String newMatchDate = editMatchDate.getText().toString().trim();
        final String newMatchTime = editMatchTime.getText().toString().trim();
        final String newGroupName = editGroupName.getText().toString().trim();

        matchesModel.setHomeTeamName(newHomeTeamName);
        matchesModel.setAwayTeamName(newAwayTeamName);
        matchesModel.setHomeTeamLogoUrl(newHomeTeamLogoUrl);
        matchesModel.setAwayTeamLogoUrl(newAwayTeamLogoUrl);
        matchesModel.setMatchDateAndResult(newMatchDate);
        matchesModel.setMatchTimeAndStatus(newMatchTime);
        matchesModel.setOrderMethod(newMatchDate + " " + newMatchTime);
        matchesModel.setUid(uid);
        matchesModel.setGroupName(newGroupName);

        matchday1.child(uid).setValue(matchesModel);

    }

    private void deleteMatch(String uid) {
        matchday1.child(uid).removeValue();
    }


}
