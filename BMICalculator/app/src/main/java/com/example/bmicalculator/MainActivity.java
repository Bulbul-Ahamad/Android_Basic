package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //get id
        EditText editweight , editheightfeet , editheightin;
        Button btncalculate;
        TextView txtrsl;
        LinearLayout linearMain;
        //connect id with java file
        editweight = findViewById(R.id.editweight);
        editheightfeet = findViewById(R.id.editheightfeet);
        editheightin = findViewById(R.id.editheightin);
        btncalculate = findViewById(R.id.btncalculate);
        txtrsl = findViewById(R.id.txtrsl);
        linearMain = findViewById(R.id.linearMain);

        btncalculate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //get editable data
                int wt = Integer.parseInt(editweight.getText().toString());
                int ft = Integer.parseInt(editheightfeet.getText().toString());
                int in = Integer.parseInt(editheightin.getText().toString());
                //formula for calculating BMI
                int totalin = ft*12+in;
                double totalCm = totalin*2.53;
                double totalM = totalCm/100;
                double bmi = wt/(totalM*totalM);
                //formula for BMI Health Check
                if (bmi>25){
                    txtrsl.setText("You Are OverWeight");
                    linearMain.setBackgroundColor(getResources().getColor(R.color.overweight));
                }
                else if (bmi<18){
                    txtrsl.setText("You Are UnderWeight");
                    linearMain.setBackgroundColor(getResources().getColor(R.color.underweight));
                }
                else {
                    txtrsl.setText("You Are Healthy");
                    linearMain.setBackgroundColor(getResources().getColor(R.color.healthy));
                }


            }
        });

    }
}