package com.example.toast;

import static android.app.ProgressDialog.show;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Custom Toast
                Toast toast = new Toast(getApplicationContext());
                view = getLayoutInflater().inflate(R.layout.toast_layout,(ViewGroup) findViewById(R.id.viewCon));
                toast.setView(view);

                TextView txtmsg = view.findViewById(R.id.txtmsg);
                txtmsg.setText("message sent...!");
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL,0,0);
                toast.show();
            }
        });
//        Toast.makeText(this, "Hello World", Toast.LENGTH_SHORT).show();

    }
}