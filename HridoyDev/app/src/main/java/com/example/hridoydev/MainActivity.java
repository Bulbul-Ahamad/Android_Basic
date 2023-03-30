package com.example.hridoydev;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity extends AppCompatActivity {
    TextView textView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new OnCompleteListener<String>() {
            @Override
            public void onComplete(@NonNull Task<String> task) {
                if (!task.isSuccessful()){
                    Log.e("TokenDetails","Token Failed To Receive!");
                    return;
                }
                String token = task.getResult();
                Log.d("Token",token);
            }
        });
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("CopyWrite");
        databaseReference.setValue("Wscube Tech,All Rights Reserved");
        DatabaseReference contactref = FirebaseDatabase.getInstance().getReference("Contact");
        String contactID = contactref.push().getKey();
        ContactModel contactModel = new ContactModel("Hridoy","01738546850");
        if (contactID != null) {
            contactref.child(contactID).setValue(contactModel);
        }

        //Receiving Data
        contactref.child(contactID).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ContactModel model = snapshot.getValue(ContactModel.class);
                Log.d("Contact",model.getName()+" , "+model.getMobNo());
                textView = findViewById(R.id.textView);
                textView.setText(model.getName()+" , "+model.getMobNo());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("DBError",error.toString());
            }
        });


    }
}