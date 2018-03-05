package com.bryonnicoson.scorekeeper;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Member variables for holding the score
    private int mScoreTeam1 = 0;
    private int mScoreTeam2 = 0;

    // Member variables for the views
    private TextView mScoreText1;
    private TextView mScoreText2;

    // Tags for saving state
    static final String STATE_SCORE_1 = "Team 1 Score";
    static final String STATE_SCORE_2 = "Team 2 Score";

    /**
     * Initialize activity
     * @param savedInstanceState - contains app state information (scores)
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mScoreText1 = findViewById(R.id.team1_score);
        mScoreText2 = findViewById(R.id.team2_score);

        // Restore the scores if saved
        if (savedInstanceState != null) {
            mScoreTeam1 = savedInstanceState.getInt(STATE_SCORE_1);
            mScoreTeam2 = savedInstanceState.getInt(STATE_SCORE_2);
            mScoreText1.setText(String.valueOf(mScoreTeam1));
            mScoreText2.setText(String.valueOf(mScoreTeam2));
        }
    }

    /**
     * Create night mode menu option
     * @param menu - toolbar options menu
     * @return - true to display the menu, false to hide it
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        int nightMode = AppCompatDelegate.getDefaultNightMode();
        if(nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
            menu.findItem(R.id.night_mode).setTitle(R.string.day_mode);
        } else {
            menu.findItem(R.id.night_mode).setTitle(R.string.night_mode);
        }
        return true;
    }

    /**
     * Handle option menu clicks
     * @param item = the item clicked
     * @return true (the click was handled)
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // if the night mode is clicked, get current state and toggle it
        if (item.getItemId() == R.id.night_mode){
            int nightMode = AppCompatDelegate.getDefaultNightMode();

            if(nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }
            // recreate the activity for the theme change to take effect
            recreate();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Methods to reduce or increase scores
     * @param view - the button view pressed
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

    /**
     * Preserve the scores on device configuration change
     * @param outState - bundle with scores
     */

    @Override
    public void onSaveInstanceState(Bundle outState) {
        // save the scores
        outState.putInt(STATE_SCORE_1, mScoreTeam1);
        outState.putInt(STATE_SCORE_2, mScoreTeam2);
        super.onSaveInstanceState(outState);
    }

}
