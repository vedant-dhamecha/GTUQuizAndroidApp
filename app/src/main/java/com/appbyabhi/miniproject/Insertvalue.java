package com.appbyabhi.miniproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Insertvalue extends AppCompatActivity {
    TextView q,o1,o2,o3,o4;
    Spinner s;
    Button b1,b2;
    SQLiteDatabase d;
    public String correct_ans;
    public int a_select =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertvalue);
        d = openOrCreateDatabase("mini_project",MODE_PRIVATE,null);
//        d.execSQL("drop table mcq");
        d.execSQL("create table if not exists mcq (subject varchar(20),question varchar(200),option_a varchar(200),option_b varchar(200),option_c varchar(200),option_d varchar(200),ans varchar(200))");
        q = findViewById(R.id.question);
        o1 = findViewById(R.id.OptionA);
        o2 = findViewById(R.id.OptionB);
        o3 = findViewById(R.id.OptionC);
        o4 = findViewById(R.id.OptionD);
        s = findViewById(R.id.spinner);
        b1 = findViewById(R.id.insertbtn);
        b2 = findViewById(R.id.backbutton);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count=0;
                if (q.length()==0)
                {
                    count=1;
                    q.setError("Question Required");
                }
                if (o1.length()==0)
                {
                    count=1;
                    o1.setError("Option Required");
                }
                if (o2.length()==0)
                {
                    count=1;
                    o2.setError("Option Required");
                }
                if (o3.length()==0)
                {
                    count=1;
                    o3.setError("Option Required");
                }
                if (o4.length()==0)
                {
                    count=1;
                    o4.setError("Option Required");
                }
                if(count ==0)
                {
                    String os1 = o1.getText().toString();
                    String os2 = o2.getText().toString();
                    String os3 = o3.getText().toString();
                    String os4 = o4.getText().toString();
                    String[] answer = {os1,os2,os3,os4};
                    AlertDialog.Builder ab = new AlertDialog.Builder(Insertvalue.this);
                    ab.setTitle("Choose your Correct Answer");

                    ab.setSingleChoiceItems(answer, 0, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            String ans;
                            ans = answer[which];
                            if(ans.equals(os1))
                            {

                                correct_ans = os1;
                                a_select =1;
                            }
                            else if(ans.equals(os2))
                            {
                                correct_ans = os2;
                                a_select =1;
                            }
                            else if(ans.equals(os3))
                            {
                                correct_ans = os3;
                                a_select =1;
                            }
                            else if(ans.equals(os4))
                            {
                                correct_ans = os4;
                                a_select =1;
                            }
                        }
                    });
                    ab.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            if (s.getSelectedItem().equals("MCOM"))
                            {
                                if (a_select ==0)
                                {
                                    correct_ans = os1;
                                }
                                String question = q.getText().toString();
                                String Option_1 = o1.getText().toString();
                                String Option_2 = o2.getText().toString();
                                String Option_3 = o3.getText().toString();
                                String Option_4 = o4.getText().toString();
                                try {
                                    d.execSQL("insert into mcq values ( 'MCOM','"+question+"','"+Option_1+"','"+Option_2+"','"+Option_3+"','"+Option_4+"','"+correct_ans+"' )");
                                }
                                catch (Exception e)
                                {
                                    System.out.println("Exception :"+e);
                                }
                                Toast.makeText(Insertvalue.this, "New Question Added Successfully", Toast.LENGTH_SHORT).show();
                                q.setText("");
                                o1.setText("");
                                o2.setText("");
                                o3.setText("");
                                o4.setText("");
                                a_select =0 ;

                            }
                            else if (s.getSelectedItem().equals("AJAVA"))
                            {
                                if (a_select ==0)
                                {
                                    correct_ans = os1;
                                }
                                String question = q.getText().toString();
                                String Option_1 = o1.getText().toString();
                                String Option_2 = o2.getText().toString();
                                String Option_3 = o3.getText().toString();
                                String Option_4 = o4.getText().toString();
                                try {
                                    d.execSQL("insert into mcq values ( 'AJAVA','"+question+"','"+Option_1+"','"+Option_2+"','"+Option_3+"','"+Option_4+"','"+correct_ans+"' )");
                                }
                                catch (Exception e)
                                {
                                    System.out.println("Exception :"+e);
                                }
                                Toast.makeText(Insertvalue.this, "New Question Added Successfully", Toast.LENGTH_SHORT).show();
                                q.setText("");
                                o1.setText("");
                                o2.setText("");
                                o3.setText("");
                                o4.setText("");
                                a_select =0 ;
                            }
                            else if (s.getSelectedItem().equals("NMA"))
                            {
                                if (a_select ==0)
                                {
                                    correct_ans = os1;
                                }
                                String question = q.getText().toString();
                                String Option_1 = o1.getText().toString();
                                String Option_2 = o2.getText().toString();
                                String Option_3 = o3.getText().toString();
                                String Option_4 = o4.getText().toString();
                                try {
                                    d.execSQL("insert into mcq values ( 'NMA','"+question+"','"+Option_1+"','"+Option_2+"','"+Option_3+"','"+Option_4+"','"+correct_ans+"' )");
                                }
                                catch (Exception e)
                                {
                                    System.out.println("Exception :"+e);
                                }
                                Toast.makeText(Insertvalue.this, "New Question Added Successfully", Toast.LENGTH_SHORT).show();
                                q.setText("");
                                o1.setText("");
                                o2.setText("");
                                o3.setText("");
                                o4.setText("");
                                a_select =0 ;
                            }
                        }
                    });
                    ab.setNegativeButton("No", new DialogInterface.OnClickListener() {
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
                Intent i = new Intent(Insertvalue.this,OptionforOperation.class);
                startActivity(i);
            }
        });


    }
}