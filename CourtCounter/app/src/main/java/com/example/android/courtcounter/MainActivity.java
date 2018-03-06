package com.example.android.courtcounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    /**Tracks score Team A*/
    int scoreTeamA=0;
    /**Tracks score Team B*/
    int scoreTeamB=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }
    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }
    /**
     * Increases score by 3 points Team A
     */
    public void threePointsA(View view) {
        scoreTeamA+=3;
        displayForTeamA(scoreTeamA);

    }

    /**
     * Increases score by 2 points Team A
     */
    public void twoPointsA(View view) {
        scoreTeamA+=2;
        displayForTeamA(scoreTeamA);


    }


    /**
     * Increases score by 1 points Team A
     */
    public void freePointsA(View view) {
        scoreTeamA+=1;
        displayForTeamA(scoreTeamA);

    }
    /**
     * Increases score by 3 points Team B
     */
    public void threePointsB(View v){
        scoreTeamB+=3;
        displayForTeamB(scoreTeamB);
    }
    /**
     * Increases score by 2 points Team B
     */
    public void twoPointsB(View v){
        scoreTeamB+=2;
        displayForTeamB(scoreTeamB);
    }
    /**
     * Increases score by 1 points Team B
     */
    public void freePointsB(View v){
        scoreTeamB+=1;
        displayForTeamB(scoreTeamB);
    }
    /*
    *  Resets  the score Team A and Team B
     */
    public void reset(View v){
      scoreTeamA=0;
        scoreTeamB=0;
        displayForTeamA(0);
        displayForTeamB(0);
    }
}


