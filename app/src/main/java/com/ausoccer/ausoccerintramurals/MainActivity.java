package com.ausoccer.ausoccerintramurals;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import com.nightonke.boommenu.BoomButtons.ButtonPlaceEnum;
import com.nightonke.boommenu.BoomButtons.OnBMClickListener;
import com.nightonke.boommenu.BoomButtons.TextOutsideCircleButton;
import com.nightonke.boommenu.BoomMenuButton;
import com.nightonke.boommenu.ButtonEnum;
import com.nightonke.boommenu.Piece.PiecePlaceEnum;

public class MainActivity extends AppCompatActivity {

    FirebaseAuth mAuth;
    EditText email, password;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Common.currentToken = FirebaseInstanceId.getInstance().getToken();

        Log.d("MY TOKEN", "token: " + Common.currentToken);


        mAuth = FirebaseAuth.getInstance();

        progressDialog = new ProgressDialog(this);

        android.support.v4.app.FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        // Removed  this line to start the activity with the current and only tournament being held at the moment.
        //ft.replace(R.id.content, new HomeFragment());
        ft.replace(R.id.content, new AULeagueFragment());
        ft.commit();

        ActionBar mActionBar = getSupportActionBar();
        assert mActionBar != null;
        mActionBar.setDisplayShowHomeEnabled(false);
        mActionBar.setDisplayShowTitleEnabled(false);

        LayoutInflater mInflater = LayoutInflater.from(this);

        View actionBar = mInflater.inflate(R.layout.custom_action_bar, null);
        final TextView mTitleTextView = (TextView) actionBar.findViewById(R.id.title_text);
        mTitleTextView.setText(R.string.app_name);
        mActionBar.setCustomView(actionBar);
        mActionBar.setDisplayShowCustomEnabled(true);
        ((Toolbar) actionBar.getParent()).setContentInsetsAbsolute(0,0);

        //BoomMenuButton leftBmb = (BoomMenuButton) actionBar.findViewById(R.id.action_bar_left_bmb);

        /*leftBmb.setButtonEnum(ButtonEnum.TextOutsideCircle);
        leftBmb.setPiecePlaceEnum(PiecePlaceEnum.DOT_4_2);
        leftBmb.setButtonPlaceEnum(ButtonPlaceEnum.SC_4_2);*/


