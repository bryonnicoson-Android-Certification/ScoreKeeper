package com.bryonnicoson.scorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int mScoreTeam1 = 0;
    private int mScoreTeam2 = 0;
    private TextView mScoreText1;
    private TextView mScoreText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mScoreText1 = findViewById(R.id.team1_score);
        mScoreText2 = findViewById(R.id.team2_score);
    }

    /**
     * Methods to reduce or increase scores
     * @param view - used to determine id of button pressed
     */
    public void decreaseScore(View view) {
        int viewID = view.getId();
        switch (viewID) {
            case R.id.team1_minus:
                mScoreTeam1--;
                mScoreText1.setText(String.valueOf(mScoreTeam1));
                break;
            case R.id.team2_minus:
                mScoreTeam2--;
                mScoreText2.setText(String.valueOf(mScoreTeam2));
                break;
        }
    }

    public void increaseScore(View view) {
        int viewID = view.getId();
        switch (viewID) {
            case R.id.team1_plus:
                mScoreTeam1++;
                mScoreText1.setText(String.valueOf(mScoreTeam1));
                break;
            case R.id.team2_plus:
                mScoreTeam2++;
                mScoreText2.setText(String.valueOf(mScoreTeam2));
                break;
        }
    }
}
