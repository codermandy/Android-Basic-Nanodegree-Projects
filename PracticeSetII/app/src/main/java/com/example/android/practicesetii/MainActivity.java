package com.example.android.practicesetii;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.android.practicesetii.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // PASTE CODE YOU WANT TO TEST HERE
        String firstName = "Lyla";
        String lastName = "Fujiwara";
        String contactInfo = firstName + " " + lastName;
        contactInfo = contactInfo+"<" + lastName + "." + firstName + "@justjava.com>";
        display(contactInfo);
    }

    /**
     * Display methods that allow the text to appear on the screen. Don't worry if you don't know
     * how these work yet. We'll be covering them in lesson 3.
     */

    public void display(String text) {
        TextView t = (TextView) findViewById(R.id.display_text_view);
        t.setText(text);
    }

    public void display(int text) {
        TextView t = (TextView) findViewById(R.id.display_text_view);
        t.setText(text + "");
    }

}