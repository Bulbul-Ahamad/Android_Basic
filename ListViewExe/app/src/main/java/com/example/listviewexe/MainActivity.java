package com.example.listviewexe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    AutoCompleteTextView actxtvw;
    Spinner spinner;
    int[] arrNo = new int[]{1,2,3,4,5,6};
    ArrayList<String> arrName = new ArrayList<>();
    ArrayList<String> arrId = new ArrayList<>();
    ArrayList<String> arrlang = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        spinner = findViewById(R.id.spinner);
        actxtvw = findViewById(R.id.actxtvw);

        arrName.add("Ram");
        arrName.add("fht");
        arrName.add("dgr");
        arrName.add("dfg");
        arrName.add("bfd");
        arrName.add("fgh");
        arrName.add("gnb");
        arrName.add("gndf");
        arrName.add("lkhv");
        arrName.add("dsges");
        arrName.add("fht");
        arrName.add("dgr");
        arrName.add("dfg");
        arrName.add("bfd");
        arrName.add("fgh");
        arrName.add("gnb");
        arrName.add("gndf");
        arrName.add("lkhv");
        arrName.add("dsges");
        arrName.add("fht");
        arrName.add("dgr");
        arrName.add("dfg");
        arrName.add("bfd");
        arrName.add("fgh");
        arrName.add("gnb");
        arrName.add("gndf");
        arrName.add("lkhv");
        arrName.add("dsges");

        ArrayAdapter<String> ad = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_expandable_list_item_1,arrName);
        listView.setAdapter(ad);
        
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                    int num = position+1;
                    Toast.makeText(MainActivity.this, "Clicked Item No : " + num, Toast.LENGTH_SHORT).show();
            }
        });




        //Spinner
        arrId.add("National Id Card");
        arrId.add("Voter card");
        arrId.add("Ration Card");
        arrId.add("Driving License card");

        ArrayAdapter<String> adS = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,arrId);
        spinner.setAdapter(adS);


        //Auto complete Text View
        arrlang.add("Bangla");
        arrlang.add("English");
        arrlang.add("Hindi");
        arrlang.add("Spanish");
        arrlang.add("US");
        arrlang.add("Arabian");
        arrlang.add("Malaylam");

        ArrayAdapter<String> acAd = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,arrlang);
        actxtvw.setAdapter(acAd);
        actxtvw.setThreshold(0);



    }
}