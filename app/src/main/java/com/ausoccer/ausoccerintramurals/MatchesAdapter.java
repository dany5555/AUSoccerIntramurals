package com.ausoccer.ausoccerintramurals;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;
import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

import java.util.ArrayList;

/**
 * Created by Kevin Daniel on 9/3/2018.
 */

public class MatchesAdapter extends BaseAdapter {

    Context context;
    ArrayList<MatchesModel> matchesModelArrayList;
    MatchesModel matchesModel;

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
        TextView matchDateAndResult = view.findViewById(R.id.match_date_and_result);
        TextView matchTimeAndStatus = view.findViewById(R.id.match_time_and_status);
        TextView groupName = view.findViewById(R.id.group_name);

        ImageView homeTeamLogo = view.findViewById(R.id.home_team_logo);
        ImageView awayTeamLogo = view.findViewById(R.id.away_team_logo);


        matchesModel = (MatchesModel) this.getItem(i);


            homeTeamName.setText(matchesModel.getHomeTeamName());
            awayTeamName.setText(matchesModel.getAwayTeamName());
            matchDateAndResult.setText(matchesModel.getMatchDateAndResult());
            matchTimeAndStatus.setText(matchesModel.getMatchTimeAndStatus());
            groupName.setText(matchesModel.getGroupName());

            //Picasso.get().load(matchesModel.getHomeTeamLogoUrl()).error(R.drawable.empty_team_logo).resize(50, 50).centerCrop().into(homeTeamLogo);
            //Picasso.get().load(matchesModel.getAwayTeamLogoUrl()).error(R.drawable.empty_team_logo).resize(50, 50).centerCrop().into(awayTeamLogo);
        Glide.with(context).load(matchesModel.getHomeTeamLogoUrl()).transition(withCrossFade()).into(homeTeamLogo);
        Glide.with(context).load(matchesModel.getAwayTeamLogoUrl()).transition(withCrossFade()).into(awayTeamLogo);







        return view;

    }


}
