package com.ausoccer.ausoccerintramurals;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
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

import java.util.ArrayList;

/**
 * Created by Kevin Daniel on 9/3/2018.
 */

public class MatchesAdapter extends BaseAdapter {

    Context context;
    ArrayList<MatchesModel> matchesModelArrayList;
    MatchesModel matchesModel;
    FirebaseDatabase database;
    DatabaseReference matchdayRef;

    public MatchesAdapter(Context context, ArrayList<MatchesModel> matchesModelArrayList) {
        this.context = context;
        this.matchesModelArrayList = matchesModelArrayList;
    }

    @Override
    public int getCount() {
        return matchesModelArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return matchesModelArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.match_model_layout, viewGroup, false);
        }



        final TextView homeTeamName = view.findViewById(R.id.home_team_name);
        TextView awayTeamName = view.findViewById(R.id.away_team_name);
        TextView matchDate = view.findViewById(R.id.model_match_date);
        TextView matchTime = view.findViewById(R.id.model_match_time);
        TextView matchNumber = view.findViewById(R.id.model_match_number);
        RelativeLayout notPlayedLayout = view.findViewById(R.id.match_info_layout);
        RelativeLayout liveLayout = view.findViewById(R.id.match_live_info_layout);

        TextView liveMatchNumber = view.findViewById(R.id.live_match_number);
        TextView liveResult = view.findViewById(R.id.live_result);
        TextView liveStatus = view.findViewById(R.id.live_match_status);


        ImageView homeTeamLogo = view.findViewById(R.id.home_team_logo);
        ImageView awayTeamLogo = view.findViewById(R.id.away_team_logo);


        matchesModel = (MatchesModel) this.getItem(i);


            homeTeamName.setText(matchesModel.getHomeTeamName());
            awayTeamName.setText(matchesModel.getAwayTeamName());
            matchDate.setText(matchesModel.getMatchDate());
            matchTime.setText(matchesModel.getMatchTime());
            matchNumber.setText("MATCH " + matchesModel.getMatchNumber());

            liveMatchNumber.setText("MATCH " + matchesModel.getMatchNumber());
            liveResult.setText(matchesModel.getResult());
            liveStatus.setText(matchesModel.getMatchStatus());

            //Picasso.get().load(matchesModel.getHomeTeamLogoUrl()).error(R.drawable.empty_team_logo).resize(50, 50).centerCrop().into(homeTeamLogo);
            //Picasso.get().load(matchesModel.getAwayTeamLogoUrl()).error(R.drawable.empty_team_logo).resize(50, 50).centerCrop().into(awayTeamLogo);
        Glide.with(context).load(matchesModel.getHomeTeamLogoUrl()).transition(withCrossFade()).into(homeTeamLogo);
        Glide.with(context).load(matchesModel.getAwayTeamLogoUrl()).transition(withCrossFade()).into(awayTeamLogo);

        String status = matchesModel.getMatchStatus();
        Log.v("status", "Status: " + status);


        if (matchesModel.getMatchStatus().equals("NOT PLAYED")) {

            notPlayedLayout.setVisibility(View.VISIBLE);
            liveLayout.setVisibility(View.GONE);
            return view;
        } else {
            notPlayedLayout.setVisibility(View.GONE);
            liveLayout.setVisibility(View.VISIBLE);
            return view;

        }







        //return view;

    }

    // This method fixes the issue of having the listview scroll all the way to the top when DB is updated.
    public void refill(ArrayList<MatchesModel> matchesModelArrayList) {
        matchesModelArrayList.clear();
        matchesModelArrayList.addAll(matchesModelArrayList);
        notifyDataSetChanged();

    }


}
