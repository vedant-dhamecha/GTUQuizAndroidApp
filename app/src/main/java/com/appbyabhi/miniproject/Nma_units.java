package com.appbyabhi.miniproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class Nma_units extends AppCompatActivity {
    ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nma_units);

        back = (ImageView) findViewById(R.id.nma_units_back);
        back.isClickable();
        back.setOnClickListener(view -> {
            Intent i = new Intent(Nma_units.this, Subjects.class);
            startActivity(i);
            finish();
        });
    }
}