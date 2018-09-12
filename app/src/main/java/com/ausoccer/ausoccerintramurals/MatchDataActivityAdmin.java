package com.ausoccer.ausoccerintramurals;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MatchDataActivityAdmin extends AppCompatActivity {

    public String matchId;
    public FirebaseDatabase database;
    public DatabaseReference currentMatchRef;
    MatchesModel matchesModel;
    ArrayList<MatchesModel> matchesModelArrayList = new ArrayList<>();

    RelativeLayout liveMatchLayout, notPlayedMatchLayout, finalMatchLayout;

    TextView liveResult, gameStatus, matchNumber;




    TextView homeTeamName, awayTeamName, matchDateAndResult, matchTimeAndStatus, groupName;
    ImageView homeTeamLogo, awayTeamLogo;

    // Game status objects.
    Button halfTimeButton, liveButton, finalButton;

    // Goals objects.
    Button homeDecreaseGoalButton, homeIncreaseGoalButton, awayDecreaseGoalButton, awayIncreaseGoalButton;
    TextView homeGoals, awayGoals;

    // Attempts objects.
    Button homeDecreaseAttemptsButton, homeIncreaseAttemtpsButton, awayDecreaseAttemptsButton, awayIncreaseAttemtpsButton;
    TextView homeAttempts, awayAttempts;

    // On target objects.
    Button homeIncreaseOnTargetButton, homeDecreaseOnTargetButton, awayIncreaseOnTargetButton, awayDecreaseOnTargetButton;
    TextView homeOnTarget, awayOnTarget;

    // Off target objects.
    Button homeDecreaseOffTargetButton, homeIncreaseOffTargetButton, awayDecreaseOffTargetButton, awayIncreaseOffTargetButton;
    TextView homeOffTarget, awayOffTarget;

    // Blocked objects.
    Button homeDecreaseBlockedButton, homeIncreaseBlockButton, awayDecreaseBlockedButton, awayIncreaseBlockButton;
    TextView homeBlocked, awayBlocked;

    // Against woodwork objects.
    Button homeDecreaseAgainstWoodworkButton, homeIncreaseAgainstWoodworkButton, awayDecreaseAgainstWoodworkButton, awayIncreaseAgainstWoodworkButton;
    TextView homeAgainstWoodwork, awayAgainstWoodwork;

    // Corners objects.
    Button homeDecreaseCornersButton, homeIncreaseCornersButton, awayDecreaseCornersButton, awayIncreaseCornersButton;
    TextView homeCorners, awayCorners;

    // Off sides objects.
    Button homeDecreaseOffSidesButton, homeIncreaseOffSidesButton, awayDecreaseOffSidesButton, awayIncreaseOffSidesButton;
    TextView homeOffSides, awayOffSides;

    // Yellow cards objects.
    Button homeDecreaseYellowCardsButton, homeIncreaseYellowCardsButton, awayDecreaseYellowCardsButton, awayIncreaseYellowCardsButton;
    TextView homeYellowCards, awayYellowCards;

    // Red cards objects.
    Button homeDecreaseRedCardsButton, homeIncreaseRedCardsButton, awayDecreaseRedCardsButton, awayIncreaseRedCardsButton;
    TextView homeRedCards, awayRedCards;

    // Fouls objects.
    Button homeDecreaseFoulsButton, homeIncreaseFoulsButton, awayDecreaseFoulsButton, awayIncreaseFoulsButton;
    TextView homeFouls, awayFouls;

    int currentHomeGoals = 0;
    int currentAwayGoals = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_data_admin);

        matchesModel = new MatchesModel();

        liveResult = findViewById(R.id.live_result);
        gameStatus = findViewById(R.id.live_status_textview);
        matchNumber = findViewById(R.id.match_number);

        matchId = getIntent().getStringExtra("id");
        database = FirebaseDatabase.getInstance();
        currentMatchRef = database.getReference("Matches").child("Matchday1").child(matchId);

        Log.v("id", matchId);

        homeTeamName = findViewById(R.id.home_team_name);
        awayTeamName = findViewById(R.id.away_team_name);
        homeTeamLogo = findViewById(R.id.home_team_logo);
        awayTeamLogo = findViewById(R.id.away_team_logo);
        matchDateAndResult = findViewById(R.id.match_date_and_result);
        matchTimeAndStatus = findViewById(R.id.match_time_and_status);
        groupName = findViewById(R.id.group_name);

        currentMatchRef.child("liveResult").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                liveResult.setText(dataSnapshot.getValue().toString());

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        currentMatchRef.child("gameStatus").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                gameStatus.setText(dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        currentMatchRef.child("groupName").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                matchNumber.setText(dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        // Game status objects.
        halfTimeButton = findViewById(R.id.half_time_button);
        liveButton = findViewById(R.id.live_button);
        finalButton = findViewById(R.id.final_button);

        liveMatchLayout = findViewById(R.id.match_info_layout_live);
        notPlayedMatchLayout = findViewById(R.id.match_info_layout_not_played);

        liveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notPlayedMatchLayout.setVisibility(View.GONE);
                liveMatchLayout.setVisibility(View.VISIBLE);

            }
        });

        // Goals objects.
        homeDecreaseGoalButton = findViewById(R.id.home_decrease_goal_button);
        homeIncreaseGoalButton = findViewById(R.id.home_increase_goal_button);
        awayDecreaseGoalButton = findViewById(R.id.away_decrease_goal_button);
        awayIncreaseGoalButton = findViewById(R.id.away_increase_goal_button);
        homeGoals = findViewById(R.id.home_goals_textview);
        awayGoals = findViewById(R.id.away_goals_textview);

        homeDecreaseGoalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentHomeGoals == 0) {
                    //stop decreasing.
                    homeGoals.setText(Integer.toString(currentHomeGoals));
                } else if (currentHomeGoals > 0){
                    currentHomeGoals -= 1;
                    homeGoals.setText(Integer.toString(currentHomeGoals));
                }

                currentMatchRef.child("liveResult").setValue(homeGoals.getText().toString() + "  -  " + awayGoals.getText().toString());
            }
        });

        homeIncreaseGoalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentHomeGoals >= 0) {
                    currentHomeGoals += 1;
                    homeGoals.setText(Integer.toString(currentHomeGoals));
                }

                currentMatchRef.child("liveResult").setValue(homeGoals.getText().toString() + "  -  " + awayGoals.getText().toString());


            }
        });

        awayDecreaseGoalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentAwayGoals == 0) {
                    //stop decreasing.
                    awayGoals.setText(Integer.toString(currentAwayGoals));
                } else if (currentAwayGoals > 0){
                    currentAwayGoals -= 1;
                    awayGoals.setText(Integer.toString(currentAwayGoals));
                }

                currentMatchRef.child("liveResult").setValue(homeGoals.getText().toString() + "  -  " + awayGoals.getText().toString());


            }
        });

        awayIncreaseGoalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentAwayGoals >= 0) {
                    currentAwayGoals += 1;
                    awayGoals.setText(Integer.toString(currentAwayGoals));
                }

                currentMatchRef.child("liveResult").setValue(homeGoals.getText().toString() + "  -  " + awayGoals.getText().toString());

            }
        });






    }

    @Override
    protected void onStart() {
        super.onStart();



        //homeTeamName.setText(getIntent().getStringExtra("homeTeamName"));
        awayTeamName.setText(getIntent().getStringExtra("awayTeamName"));
        matchDateAndResult.setText(getIntent().getStringExtra("matchDateAndResult"));
        matchTimeAndStatus.setText(getIntent().getStringExtra("matchTimeAndStatus"));
        groupName.setText(getIntent().getStringExtra("groupName"));

        //Picasso.get().load(getIntent().getStringExtra("homeTeamLogo")).error(R.drawable.empty_team_logo).into(homeTeamLogo);
        //Picasso.get().load(getIntent().getStringExtra("awayTeamLogo")).error(R.drawable.empty_team_logo).into(awayTeamLogo);
        Glide.with(this).load(getIntent().getStringExtra("homeTeamLogo")).into(homeTeamLogo);
        Glide.with(this).load(getIntent().getStringExtra("awayTeamLogo")).into(awayTeamLogo);




    }
}
