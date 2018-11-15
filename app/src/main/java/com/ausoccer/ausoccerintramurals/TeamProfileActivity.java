package com.ausoccer.ausoccerintramurals;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class TeamProfileActivity extends AppCompatActivity {

    TabLayout teamDataTabLayout;
    ViewPager viewPager;
    FirebaseDatabase database;
    DatabaseReference currentTeamRef;
    TeamDataPagerAdapter pagerAdapter;
    String teamUid = "";

    TextView teamName;
    ImageView teamLogo;

    int currentPage = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_profile);

        teamUid = getIntent().getStringExtra("homeTeamUid");

        teamName = findViewById(R.id.team_name);
        teamLogo = findViewById(R.id.team_logo);
        teamDataTabLayout = findViewById(R.id.team_data_layout);
        teamDataTabLayout.addTab(teamDataTabLayout.newTab().setText("SQUAD"));
        teamDataTabLayout.addTab(teamDataTabLayout.newTab().setText("STANDINGS"));

        teamDataTabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        teamDataTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

        viewPager = findViewById(R.id.viewPager);
        pagerAdapter = new TeamDataPagerAdapter(getSupportFragmentManager(), teamDataTabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(teamDataTabLayout));
        teamDataTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
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

        database = FirebaseDatabase.getInstance();
        currentTeamRef = database.getReference("Teams").child(teamUid);

        currentTeamRef.child("teamName").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                teamName.setText(dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        currentTeamRef.child("teamLogoUrl").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Glide.with(getApplicationContext()).load(dataSnapshot.getValue().toString()).into(teamLogo);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }

    public String getTeamUid() {
        return teamUid;

    }
}
