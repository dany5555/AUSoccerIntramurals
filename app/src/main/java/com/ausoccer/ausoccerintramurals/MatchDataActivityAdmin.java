package com.ausoccer.ausoccerintramurals;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MatchDataActivityAdmin extends AppCompatActivity {

    TabLayout matchDataTabLayout;
    ViewPager viewPager;
    MatchDetailsAdminPagerAdapter pagerAdapter;

    TextView homeTeamName, awayTeamName, matchDateAndResult, matchTimeAndStatus, groupName;
    ImageView homeTeamLogo, awayTeamLogo;

    int currentPage = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_data_admin);



        homeTeamName = findViewById(R.id.home_team_name);
        awayTeamName = findViewById(R.id.away_team_name);
        homeTeamLogo = findViewById(R.id.home_team_logo);
        awayTeamLogo = findViewById(R.id.away_team_logo);
        matchDateAndResult = findViewById(R.id.match_date_and_result);
        matchTimeAndStatus = findViewById(R.id.match_time_and_status);
        groupName = findViewById(R.id.group_name);

        matchDataTabLayout = findViewById(R.id.match_data_tab_layout);
        matchDataTabLayout.addTab(matchDataTabLayout.newTab().setText("GAME EVENTS"));

        matchDataTabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        matchDataTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

        viewPager = findViewById(R.id.viewPager);
        pagerAdapter = new MatchDetailsAdminPagerAdapter(getSupportFragmentManager(), matchDataTabLayout.getTabCount());
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
        matchDateAndResult.setText(getIntent().getStringExtra("matchDateAndResult"));
        matchTimeAndStatus.setText(getIntent().getStringExtra("matchTimeAndStatus"));
        groupName.setText(getIntent().getStringExtra("groupName"));

        Picasso.with(getApplicationContext()).load(getIntent().getStringExtra("homeTeamLogo")).error(R.drawable.empty_team_logo).into(homeTeamLogo);
        Picasso.with(getApplicationContext()).load(getIntent().getStringExtra("awayTeamLogo")).error(R.drawable.empty_team_logo).into(awayTeamLogo);



    }
}
