package com.ausoccer.ausoccerintramurals;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class GameEventsFragment extends Fragment {

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



    public GameEventsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_game_events, container, false);

        // Game status objects.
        halfTimeButton = v.findViewById(R.id.half_time_button);
        liveButton = v.findViewById(R.id.live_button);
        finalButton = v.findViewById(R.id.final_button);

        // Goals objects.
        homeDecreaseGoalButton = v.findViewById(R.id.home_decrease_goal_button);
        homeIncreaseGoalButton = v.findViewById(R.id.home_increase_goal_button);
        awayDecreaseGoalButton = v.findViewById(R.id.away_decrease_goal_button);
        awayIncreaseGoalButton = v.findViewById(R.id.away_increase_goal_button);
        homeGoals = v.findViewById(R.id.home_goals_textview);
        awayGoals = v.findViewById(R.id.away_goals_textview);

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
            }
        });

        homeIncreaseGoalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentHomeGoals >= 0) {
                    currentHomeGoals += 1;
                    homeGoals.setText(Integer.toString(currentHomeGoals));
                }

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

            }
        });

        awayIncreaseGoalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentAwayGoals >= 0) {
                    currentAwayGoals += 1;
                    awayGoals.setText(Integer.toString(currentAwayGoals));
                }
            }
        });


        return v;
    }

}
