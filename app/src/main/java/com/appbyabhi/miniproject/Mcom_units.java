package com.appbyabhi.miniproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Mcom_units extends AppCompatActivity {
    ImageView back;
    Button b1,b2,b3,b4;
    TextView q;
    Button r1,r2,r3,r4;
    int flag = 0;
    int correct_ans=0,Total=0;
    SQLiteDatabase d;
    public int i;
    public int click_done =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mcom_units);
        d = openOrCreateDatabase("mini_project",MODE_PRIVATE,null);
        q = findViewById(R.id.displat_q);
        r1 = findViewById(R.id.op1);
        r2 = findViewById(R.id.op2);
        r3 = findViewById(R.id.op3);
        r4 = findViewById(R.id.op4);


        b1 = findViewById(R.id.prev_btn);
        b2 = findViewById(R.id.answer_btn);
        b3 = findViewById(R.id.next_btn);
        b3.setEnabled(false);
        b4 = findViewById(R.id.next_btn2);

        Intent previous = getIntent();
        String sub = previous.getStringExtra("pass");
        TextView t1 = findViewById(R.id.title1);
        if (sub.equals("MCOM"))
        {
            t1.setText("MCOM QUIZ");
        }
        else if(sub.equals("AJAVA"))
        {
            t1.setText("AJAVA QUIZ");
        }
        else if(sub.equals("NMA"))
        {
            t1.setText("NMA QUIZ");
        }

        try {
            Cursor c = d.rawQuery("select * from mcq where subject = '"+sub+"'",null);
            i = c.getCount();

            if (i==0)
            {
                r1.setVisibility(View.INVISIBLE);
                r2.setVisibility(View.INVISIBLE);
                r3.setVisibility(View.INVISIBLE);
                r4.setVisibility(View.INVISIBLE);
                q.setText("No Questions to Display");
                b1.setVisibility(View.INVISIBLE);
                b2.setVisibility(View.INVISIBLE);
                b3.setVisibility(View.INVISIBLE);
                b4.setVisibility(View.INVISIBLE);
                Toast.makeText(this, "No Question Available for "+sub+" Subject", Toast.LENGTH_SHORT).show();
                Intent in  = new Intent(Mcom_units.this,Subjects.class);
                startActivity(in);
            }
            else {
                c.moveToFirst();
                Total = i;
                recursionFunction(c);
                b4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //                    Toast.makeText(Mcom_units.this, ""+Total, Toast.LENGTH_SHORT).show();
                        //                    Toast.makeText(Mcom_units.this, ""+correct_ans, Toast.LENGTH_SHORT).show();
                        Intent i1 = new Intent(Mcom_units.this, DisplayScore.class);
                        i1.putExtra("Total", Total);
                        i1.putExtra("Right", correct_ans);
                        startActivity(i1);
                    }
                });
            }

        }
        catch (Exception e)
        {
            System.out.println("Exception: "+e);
        }

        int check =0;


        back = (ImageView) findViewById(R.id.mcom_units_back);
        back.isClickable();
        back.setOnClickListener(view -> {
            Intent i = new Intent(Mcom_units.this, Subjects.class);
            startActivity(i);
            finish();
        });
    }

    private void recursionFunction(Cursor c) {
        q.setText(c.getString(1));
        r1.setText(c.getString(2));
        r2.setText(c.getString(3));
        r3.setText(c.getString(4));
        r4.setText(c.getString(5));
        String answer = c.getString(6);

        if(c.isLast())
        {
            b3.setVisibility(View.INVISIBLE);
            b4.setVisibility(View.VISIBLE);
        }
        r1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(click_done==0)
                {
                    click_done =1;
                    String value = r1.getText().toString();
                    if (value.equals(answer))
                    {
                        if (flag==0)
                        {
                            correct_ans++;
                            flag=1;
                        }
                        r1.setBackgroundColor(Color.GREEN);
                    }
                    else
                    {
                        r1.setBackgroundColor(Color.RED);
                    }
                    checkFunction(r1,r2,r3,r4,answer);
                    b3.setEnabled(true);
                }


            }
        });
        r2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (click_done ==0)
                {
                    click_done =1;
                    String value = r2.getText().toString();
                    if (value.equals(answer))
                    {
                        if (flag==0)
                        {
                            correct_ans++;
                            flag=1;
                        }
                        r2.setBackgroundColor(Color.GREEN);
                    } else
                    {
                        r2.setBackgroundColor(Color.RED);
                    }
                    checkFunction(r1,r2,r3,r4,answer);
                    b3.setEnabled(true);
                }

            }
        });
        r3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (click_done==0)
                {
                    click_done =1;
                    String value = r3.getText().toString();
                    if (value.equals(answer))
                    {
                        if (flag==0)
                        {
                            correct_ans++;
                            flag=1;
                        }
                        r3.setBackgroundColor(Color.GREEN);
                    } else
                    {
                        r3.setBackgroundColor(Color.RED);
                    }
                    checkFunction(r1,r2,r3,r4,answer);
                    b3.setEnabled(true);
                }

            }
        });
        r4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (click_done==0)
                {
                    click_done =1;
                    String value = r4.getText().toString();
                    if (value.equals(answer)) {
                        if (flag==0)
                        {
                            correct_ans++;
                            flag=1;
                        }
                        r4.setBackgroundColor(Color.GREEN);
                    } else {
                        r4.setBackgroundColor(Color.RED);
                    }
                    checkFunction(r1,r2,r3,r4,answer);
                    b3.setEnabled(true);
                }
            }
        });


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkFunction(r1,r2,r3,r4,answer);
                b3.setEnabled(true);
                click_done = 1;
                flag = 1;
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b1.setVisibility(View.VISIBLE);
                clear(r1,r2,r3,r4);
                clear(r1,r2,r3,r4);
                click_done=0;
                c.moveToNext();
                b3.setEnabled(false);
                flag=0;
                recursionFunction(c);

            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clear(r1,r2,r3,r4);
                flag=1;
                click_done=0;
            }
        });

    }

    private void clear(Button r1, Button r2, Button r3, Button r4) {
        r1.setBackgroundColor(Color.parseColor("#253A48"));
        r2.setBackgroundColor(Color.parseColor("#253A48"));
        r3.setBackgroundColor(Color.parseColor("#253A48"));
        r4.setBackgroundColor(Color.parseColor("#253A48"));

    }

    private void checkFunction(Button r1, Button r2, Button r3, Button r4, String answer) {
        String v1 = r1.getText().toString();
        String v2 = r2.getText().toString();
        String v3 = r3.getText().toString();
        String v4 = r4.getText().toString();
        if (v1.equals(answer))
        {

            r1.setBackgroundColor(Color.GREEN);
        }
        else if (v2.equals(answer))
        {
            r2.setBackgroundColor(Color.GREEN);
        }
        else if (v3.equals(answer))
        {
            r3.setBackgroundColor(Color.GREEN);
        }
        else if (v4.equals(answer))
        {
            r4.setBackgroundColor(Color.GREEN);
        }
    }
}