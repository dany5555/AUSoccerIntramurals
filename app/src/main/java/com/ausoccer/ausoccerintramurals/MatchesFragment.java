package com.ausoccer.ausoccerintramurals;

import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


/**
 * A simple {@link Fragment} subclass.
 */
public class MatchesFragment extends Fragment {

    TabLayout matchesTabLayout;
    ViewPager viewPager;
    com.ausoccer.ausoccerintramurals.PagerAdapter pagerAdapter;

    EditText homeTeamNameInput, awayTeamNameInput, homeTeamLogoUrlInput, awayTeamLogoUrlInput, matchDateInput, matchTimeInput, groupNameInput;
    FloatingActionButton addMatchFabButton;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference matchday1 = database.getReference("Matches").child("Matchday1");
    DatabaseReference matchday2 = database.getReference("Matches").child("Matchday2");
    DatabaseReference matchday3 = database.getReference("Matches").child("Matchday3");
    DatabaseReference matchday4 = database.getReference("Matches").child("Matchday4");
    DatabaseReference matchday5 = database.getReference("Matches").child("Matchday5");
    DatabaseReference matchday6 = database.getReference("Matches").child("Matchday6");


    int currentPage = 0;




    public MatchesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_matches, container, false);

        addMatchFabButton = v.findViewById(R.id.add_match_fab);

        addMatchFabButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                executeAction();

            }
        });

        matchesTabLayout = v.findViewById(R.id.matches_tab_layout);
        matchesTabLayout.addTab(matchesTabLayout.newTab().setText("MATCHDAY 1"));
        matchesTabLayout.addTab(matchesTabLayout.newTab().setText("MATCHDAY 2"));
        matchesTabLayout.addTab(matchesTabLayout.newTab().setText("MATCHDAY 3"));
        matchesTabLayout.addTab(matchesTabLayout.newTab().setText("MATCHDAY 4"));
        matchesTabLayout.addTab(matchesTabLayout.newTab().setText("MATCHDAY 5"));
        matchesTabLayout.addTab(matchesTabLayout.newTab().setText("MATCHDAY 7"));
        matchesTabLayout.addTab(matchesTabLayout.newTab().setText("MATCHDAY 8"));
        matchesTabLayout.addTab(matchesTabLayout.newTab().setText("MATCHDAY 9"));
        matchesTabLayout.addTab(matchesTabLayout.newTab().setText("MATCHDAY 10"));
        matchesTabLayout.addTab(matchesTabLayout.newTab().setText("QUARTER-FINALS"));
        matchesTabLayout.addTab(matchesTabLayout.newTab().setText("SEMI-FINALS"));
        matchesTabLayout.addTab(matchesTabLayout.newTab().setText("FINAL"));




        matchesTabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        matchesTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);


        viewPager = v.findViewById(R.id.viewPager);
        pagerAdapter = new com.ausoccer.ausoccerintramurals.PagerAdapter(getChildFragmentManager(), matchesTabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(matchesTabLayout));
        matchesTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                currentPage = viewPager.getCurrentItem();
                Log.v("dsd", "Current tab: " + currentPage);

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        return v;


    }

    private void executeAction() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            //Toast.makeText(getContext(), "Logged in. Should display a dialog", Toast.LENGTH_SHORT).show();
            final Dialog d = new Dialog(getContext());
            d.setContentView(R.layout.add_match_dialog);

            homeTeamNameInput = d.findViewById(R.id.home_team_name);
            awayTeamNameInput = d.findViewById(R.id.away_team_name);
            homeTeamLogoUrlInput = d.findViewById(R.id.home_team_logo_url);
            awayTeamLogoUrlInput = d.findViewById(R.id.away_team_logo_url);
            matchDateInput = d.findViewById(R.id.match_date);
            matchTimeInput = d.findViewById(R.id.match_time);
            groupNameInput = d.findViewById(R.id.group_name);
            Button submitMatchButton = d.findViewById(R.id.submit_match_button);

            submitMatchButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String homeTeamName = homeTeamNameInput.getText().toString();
                    String awayTeamName = awayTeamNameInput.getText().toString();
                    String homeTeamLogoUrl = homeTeamLogoUrlInput.getText().toString();
                    String awayTeamLogoUrl = awayTeamLogoUrlInput.getText().toString();
                    String matchDate = matchDateInput.getText().toString();
                    String matchTime = matchTimeInput.getText().toString();
                    String groupName = groupNameInput.getText().toString();



                    if (TextUtils.isEmpty(groupName)) {
                        Toast.makeText(getContext(), "Please enter group name", Toast.LENGTH_SHORT).show();
                        return;

                    }

                    if (TextUtils.isEmpty(homeTeamName)) {
                        Toast.makeText(getContext(), "Please enter home team name", Toast.LENGTH_SHORT).show();
                        return;

                    }

                    if (TextUtils.isEmpty(awayTeamName)) {
                        Toast.makeText(getContext(), "Please enter away team name", Toast.LENGTH_SHORT).show();
                        return;

                    }

                    if (TextUtils.isEmpty(homeTeamLogoUrl)) {
                        Toast.makeText(getContext(), "Please enter an image url", Toast.LENGTH_SHORT).show();
                        return;

                    }

                    if (TextUtils.isEmpty(awayTeamLogoUrl)) {
                        Toast.makeText(getContext(), "Please enter an image url", Toast.LENGTH_SHORT).show();
                        return;

                    }

                    if (TextUtils.isEmpty(matchDate)) {
                        Toast.makeText(getContext(), "Please enter match date", Toast.LENGTH_SHORT).show();
                        return;

                    }

                    if (TextUtils.isEmpty(matchTime)) {
                        Toast.makeText(getContext(), "Please enter match time", Toast.LENGTH_SHORT).show();
                        return;

                    }

                    MatchesModel matchesModel = new MatchesModel();

                    matchesModel.setHomeTeamName(homeTeamName);
                    matchesModel.setAwayTeamName(awayTeamName);
                    matchesModel.setHomeTeamLogoUrl(homeTeamLogoUrl);
                    matchesModel.setAwayTeamLogoUrl(awayTeamLogoUrl);
                    matchesModel.setMatchDateAndResult(matchDate);
                    matchesModel.setMatchTimeAndStatus(matchTime);
                    matchesModel.setOrderMethod(matchDate + " " + matchTime);
                    matchesModel.setGroupName(groupName);


                    matchesModel.setUid(matchday1.push().getKey());

                    if (currentPage == 0) {
                        try {
                            matchday1.child(matchesModel.getUid()).setValue(matchesModel);
                        } catch (DatabaseException ex) {
                            ex.printStackTrace();
                        }
                    } else if (currentPage == 1) {
                        try {
                            matchday2.child(matchesModel.getUid()).setValue(matchesModel);
                        } catch (DatabaseException ex) {
                            ex.printStackTrace();
                        }

                    } else if (currentPage == 2) {
                        try {
                            matchday3.child(matchesModel.getUid()).setValue(matchesModel);
                        } catch (DatabaseException ex) {
                            ex.printStackTrace();
                        }

                    } else if (currentPage == 3) {
                        try {
                            matchday4.child(matchesModel.getUid()).setValue(matchesModel);
                        } catch (DatabaseException ex) {
                            ex.printStackTrace();
                        }

                    } else if (currentPage == 4) {
                        try {
                            matchday5.child(matchesModel.getUid()).setValue(matchesModel);
                        } catch (DatabaseException ex) {
                            ex.printStackTrace();
                        }

                    } else if (currentPage == 5) {
                        try {
                            matchday6.child(matchesModel.getUid()).setValue(matchesModel);
                        } catch (DatabaseException ex) {
                            ex.printStackTrace();
                        }

                    }



                    d.dismiss();
                }
            });

            d.show();


        } else {
            Toast.makeText(getContext(), "Not logged in", Toast.LENGTH_SHORT).show();


        }
    }





}
