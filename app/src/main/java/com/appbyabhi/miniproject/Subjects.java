package com.appbyabhi.miniproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class Subjects extends AppCompatActivity {

    Button mcom,ajava,nma;
    ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subjects);

        mcom = (Button) findViewById(R.id.answer_btn);
        ajava = (Button) findViewById(R.id.next_btn);
        nma = (Button) findViewById(R.id.nma_btn);
        back = (ImageView) findViewById(R.id.back_btn);
        back.isClickable();
        back.setOnClickListener(view -> {
            Intent i = new Intent(Subjects.this, Second_activity.class);
            startActivity(i);
            finish();
        });

        mcom.setOnClickListener(view -> {
            Intent i = new Intent(Subjects.this, Mcom_units.class);
            i.putExtra("pass","MCOM");
            startActivity(i);
            finish();
        });

        ajava.setOnClickListener(view -> {
            Intent i = new Intent(Subjects.this, Mcom_units.class);
            i.putExtra("pass","AJAVA");
            startActivity(i);
            finish();
        });

        nma.setOnClickListener(view -> {
            Intent i = new Intent(Subjects.this, Mcom_units.class);
            i.putExtra("pass","NMA");
            startActivity(i);
            finish();
        });
    }
}