package com.example.customtoolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);

        //Step 1
        setSupportActionBar(toolbar);
//        setActionBar();
        //Step 2
        if (getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            getSupportActionBar().setTitle("Hello World");
        }
        //Step 3
//        toolbar.setTitle("Hello World");
        toolbar.setSubtitle("Fuck You");

    }
    //step 4
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(this).inflate(R.menu.opt_menu,menu);
        return super.onCreateOptionsMenu(menu);

    }
    //Step 5
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId==R.id.opt_new){
            Toast.makeText(this, "Created New File", Toast.LENGTH_SHORT).show();
        }
        else if (itemId == R.id.opt_open){
            Toast.makeText(this, "File open", Toast.LENGTH_SHORT).show();
        }
        else if (itemId==R.id.opt_save){
            Toast.makeText(this, "saved", Toast.LENGTH_SHORT).show();
        }
        else if (itemId==android.R.id.home){
            super.onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}