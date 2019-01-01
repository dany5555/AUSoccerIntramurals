package com.ausoccer.ausoccerintramurals;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

public class SquadAdapter extends BaseAdapter{

    Context context;
    ArrayList<SquadsModel> squadsModelArrayList;
    SquadsModel squadsModel;

    public SquadAdapter(Context context, ArrayList<SquadsModel> squadsModelArrayList) {
        this.context = context;
        this.squadsModelArrayList = squadsModelArrayList;
    }

    @Override
    public int getCount() {
        return squadsModelArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return squadsModelArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.squad_list_model, viewGroup,false);
        }

        ImageView playerPicture = view.findViewById(R.id.player_picture);
        TextView playerName = view.findViewById(R.id.player_name);
        TextView playerNumber = view.findViewById(R.id.player_number);

        squadsModel = (SquadsModel) this.getItem(i);

        playerName.setText(squadsModel.getFirstName() + " " + squadsModel.getLastName());
        playerNumber.setText(String.valueOf(squadsModel.getNumber()));
        Glide.with(context).load(squadsModel.getPictureUrl()).transition(withCrossFade()).into(playerPicture);

        return view;
    }
}
