package com.ausoccer.ausoccerintramurals;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;


public class MatchDataActivity extends AppCompatActivity {

    TabLayout matchDataTabLayout;
    ViewPager viewPager;
    MatchDetailsPagerAdapter pagerAdapter;

    TextView homeTeamName, awayTeamName, matchDateAndResult, matchTimeAndStatus, groupName;
    ImageView homeTeamLogo, awayTeamLogo;

    int currentPage = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_data);

        homeTeamName = findViewById(R.id.home_team_name);
        awayTeamName = findViewById(R.id.away_team_name);
        homeTeamLogo = findViewById(R.id.home_team_logo);
        awayTeamLogo = findViewById(R.id.away_team_logo);
        matchDateAndResult = findViewById(R.id.model_match_date);
        matchTimeAndStatus = findViewById(R.id.model_match_time);
        groupName = findViewById(R.id.model_match_number);

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

    }

    @Override
    protected void onStart() {
        super.onStart();
        homeTeamName.setText(getIntent().getStringExtra("homeTeamName"));
        awayTeamName.setText(getIntent().getStringExtra("awayTeamName"));
        matchDateAndResult.setText(getIntent().getStringExtra("matchDate"));
        matchTimeAndStatus.setText(getIntent().getStringExtra("matchTime"));
        groupName.setText(getIntent().getStringExtra("matchNumber"));

        //Picasso.get().load(getIntent().getStringExtra("homeTeamLogo")).error(R.drawable.empty_team_logo).into(homeTeamLogo);
        //Picasso.get().load(getIntent().getStringExtra("awayTeamLogo")).error(R.drawable.empty_team_logo).into(awayTeamLogo);
        Glide.with(this).load(getIntent().getStringExtra("homeTeamLogo")).transition(withCrossFade()).into(homeTeamLogo);
        Glide.with(this).load(getIntent().getStringExtra("awayTeamLogo")).transition(withCrossFade()).into(awayTeamLogo);



    }
}
