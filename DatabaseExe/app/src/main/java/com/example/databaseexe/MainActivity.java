package com.example.databaseexe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //DATABASE
        MyDBHelper dbHelper = new MyDBHelper(this);
//        dbHelper.addContact("HRDOY","0173846850");
//        dbHelper.addContact("HRIDO","0173854685");
//        dbHelper.addContact("HRIDY","0173854680");
//        dbHelper.addContact("HRIOY","0173854650");

//        ContactModel model = new ContactModel();
//        model.id = 2;
//        model.phone_no = "12312312312";
//        dbHelper.updateContact(model);

        dbHelper.deleteContact(2);

        ArrayList<ContactModel> arrContact = dbHelper.getContact();

        for (int i = 0; i < arrContact.size(); i++) {
            Log.d("Contact_info","Name: "+arrContact.get(i).name+" Phone No: "+arrContact.get(i).phone_no);
        }

    }
}