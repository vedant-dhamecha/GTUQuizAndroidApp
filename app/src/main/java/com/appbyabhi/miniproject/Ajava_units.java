package com.appbyabhi.miniproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class Ajava_units extends AppCompatActivity {
    ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajava_units);

        back = (ImageView) findViewById(R.id.ajava_units_back);
        back.isClickable();
        back.setOnClickListener(view -> {
            Intent i = new Intent(Ajava_units.this, Subjects.class);
            startActivity(i);
            finish();
        });
    }
}