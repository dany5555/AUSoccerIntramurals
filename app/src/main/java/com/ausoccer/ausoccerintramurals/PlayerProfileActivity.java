package com.ausoccer.ausoccerintramurals;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class PlayerProfileActivity extends AppCompatActivity {

    DatabaseReference currentPlayerRef, currentTeamRef;
    FirebaseDatabase database;
    String playerUid;
    String currentTeamUid;

    TextView playerName, teamName, playerNumber, playerPosition, playerCountry, playerWeight, playerHeight, playerAge;
    ImageView teamLogo, playerPicture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_profile);

        playerUid = getIntent().getStringExtra("playerUid");
        currentTeamUid = getIntent().getStringExtra("teamUid");

        playerName = findViewById(R.id.player_name);
        teamName = findViewById(R.id.team_name);
        playerNumber = findViewById(R.id.player_number);
        playerPosition = findViewById(R.id.position);
        playerAge = findViewById(R.id.age);
        playerCountry = findViewById(R.id.country);
        playerWeight = findViewById(R.id.weight);
        playerHeight = findViewById(R.id.height);

        teamLogo = findViewById(R.id.team_logo);
        playerPicture = findViewById(R.id.player_picture);

        database = FirebaseDatabase.getInstance();
        currentPlayerRef = database.getReference("Squads").child(currentTeamUid).child("Defenders").child(playerUid);
        currentTeamRef = database.getReference("Teams").child(currentTeamUid);

        currentTeamRef.child("teamLogoUrl").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Glide.with(getApplicationContext()).load(dataSnapshot.getValue().toString()).into(teamLogo);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        currentPlayerRef.child("team").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                teamName.setText(dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        currentPlayerRef.child("playerUid").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                playerName.setText(dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        currentPlayerRef.child("number").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                playerNumber.setText(dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        currentPlayerRef.child("country").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                playerCountry.setText(dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        currentPlayerRef.child("weight").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                playerWeight.setText(dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        currentPlayerRef.child("height").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                playerHeight.setText(dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        currentPlayerRef.child("age").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                playerAge.setText(dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        currentPlayerRef.child("position").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                playerPosition.setText(dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        currentPlayerRef.child("pictureUrl").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Glide.with(getApplicationContext()).load(dataSnapshot.getValue().toString()).into(playerPicture);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
