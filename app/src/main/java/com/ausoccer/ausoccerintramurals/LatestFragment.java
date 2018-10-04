package com.ausoccer.ausoccerintramurals;

import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.ausoccer.ausoccerintramurals.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Date;


/**
 * A simple {@link Fragment} subclass.
 */
public class LatestFragment extends Fragment {

    ListView listView;
    HomeModel homeModel;
    CustomAdapter customAdapter;
    FloatingActionButton addFabButton;
    EditText postTitleInput, postImageUrlInput;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference homeTitles = database.getReference("HomeTitles");


    ArrayList<HomeModel> homeCardsArrayList = new ArrayList<>();


    public LatestFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_latest, container, false);

        listView = v.findViewById(R.id.listContents);
        listView.setDivider(null);

        addFabButton = v.findViewById(R.id.add_fab);

        homeModel = new HomeModel();
        customAdapter = new CustomAdapter(getActivity(), homeCardsArrayList);
        listView.setAdapter(customAdapter);

        homeTitles.orderByChild("time").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                homeCardsArrayList.clear();

                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    HomeModel homeModel = ds.getValue(HomeModel.class);
                    homeCardsArrayList.add(homeModel);
                }

                listView.setAdapter(customAdapter);
                customAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        addFabButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkUserLoggedIn();

            }
        });

        //checkUserLoggedIn();





        return v;
    }

    private void checkUserLoggedIn() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            //Toast.makeText(getContext(), "Logged in. Should display a dialog", Toast.LENGTH_SHORT).show();
            final Dialog d = new Dialog(getContext());
            d.setContentView(R.layout.add_post);

            postTitleInput = d.findViewById(R.id.post_title);
            postImageUrlInput = d.findViewById(R.id.post_image_url);
            Button submitButton = d.findViewById(R.id.submit_button);

            submitButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String postTitle = postTitleInput.getText().toString();
                    String postImageUrl = postImageUrlInput.getText().toString();

                    Long currentTime = -1 * new Date().getTime();
                    Log.d("rer", "Posted on " + currentTime);

                    if (TextUtils.isEmpty(postTitle)) {
                        Toast.makeText(getContext(), "Please enter a title", Toast.LENGTH_SHORT).show();
                        return;

                    }

                    if (TextUtils.isEmpty(postImageUrl)) {
                        Toast.makeText(getContext(), "Please enter an image url", Toast.LENGTH_SHORT).show();
                        return;

                    }

                    HomeModel homeModel = new HomeModel();
                    homeModel.setTitle(postTitle);
                    homeModel.setUrl(postImageUrl);
                    homeModel.setTime(currentTime);

                    homeModel.setUid(homeTitles.push().getKey());

                    try {
                        homeTitles.child(homeModel.getUid()).setValue(homeModel);
                    } catch (DatabaseException ex) {
                        ex.printStackTrace();
                    }

                    d.dismiss();
                }
            });

            d.show();


        } else {
            Toast.makeText(getContext(), "Not logged in", Toast.LENGTH_SHORT).show();


        }


    }

}
