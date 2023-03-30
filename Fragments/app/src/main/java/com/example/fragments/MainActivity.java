package com.example.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnFragA,btnFragB,btnFragC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnFragA = findViewById(R.id.btnFragA);
        btnFragB = findViewById(R.id.btnFragB);
        btnFragC = findViewById(R.id.btnFragC);
        //Default Frag
        loadFrag(new BFragment(),0);

        btnFragA.setOnClickListener(view -> loadFrag(new AFragment(),1));
        btnFragB.setOnClickListener(view -> loadFrag(new BFragment(),1));
        btnFragC.setOnClickListener(view -> loadFrag(new CFragment(),1));
    }
    public void loadFrag(Fragment fragment , int flag){

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        Bundle bundle = new Bundle();
        bundle.putString("Arg1","Hridoy");
        bundle.putInt("Arg2",7);
        fragment.setArguments(bundle);
        if (flag == 0)
            ft.add(R.id.container,fragment);
        else
            ft.replace(R.id.container,fragment);

        ft.commit();
    }
}