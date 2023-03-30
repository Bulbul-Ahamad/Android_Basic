package com.example.alarmmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    static final int ALARM_REQ_CODE = 100;
    EditText editText;
    Button setAlarm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        setAlarm = findViewById(R.id.setAlarm);

        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        setAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int time =Integer.parseInt(editText.getText().toString());
                long trigerTime = System.currentTimeMillis()+(time* 1000L);

                Intent iB = new Intent(MainActivity.this,AlarmService.class);

                PendingIntent pi = PendingIntent.getBroadcast(MainActivity.this,ALARM_REQ_CODE,iB,PendingIntent.FLAG_UPDATE_CURRENT);

                alarmManager.set(AlarmManager.RTC_WAKEUP,trigerTime,pi);

            }
        });
    }
}