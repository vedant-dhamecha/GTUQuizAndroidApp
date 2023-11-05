package com.appbyabhi.miniproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DisplayScore extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_score);
        Intent i = getIntent();
        int t = i.getIntExtra("Total",0);
        int r = i.getIntExtra("Right",0);


        int w = t-r;
        TextView t1 = findViewById(R.id.total_d);
        TextView t2 = findViewById(R.id.right_d);
        TextView t3 = findViewById(R.id.wrong_d);
        t1.setText("Total Questions: "+t);
        t2.setText("Correct Answers: "+r);
        t3.setText("Incorrect Answers: "+w);
        Button b1 = findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2 = new Intent(DisplayScore.this,Second_activity.class);
                startActivity(i2);
            }
        });
    }
}