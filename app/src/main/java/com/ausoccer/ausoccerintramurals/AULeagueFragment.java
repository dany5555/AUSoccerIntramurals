package com.ausoccer.ausoccerintramurals;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class AULeagueFragment extends Fragment {

    BottomNavigationView bottomNavigationView;

    LatestFragment latestFragment;
    MatchesFragment matchesFragment;
    StandingsFragment standingsFragment;
    AboutFragment aboutFragment;




    public AULeagueFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_auleague, container, false);



        bottomNavigationView = v.findViewById(R.id.bottom_navigation_view);

        latestFragment = new LatestFragment();
        matchesFragment = new MatchesFragment();
        standingsFragment = new StandingsFragment();
        aboutFragment = new AboutFragment();






        setFragment(latestFragment);



        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.news_button :
                        setFragment(latestFragment);
                        return true;


                    case R.id.matches_button :
                        setFragment(matchesFragment);
                        return true;

                    case R.id.standings_button :
                        setFragment(standingsFragment);
                        return true;

                    default :
                        return false;


                }
            }
        });

        return v;


    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.content, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
