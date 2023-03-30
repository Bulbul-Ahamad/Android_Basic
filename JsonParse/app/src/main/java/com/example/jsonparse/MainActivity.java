package com.example.jsonparse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

//    MyAdapter adapter;
    ArrayList<List> listArrayList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = findViewById(R.id.listView);
        String url = "https://jsonplaceholder.typicode.com/todos";
        AndroidNetworking.initialize(getApplicationContext());
        AndroidNetworking.get(url)
                .setPriority(Priority.HIGH)
                .build()
                .getAsJSONArray(new JSONArrayRequestListener() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d("Res",response.toString());

                        //Parsing
                        for (int i = 0 ; i<response.length();i++){
                            try {
                                JSONObject objResult = response.getJSONObject(i);
                                String Mtitle = objResult.getString("title");
                                int Mid = objResult.getInt("id");
                                listArrayList.add(new List(Mid,Mtitle));
                                ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1,listArrayList);
                                listView.setAdapter(adapter);



                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }



                    }

                    @Override
                    public void onError(ANError anError) {
                        anError.printStackTrace();
                        Log.e("Error",anError.toString());
                    }
                });
    }
}