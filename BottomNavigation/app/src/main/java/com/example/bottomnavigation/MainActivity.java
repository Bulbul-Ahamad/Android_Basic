package com.example.bottomnavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
        BottomNavigationView bnView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bnView = findViewById(R.id.bnView);

        bnView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id==R.id.navHome){
                    loadFrag(new Home(),false);
                }
                else if (id==R.id.navSearch){

                    loadFrag(new Search(),false);
                }
                else if (id==R.id.navNew){

                    loadFrag(new New(),false);
                }
                else if (id == R.id.navShop){

                    loadFrag(new Shop(),false);
                }
                else{//R.id.navProfile

                    loadFrag(new Profile(),false);
                }
                return true;
            }
        });
        bnView.setSelectedItemId(R.id.navProfile);


    }

    public void loadFrag(Fragment fragment, Boolean flag){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if (flag)
            ft.add(R.id.container,fragment);
        else
            ft.replace(R.id.container,fragment);
        ft.commit();

    }

}