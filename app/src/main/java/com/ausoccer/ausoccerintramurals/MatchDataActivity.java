package com.ausoccer.ausoccerintramurals;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;


public class MatchDataActivity extends AppCompatActivity {

    TabLayout matchDataTabLayout;
    ViewPager viewPager;
    MatchDetailsPagerAdapter pagerAdapter;
    FirebaseDatabase database;
    DatabaseReference currentMatchRef;
    String matchId;
    String matchDay;
    String homeTeamUid, awayTeamUid;


    TextView homeTeamName, awayTeamName;
    ImageView homeTeamLogo, awayTeamLogo;

    // Not played match objects.
    RelativeLayout notPlayedMatchLayout;
    TextView notPlayedMatchNumber, notPlayedMatchDate, notPlayedMatchTime;

    // Live match objects.
    RelativeLayout liveMatchLayout;
    TextView liveMatchNumber, liveResult, liveStatus;

    int currentPage = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_data);

        homeTeamName = findViewById(R.id.home_team_name);
        awayTeamName = findViewById(R.id.away_team_name);
        homeTeamLogo = findViewById(R.id.home_team_logo);
        awayTeamLogo = findViewById(R.id.away_team_logo);

        // Not played casting
        notPlayedMatchLayout = findViewById(R.id.match_info_layout_not_played);
        notPlayedMatchNumber = findViewById(R.id.not_played_match_number);
        notPlayedMatchDate = findViewById(R.id.not_played_match_date);
        notPlayedMatchTime = findViewById(R.id.not_played_match_time);

        // Live casting
        liveMatchLayout = findViewById(R.id.match_info_layout_live);
        liveMatchNumber = findViewById(R.id.live_match_number);
        liveResult = findViewById(R.id.live_result);
        liveStatus = findViewById(R.id.live_status);

        matchDataTabLayout = findViewById(R.id.match_data_tab_layout);
        matchDataTabLayout.addTab(matchDataTabLayout.newTab().setText("LINEUPS"));
        matchDataTabLayout.addTab(matchDataTabLayout.newTab().setText("STATS"));

        matchDataTabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        matchDataTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

        viewPager = findViewById(R.id.viewPager);
        pagerAdapter = new MatchDetailsPagerAdapter(getSupportFragmentManager(), matchDataTabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(matchDataTabLayout));
        matchDataTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                currentPage = viewPager.getCurrentItem();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        matchId = getIntent().getStringExtra("id");
        matchDay = getIntent().getStringExtra("matchday");
        Log.v("matchday", matchDay);
        Log.v("matchid", matchId);

        database = FirebaseDatabase.getInstance();
        currentMatchRef = database.getReference("Matches").child(matchDay).child(matchId);

        currentMatchRef.child("matchDate").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                notPlayedMatchDate.setText(dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        currentMatchRef.child("matchTime").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                notPlayedMatchTime.setText(dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        currentMatchRef.child("liveResult").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                liveResult.setText(dataSnapshot.getValue().toString());

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        final String notPlayed = "NOT PLAYED";
        currentMatchRef.child("matchStatus").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String check = dataSnapshot.getValue().toString();
                if (check.equals(notPlayed)) {
                    notPlayedMatchLayout.setVisibility(View.VISIBLE);
                    liveMatchLayout.setVisibility(View.GONE);
                } else {
                    notPlayedMatchLayout.setVisibility(View.GONE);
                    liveMatchLayout.setVisibility(View.VISIBLE);
                }

                liveStatus.setText(dataSnapshot.getValue().toString());

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        currentMatchRef.child("matchNumber").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                notPlayedMatchNumber.setText("MATCH " + dataSnapshot.getValue().toString());
                liveMatchNumber.setText("MATCH " + dataSnapshot.getValue().toString());

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        currentMatchRef.child("homeTeamLogoUrl").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Glide.with(getApplicationContext()).load(dataSnapshot.getValue().toString()).into(homeTeamLogo);


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        currentMatchRef.child("awayTeamLogoUrl").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Glide.with(getApplicationContext()).load(dataSnapshot.getValue().toString()).into(awayTeamLogo);


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        currentMatchRef.child("homeTeamName").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                homeTeamName.setText(dataSnapshot.getValue().toString());


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        currentMatchRef.child("awayTeamName").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                awayTeamName.setText(dataSnapshot.getValue().toString());


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        currentMatchRef.child("homeTeamUid").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                homeTeamUid = dataSnapshot.getValue().toString();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        currentMatchRef.child("awayTeamUid").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                awayTeamUid = dataSnapshot.getValue().toString();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        homeTeamLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), TeamProfileActivity.class);


                intent.putExtra("teamUid", homeTeamUid);
                startActivity(intent);

            }
        });

        awayTeamLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), TeamProfileActivity.class);

                intent.putExtra("teamUid", awayTeamUid);
                startActivity(intent);
            }
        });

    }


}
