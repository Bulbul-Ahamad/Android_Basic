package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerContactAdapter adapter;
    ArrayList<ContactModel> arrayContact = new ArrayList<>();

//ContactModel

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerContact = findViewById(R.id.recyclerContact);
        recyclerContact.setLayoutManager(new LinearLayoutManager(this));

        FloatingActionButton btnOD = findViewById(R.id.btnOD);

        btnOD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.add_update);

                EditText edtname = dialog.findViewById(R.id.edtname);
                EditText edtnum = dialog.findViewById(R.id.edtnum);
                Button btnaction = dialog.findViewById(R.id.btnaction);

                btnaction.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String name="",num="";
                        if (!edtname.getText().toString().equals("")) {
                            name = edtname.getText().toString();
                        }
                        else{
                            Toast.makeText(MainActivity.this, "Please Enter Contact Name", Toast.LENGTH_SHORT).show();
                        }
                        if (!edtnum.getText().toString().equals("")) {
                            num = edtnum.getText().toString();
                        }
                        else{
                            Toast.makeText(MainActivity.this, "Please Enter Contact Number", Toast.LENGTH_SHORT).show();
                        }
                        arrayContact.add(new ContactModel(R.drawable.a,name,num));
                        adapter.notifyItemInserted(arrayContact.size()-1);
                        recyclerContact.scrollToPosition(arrayContact.size()-1);
                        dialog.dismiss();

                    }
                });
                dialog.show();
            }
        });











//        ContactModel model = new ContactModel(R.drawable.a,"A","01738546850");
        arrayContact.add(new ContactModel(R.drawable.a,"A","0"));
        arrayContact.add(new ContactModel(R.drawable.b,"B","1"));
        arrayContact.add(new ContactModel(R.drawable.c,"C","7"));
        arrayContact.add(new ContactModel(R.drawable.d,"D","3"));
        arrayContact.add(new ContactModel(R.drawable.e,"E","8"));
        arrayContact.add(new ContactModel(R.drawable.f,"F","5"));
        arrayContact.add(new ContactModel(R.drawable.g,"G","4"));
        arrayContact.add(new ContactModel(R.drawable.h,"H","6"));
        arrayContact.add(new ContactModel(R.drawable.h,"H","6"));
        arrayContact.add(new ContactModel(R.drawable.h,"H","6"));
        arrayContact.add(new ContactModel(R.drawable.h,"H","6"));
        arrayContact.add(new ContactModel(R.drawable.h,"H","6"));
        arrayContact.add(new ContactModel(R.drawable.h,"H","6"));
        arrayContact.add(new ContactModel(R.drawable.h,"H","6"));
        arrayContact.add(new ContactModel(R.drawable.h,"H","6"));
        arrayContact.add(new ContactModel(R.drawable.i,"I","8"));
        arrayContact.add(new ContactModel(R.drawable.j,"J","5"));
        arrayContact.add(new ContactModel(R.drawable.k,"K","0"));
        arrayContact.add(new ContactModel(R.drawable.l,"L","017"));
        arrayContact.add(new ContactModel(R.drawable.m,"M","385"));
        arrayContact.add(new ContactModel(R.drawable.n,"N","680"));

        adapter = new RecyclerContactAdapter(this,arrayContact);
        recyclerContact.setAdapter(adapter);

    }
}