package com.appbyabhi.miniproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Updatevalue extends AppCompatActivity {
    Spinner s,s2;
    SQLiteDatabase d;
    String original_q;
    String ans_db;
    String selected;
    int test =0;
    ArrayList<String> al = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updatevalue);
        TextView tt1 = findViewById(R.id.textView21);
        TextView tt2 = findViewById(R.id.textView22);
        TextView tt3 = findViewById(R.id.textView23);
        TextView tt4 = findViewById(R.id.textView24);
        Button b = findViewById(R.id.button5);
        Button b2 = findViewById(R.id.button6);


        EditText t1 = findViewById(R.id.editTextTextPersonName);
        EditText t2 = findViewById(R.id.editTextTextPersonName5);
        EditText t3 = findViewById(R.id.editTextTextPersonName2);
        EditText t4 = findViewById(R.id.editTextTextPersonName6);
        EditText t5 = findViewById(R.id.editTextTextPersonName7);

        d = openOrCreateDatabase("mini_project",MODE_PRIVATE,null);
        s = findViewById(R.id.spinner_forq);
        s2 = findViewById(R.id.spinner2);


        s2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                s.setVisibility(View.VISIBLE);

                selected = s2.getSelectedItem().toString();

//                al.add(selected);
                Cursor c = d.rawQuery("select * from mcq where subject = '"+selected+"'",null);
                if (c.getCount()>0) {
                    al.clear();
                    while (c.moveToNext()) {
                        String q = c.getString(1);
                        al.add(q);
                        ArrayAdapter<String> ad = new ArrayAdapter<String>(Updatevalue.this, android.R.layout.simple_list_item_1, al);
                        s.setAdapter(ad);
                    }
                }
                else
                {
                    s.setVisibility(View.INVISIBLE);
                    tt1.setVisibility(View.INVISIBLE);
                    tt2.setVisibility(View.INVISIBLE);
                    tt3.setVisibility(View.INVISIBLE);
                    tt4.setVisibility(View.INVISIBLE);

                    b.setVisibility(View.INVISIBLE);

                    t1.setVisibility(View.INVISIBLE);
                    t2.setVisibility(View.INVISIBLE);
                    t3.setVisibility(View.INVISIBLE);
                    t4.setVisibility(View.INVISIBLE);
                    t5.setVisibility(View.INVISIBLE);
                    Toast.makeText(Updatevalue.this, "No Questions in "+selected+" Subject", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String question = s.getSelectedItem().toString();

                tt1.setVisibility(View.VISIBLE);
                tt2.setVisibility(View.VISIBLE);
                tt3.setVisibility(View.VISIBLE);
                tt4.setVisibility(View.VISIBLE);

                b.setVisibility(View.VISIBLE);

                t1.setVisibility(View.VISIBLE);
                t2.setVisibility(View.VISIBLE);
                t3.setVisibility(View.VISIBLE);
                t4.setVisibility(View.VISIBLE);
                t5.setVisibility(View.VISIBLE);
//                al.add(selected);
                Cursor c = d.rawQuery("select * from mcq where question = '"+question+"'",null);
                if (c.getCount()>0) {
                    while (c.moveToNext()) {
                        String q = c.getString(1);
                        original_q = q;
                        String o1 = c.getString(2);
                        String o2 = c.getString(3);
                        String o3 = c.getString(4);
                        String o4 = c.getString(5);
                        t1.setText(q);
                        t2.setText(o1);
                        t3.setText(o2);
                        t4.setText(o3);
                        t5.setText(o4);

                    }
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String q =t1.getText().toString();
                String o1 = t2.getText().toString();
                String o2 = t3.getText().toString();
                String o3 = t4.getText().toString();
                String o4 = t5.getText().toString();

                if(t1.length()==0){
                    t1.setError("Field Required");
                }
                else if(t2.length()==0){
                    t2.setError("Field Required");
                }
                else if(t3.length()==0){
                    t3.setError("Field Required");
                }
                else if(t4.length()==0){
                    t4.setError("Field Required");
                }
                else if(t5.length()==0){
                    t5.setError("Field Required");
                }
                else {

                    String[] options = {o1, o2, o3, o4};
                    AlertDialog.Builder ab = new AlertDialog.Builder(Updatevalue.this);
                    ab.setTitle("Choose Correct Answer:");
                    ab.setSingleChoiceItems(options, 0, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ans_db = options[which];
                            test = 1;
                            Toast.makeText(Updatevalue.this, "" + ans_db, Toast.LENGTH_SHORT).show();
                        }
                    });
                    ab.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {


                            if (test == 0) {
                                ans_db = options[0];
                            }
                            try {
                                d.execSQL("update mcq set question = '" + q + "',option_a = '" + o1 + "',option_b = '" + o2 + "',option_c = '" + o3 + "',option_d = '" + o4 + "', ans = '" + ans_db + "' where question = '" + original_q + "'");
                            } catch (Exception e) {
                                System.out.println("Exception :" + e);
                            }
                            Cursor c = d.rawQuery("select * from mcq where subject = '"+selected+"'",null);
                            if (c.getCount()>0) {
                                al.clear();
                                while (c.moveToNext()) {
                                    String q = c.getString(1);
                                    al.add(q);
                                    ArrayAdapter<String> ad = new ArrayAdapter<String>(Updatevalue.this, android.R.layout.simple_list_item_1, al);
                                    s.setAdapter(ad);
                                }
                            }
                        }

                    });
                    ab.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    ab.show();
                }

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Updatevalue.this,OptionforOperation.class);
                startActivity(i);
            }
        });

    }
}