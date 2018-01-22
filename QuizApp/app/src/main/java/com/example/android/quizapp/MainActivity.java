package com.example.android.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.duration;
import static android.R.attr.id;
import static android.R.attr.onClick;
import static com.example.android.quizapp.R.id.q1_option3;
import static com.example.android.quizapp.R.id.q2_option1;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    int score=0;
    public void correctAnswers(View view) {
        RadioButton radioButton = (RadioButton) findViewById(R.id.q1_option3);
        boolean answer1 = radioButton.isChecked();
        CheckBox checkBox1 = (CheckBox) findViewById(R.id.q2_option3);
        CheckBox checkBox2 = (CheckBox) findViewById(R.id.q2_option1);
        boolean answer2 = checkBox2.isChecked() && checkBox1.isChecked();
        EditText editText = (EditText) findViewById(R.id.q3_correct_answer);
        boolean answer3 = editText.getText().toString().toUpperCase().equalsIgnoreCase("eniac");
        CheckBox checkBox = (CheckBox) findViewById(R.id.q4_option4);
        boolean answer4 = checkBox.isChecked();
        submitAnswers(answer1,answer2,answer3,answer4);
    }
    /*
    * Resets the score to 0, clears all checkboxes, edittext and radiobuttons
    * @param view
    */
    public void resetScore(View view){

        score=0;
        //Resetting all the radio buttons q1
        RadioGroup radioGroup=(RadioGroup) findViewById(R.id.single_choice_answer);
        radioGroup.clearCheck();
        //Resetting all the checkboxes q2
        CheckBox checkBox1=(CheckBox) findViewById(R.id.q2_option1);
        checkBox1.setChecked(false);
        CheckBox checkBox2=(CheckBox) findViewById(R.id.q2_option2);
        checkBox2.setChecked(false);
        CheckBox checkBox3=(CheckBox) findViewById(R.id.q2_option3);
        checkBox3.setChecked(false);
        CheckBox checkBox4=(CheckBox) findViewById(R.id.q2_option4);
        checkBox4.setChecked(false);
        //Resetting the edit text q3
        EditText editText=(EditText) findViewById(R.id.q3_correct_answer);
        editText.setText("");
        //Resetting the checkbox q4
        CheckBox checkBox5=(CheckBox) findViewById(R.id.q4_option1);
        checkBox5.setChecked(false);
        CheckBox checkBox6=(CheckBox) findViewById(R.id.q4_option2);
        checkBox6.setChecked(false);
        CheckBox checkBox7=(CheckBox) findViewById(R.id.q4_option3);
        checkBox7.setChecked(false);
        CheckBox checkBox8=(CheckBox) findViewById(R.id.q4_option4);
        checkBox8.setChecked(false);



    }
        public void submitAnswers(boolean a1,boolean a2,boolean a3,boolean a4 ){
        if(a1){
            score++;
        }
        if(a2){
            score++;
        }
        if(a3){
            score++;
        }
        if(a4){
            score++;
        }
        Toast toast = Toast.makeText(this,"Final Score is "+score, Toast.LENGTH_LONG);
        toast.show();
        Log.v("MainActivity","final score"+score);
            score=0;

    }

}
