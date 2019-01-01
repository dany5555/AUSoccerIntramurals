package com.ausoccer.ausoccerintramurals;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;


import java.util.ArrayList;

/**
 * Created by Kevin Daniel on 9/5/2018.
 */

public class StandingsAdapter extends BaseAdapter {

    Context context;
    ArrayList<StandingsModel> standingsListModelArray;
    StandingsModel standingsModel;

    public StandingsAdapter(Context context, ArrayList<StandingsModel> standingsListModelArray) {
        this.context = context;
        this.standingsListModelArray = standingsListModelArray;
    }

    @Override
    public int getCount() {
        return standingsListModelArray.size();
    }

    @Override
    public Object getItem(int i) {
        return standingsListModelArray.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.standings_list_model, viewGroup, false);
        }

        TextView teamName = view.findViewById(R.id.team_name);
        TextView matchesPlayed = view.findViewById(R.id.matches_played);
        TextView goalDifference = view.findViewById(R.id.goal_difference);
        TextView points = view.findViewById(R.id.points);
        TextView position = view.findViewById(R.id.position);
        ImageView teamLogo = view.findViewById(R.id.team_logo);

        standingsModel = (StandingsModel) this.getItem(i);

        teamName.setText(standingsModel.getTeamName());
        matchesPlayed.setText(standingsModel.getMatchesPlayed());
        goalDifference.setText(standingsModel.getGoalDifference());
        points.setText(standingsModel.getPoints());
        position.setText(String.valueOf(standingsModel.getPosition()));

        //Picasso.get().load(standingsModel.getTeamLogoUrl()).error(R.drawable.empty_team_logo).resize(50, 50).centerCrop().into(teamLogo);
        Glide.with(context).load(standingsModel.getTeamLogoUrl()).transition(withCrossFade()).into(teamLogo);

        return view;
    }
}
