package com.example.json;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
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
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
        ArrayList<String> arrNames = new ArrayList<>();
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
                        for (int i = 0; i < response.length(); i++) {
                            try {
                                JSONObject objResult = response.getJSONObject(i);
                                String id = objResult.getString("id");
                                String title = objResult.getString("title");
                                arrNames.add(id+".    "+title);
                                ArrayAdapter<String> ar = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1,arrNames);
                                listView.setAdapter(ar);



                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                    }

                    @Override
                    public void onError(ANError anError) {
                        anError.printStackTrace();
                    }
                });
    }
}