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
 * Created by Kevin Daniel on 8/12/2018.
 */

public class CustomAdapter extends BaseAdapter {
    Context context;
    ArrayList<HomeModel> homeModelArrayList;

    public CustomAdapter(Context c, ArrayList<HomeModel> homeModelArrayList) {
        this.context = c;
        this.homeModelArrayList = homeModelArrayList;
    }

    @Override
    public int getCount() {
        return homeModelArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return homeModelArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.home_card_model, viewGroup, false);
        }

        TextView title = view.findViewById(R.id.title_text);
        ImageView imageHolder = view.findViewById(R.id.image_holder);

        final HomeModel homeModel = (HomeModel) this.getItem(i);

        title.setText(homeModel.getTitle());
        //Picasso.get().load(homeModel.getUrl()).into(imageHolder);
        Glide.with(context).load(homeModel.getUrl()).transition(withCrossFade()).into(imageHolder);


        /*view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, homeModel.getFirstName(), Toast.LENGTH_SHORT).show();
            }
        });*/

        return view;

    }
}
