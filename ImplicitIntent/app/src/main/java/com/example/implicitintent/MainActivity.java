package com.example.implicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnDial,btnShare,btnMsg,btnEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDial = findViewById(R.id.btnDial);
        btnMsg = findViewById(R.id.btnMsg);
        btnEmail = findViewById(R.id.btnEmail);
        btnShare = findViewById(R.id.btnShare);

        btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent iDial = new Intent(Intent.ACTION_DIAL);
                //iDial.setAction(Intent.ACTION_DIAL)

                iDial.setData(Uri.parse("tel: +8801738546850"));
                startActivity(iDial);
            }
        });
        btnMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iMsg = new Intent(Intent.ACTION_SENDTO);
                iMsg.setData(Uri.parse("smsto:"+Uri.encode("+8801738546850")));
                iMsg.putExtra("sms_body","Hello world");
                startActivity(iMsg);
            }
        });
        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iEmail = new Intent(Intent.ACTION_SEND);
                iEmail.setType("message/rfc822");
                iEmail.putExtra(Intent.EXTRA_EMAIL,new String[]{"hridoyjprng01@gmail.com"});
                iEmail.putExtra(Intent.EXTRA_SUBJECT,"Queries");
                iEmail.putExtra(Intent.EXTRA_TEXT,"Hello World");
                startActivity(Intent.createChooser(iEmail,"Email Via"));
            }
        });
        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iShare = new Intent(Intent.ACTION_SEND);
                iShare.setType("text/plain");
                iShare.putExtra(Intent.EXTRA_TEXT,"Contact Me , https://www.facebook.com/hk.hridoy.6850");
                startActivity(Intent.createChooser(iShare,"Share Via"));
            }
        });

    }
}