package com.example.animationexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btntranslate;
    Button btnalpha;
    Button btnscale;
    Button btnrotate;
    TextView txtanim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtanim = findViewById(R.id.txtanim);
        btnalpha = findViewById(R.id.btnalpha);
        btnrotate = findViewById(R.id.btnrotate);
        btnscale = findViewById(R.id.btnscale);
        btntranslate = findViewById(R.id.btntranslate);

        btntranslate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation move = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.move);
                txtanim.startAnimation(move);
            }
        });
        btnalpha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation alpha = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.alpha);
                txtanim.startAnimation(alpha);
            }
        });
        btnscale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation scale = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.scale);
                txtanim.startAnimation(scale);
            }
        });
        btnrotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation rotate = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate);
                txtanim.startAnimation(rotate);
            }
        });


    }
}