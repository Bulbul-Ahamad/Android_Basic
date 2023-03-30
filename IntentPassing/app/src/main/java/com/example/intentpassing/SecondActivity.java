package com.example.intentpassing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent fromAct = getIntent();
        String title = fromAct.getStringExtra("title");
        String studentName = fromAct.getStringExtra("Student Name");
        int roll = fromAct.getIntExtra("Roll NO",0);

        TextView stdinfo;
        stdinfo = findViewById(R.id.stdinfo);
        stdinfo.setText("Roll No : "+roll+"Name"+studentName);
        getSupportActionBar().setTitle(title);
    }
}