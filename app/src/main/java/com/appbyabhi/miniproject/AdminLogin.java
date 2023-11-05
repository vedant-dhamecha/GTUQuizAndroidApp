package com.appbyabhi.miniproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AdminLogin extends AppCompatActivity {
    Button b1;
    SQLiteDatabase d;
    TextView t1,t2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        d = openOrCreateDatabase("mini_project",MODE_PRIVATE,null);
        d.execSQL("create table if not exists admin (adminid int primary key,admin_name varchar(20),password varchar(20))");
        d.execSQL("replace into admin values(1,'admin','1234')");
        b1 = findViewById(R.id.adminlogin);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = 0;
                t1 = findViewById(R.id.editTextTextPersonName3);
                t2 = findViewById(R.id.editTextTextPersonName4);
                if(t1.length()==0)
                {
                    t1.setError("Username is required");
                    count =1;
                }
                if (t2.length()==0)
                {
                    t2.setError("Password is required");
                    count =1;
                }
                if (count == 0)
                {
                    String uname = t1.getText().toString();
                    String password = t2.getText().toString();
                    Cursor c = d.rawQuery("select * from admin where admin_name = '" + uname + "' ",null);
                    int found=0;
                    while(c.moveToNext())
                    {
                        found=1;
                        String cp = c.getString(2);
                        if (cp.equals(password))
                        {
                            Intent i = new Intent(AdminLogin.this, OptionforOperation.class);
                            startActivity(i);
                        }
                        else 
                        {
                            Toast.makeText(AdminLogin.this, "Incorrect Password", Toast.LENGTH_SHORT).show();
                        }
                        
                    }
                    if (found==0)
                    {
                        Toast.makeText(AdminLogin.this, "Incorrect Username", Toast.LENGTH_SHORT).show();
                    }
                    

                }

            }
        });
        
    }
}