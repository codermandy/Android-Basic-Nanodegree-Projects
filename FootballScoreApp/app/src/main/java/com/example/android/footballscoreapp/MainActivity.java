package com.example.android.footballscoreapp;

        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /**Tracks goal Team A*/
    int scoreTeamA=0;
    /**Tracks goal Team B*/
    int scoreTeamB=0;
    /**Tracks foul Team A*/
    int foulTeamA=0;
/**Tracks foul Team B*/
int foulTeamB=0;
    /**
     * Displays the goal for Team A.
     */
    public void displayGoalA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }
    /**
     * Displays the goal for Team B.
     */
    public void displayGoalB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }
    /**
     * Displays the foul for Team A.
     */
    public void displayFoulA(int foul) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_foul);
        scoreView.setText(String.valueOf(foul));
    }
    /**
     * Displays the foul for Team B.
     */
    public void displayFoulB(int foul) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_foul);
        scoreView.setText(String.valueOf(foul));
    }
    /**
     * Increases goal by 1  Team A
     */
    public void goalA(View view) {
        scoreTeamA+=1;
        displayGoalA(scoreTeamA);

    }
    /*
     * Increases redCard by 1 Team A
     */
    public void redCardA(View view){
        foulTeamA++;
       displayFoulA(foulTeamA);
    }
    /*
 * Increases yellowCard by 1 Team A
 */
    public void yellowCardA(View view){
        foulTeamA++;
        displayFoulA(foulTeamA);

    }

    /*
     * Increases goal by 1  Team B
     */
    public void goalB(View view){
        scoreTeamB+=1;
        displayGoalB(scoreTeamB);
    }
    /*
  * Increases redCard by 1  Team B
  */
    public void redCardB(View view){
        foulTeamB++;
        displayFoulB(foulTeamB);
    }    /*
  * Increases yellowCard by 1  Team B
  */
    public void yellowCardB(View view){
        foulTeamB++;
        displayFoulB(foulTeamB);
    }

    /*
    *  Resets  the score Team A and Team B
     */
    public void reset(View view){
        scoreTeamA=0;
        scoreTeamB=0;
        foulTeamA=0;
        foulTeamB=0;
        displayGoalA(0);
        displayGoalB(0);
        displayFoulA(0);
        displayFoulB(0);
    }
}


