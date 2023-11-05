package com.appbyabhi.miniproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Deletevalue extends AppCompatActivity {
    Button b1,b2;
    Spinner s1,s2;
    String select;
    TextView t1;
    String del;
    int check =0;
    ArrayList<String> al = new ArrayList<String>();
    SQLiteDatabase d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deletevalue);
        d = openOrCreateDatabase("mini_project",MODE_PRIVATE,null);
        b1 = findViewById(R.id.back);
        b2 = findViewById(R.id.delete);

        t1 = findViewById(R.id.question_view);

        s1 = findViewById(R.id.sub_spin);
        s2 = findViewById(R.id.q_load);

        s1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                s2.setVisibility(View.VISIBLE);
                b2.setVisibility(View.VISIBLE);
                t1.setVisibility(View.VISIBLE);
                select  = s1.getSelectedItem().toString();
                Cursor c = d.rawQuery("select * from mcq where subject = '"+select+"'",null);
                if (c.getCount()>0) {
                    al.clear();
                    while (c.moveToNext()) {
                        String q = c.getString(1);
                        al.add(q);
                        ArrayAdapter<String> ad = new ArrayAdapter<String>(Deletevalue.this, android.R.layout.simple_list_item_1, al);
                        s2.setAdapter(ad);
                    }
                }
                else
                {
                    s2.setVisibility(View.INVISIBLE);
                    b2.setVisibility(View.INVISIBLE);
                    t1.setVisibility(View.INVISIBLE);
                    Toast.makeText(Deletevalue.this, "No Questions in "+select+" Subject", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        s2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                del = s2.getSelectedItem().toString();
                check=1;

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    d.execSQL("delete from mcq where question = '"+del+"'");
                    Cursor c = d.rawQuery("select * from mcq where subject = '"+select+"'",null);
                    if (c.getCount()>0) {
                        al.clear();
                        while (c.moveToNext()) {
                            String q = c.getString(1);
                            al.add(q);
                            ArrayAdapter<String> ad = new ArrayAdapter<String>(Deletevalue.this, android.R.layout.simple_list_item_1, al);
                            s2.setAdapter(ad);
                        }
                    }
                    else
                    {
                        s2.setVisibility(View.INVISIBLE);
                        b2.setVisibility(View.INVISIBLE);
                        t1.setVisibility(View.INVISIBLE);
                        Toast.makeText(Deletevalue.this, "No Questions in "+select+" Subject", Toast.LENGTH_SHORT).show();
                    }
                    Toast.makeText(Deletevalue.this, "Delete Operation Successful", Toast.LENGTH_SHORT).show();
                }
                catch (Exception e)
                {
                    System.out.println("Exception: "+e);
                }
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Deletevalue.this,OptionforOperation.class);
                startActivity(i);
            }
        });
    }
}