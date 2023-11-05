package com.appbyabhi.miniproject;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Second_activity extends AppCompatActivity {
    Button btn,btn2;
    SQLiteDatabase d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        d = openOrCreateDatabase("mini_project",MODE_PRIVATE,null);
//        d.execSQL("drop table mcq");
        d.execSQL("create table if not exists mcq (subject varchar(20),question varchar(200),option_a varchar(200),option_b varchar(200),option_c varchar(200),option_d varchar(200),ans varchar(200))");

        btn = (Button) findViewById(R.id.viewapp);
        btn2 = (Button) findViewById(R.id.admin_login);
        btn.setOnClickListener(view -> {
            Intent i = new Intent(Second_activity.this, Subjects.class);
            startActivity(i);
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Second_activity.this, AdminLogin.class);
                startActivity(i);
            }
        });

    }
}