       /*leftBmb.addBuilder(new TextOutsideCircleButton.Builder()
               .normalImageRes(R.drawable.au_league_logo)
               .normalColorRes(R.color.colorPrimary)
               .highlightedColorRes(R.color.colorSecondaryDark)
               .normalText("AU LEAGUE")
               .textGravity(Gravity.CENTER)
               .pieceColor(Color.WHITE)
               .normalTextColorRes(R.color.black)
               .textSize(13)
               .typeface(Typeface.DEFAULT_BOLD)
               .listener(new OnBMClickListener() {
           @Override
           public void onBoomButtonClick(int index) {
               android.support.v4.app.FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
               ft.replace(R.id.content, new AULeagueFragment());
               ft.commit();
               mTitleTextView.setText("AU League");
           }
       }));
       leftBmb.addBuilder(new TextOutsideCircleButton.Builder()
               .normalImageRes(R.drawable.au_cup_logo)
               .normalColorRes(R.color.colorPrimary)
               .highlightedColorRes(R.color.colorSecondaryDark)
               .normalText("AU CUP")
               .textSize(13)
               .normalTextColorRes(R.color.black)
               .pieceColor(Color.WHITE)
               .typeface(Typeface.DEFAULT_BOLD)
               .listener(new OnBMClickListener() {
                   @Override
                   public void onBoomButtonClick(int index) {
                       android.support.v4.app.FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                       ft.replace(R.id.content, new AUCupFragment());
                       ft.commit();
                       mTitleTextView.setText("AU Cup");

                   }
               })
       );
       leftBmb.addBuilder(new TextOutsideCircleButton.Builder()
               .normalImageRes(R.drawable.au_super_cup_logo)
               .normalColorRes(R.color.colorPrimary)
               .highlightedColorRes(R.color.colorSecondaryDark)
               .normalText("AU SUPER CUP")
               .textSize(13)
               .ellipsize(TextUtils.TruncateAt.END)
               .textWidth(400).pieceColor(Color.WHITE)
               .normalTextColorRes(R.color.black)
               .typeface(Typeface.DEFAULT_BOLD)
               .listener(new OnBMClickListener() {
                   @Override
                   public void onBoomButtonClick(int index) {
                       android.support.v4.app.FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                       ft.replace(R.id.content, new AUSuperCupFragment());
                       ft.commit();
                       mTitleTextView.setText("AU Super Cup");

                   }
               })
       );
       leftBmb.addBuilder(new TextOutsideCircleButton.Builder()
               .normalImageRes(R.drawable.home_logo)
               .normalColorRes(R.color.colorPrimary)
               .highlightedColorRes(R.color.colorSecondaryDark)
               .normalText("HOME")
               .textSize(13)
               .ellipsize(TextUtils.TruncateAt.END)
               .pieceColor(Color.WHITE)
               .normalTextColorRes(R.color.black)
               .typeface(Typeface.DEFAULT_BOLD)
               .listener(new OnBMClickListener() {
                   @Override
                   public void onBoomButtonClick(int index) {
                       android.support.v4.app.FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                       ft.replace(R.id.content, new HomeFragment());
                       ft.commit();
                       mTitleTextView.setText(R.string.app_name);

                   }
               })
       );*/



    }

    @Override
    public void onBackPressed() {
        // Back button is disabled.
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.sign_in_action_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            /*case R.id.sign_out_icon :
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(com.ausoccer.ausoccerintramurals.MainActivity.this, "Successfully logged out", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.sign_in_icon :
                final Dialog d = new Dialog(com.ausoccer.ausoccerintramurals.MainActivity.this);
                d.setTitle("Administrator Login");
                d.setContentView(R.layout.login_dialog);

                d.show();



                email = d.findViewById(R.id.email_input);
                password = d.findViewById(R.id.password_input);
                Button loginButton = d.findViewById(R.id.login_button);

                loginButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String e = email.getText().toString().trim();
                        String p = password.getText().toString().trim();

                        if (TextUtils.isEmpty(e)) {
                            Toast.makeText(com.ausoccer.ausoccerintramurals.MainActivity.this, "Please enter email", Toast.LENGTH_SHORT).show();
                            return;
                        }

                        if (TextUtils.isEmpty(p)) {
                            Toast.makeText(com.ausoccer.ausoccerintramurals.MainActivity.this, "Please enter password", Toast.LENGTH_SHORT).show();
                            return;
                        }

                        progressDialog.setMessage("Logging in...");
                        progressDialog.show();

                        mAuth.signInWithEmailAndPassword(e, p)
                                .addOnCompleteListener(com.ausoccer.ausoccerintramurals.MainActivity.this, new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        progressDialog.dismiss();
                                        d.dismiss();

                                        if (task.isSuccessful()) {
                                            //finish();
                                            Toast.makeText(com.ausoccer.ausoccerintramurals.MainActivity.this, "Successfully logged in", Toast.LENGTH_SHORT).show();
                                        } else {
                                            Toast.makeText(com.ausoccer.ausoccerintramurals.MainActivity.this, "Invalid credentials or no connection to the internet", Toast.LENGTH_SHORT).show();

                                        }
                                    }
                                });

                    }
                });
                return true;*/

                //Toast.makeText(getApplicationContext(), "This should show a dialog to log in", Toast.LENGTH_SHORT).show();

            case R.id.privacy_policy :
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://docs.google.com/document/d/e/2PACX-1vTSsCx-udmrGD1_4Nhp3s90fByq92alwQ5Fk3vw9dCICZSqym1gNup_q7FLv_GB0TxP4Rw8Kb3qDebi/pub")));
            default:
                    return super.onOptionsItemSelected(item);

        }
    }

    /*@Override
    protected void onStart() {
        super.onStart();

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            // User is already logged in.
        } else {
            // User is not logged in.
        }
    }*/
}
