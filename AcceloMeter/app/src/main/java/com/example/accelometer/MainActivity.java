package com.example.accelometer;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        if (sensorManager != null) {

            Sensor sense = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
            if (sense!=null){
                sensorManager.registerListener(this,sense,SensorManager.SENSOR_DELAY_FASTEST);
            }
            else{
                Toast.makeText(this, "Sensor Services Not Detected", Toast.LENGTH_SHORT).show();
            }

        }
        else{
            Toast.makeText(this, "Sensor Services Not Detected", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

        if (sensorEvent.sensor.getType()==Sensor.TYPE_LIGHT){
//            ((TextView)findViewById(R.id.textView)).setText("X : "+sensorEvent.values[0]+"\n\n Y : "+sensorEvent.values[1]+"\n\n Z : "+sensorEvent.values[2]);
//            ((TextView)findViewById(R.id.textView)).setText("values : "+sensorEvent.values[0]);
//            if (sensorEvent.values[0]>0){
//                Toast.makeText(this, "So Far Away", Toast.LENGTH_SHORT).show();
//            }
//            else{
//                Toast.makeText(this, "So Near", Toast.LENGTH_SHORT).show();
//            }
        ((TextView)findViewById(R.id.textView)).setText("Values : "+sensorEvent.values[0]);


        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}