package com.example.intentpassing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnxt;
        btnxt = findViewById(R.id.btnxt);
        Intent inext;
        inext = new Intent(MainActivity.this,SecondActivity.class);
        inext.putExtra("title" , "Home");
        inext.putExtra("Student Name","Raman");
        inext.putExtra("Roll NO",10);
        btnxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(inext);
            }
        });

    }
}