package com.example.roomlibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText edtName,edtAmount;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtAmount=findViewById(R.id.edtAmount);
        edtName=findViewById(R.id.edtName);
        btnAdd=findViewById(R.id.btnAddd);

        DBHelper dbHelper = DBHelper.getDB(this);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = edtName.getText().toString();
                String amount = edtAmount.getText().toString();

                dbHelper.expenseDao().addTx(new Expense(title,amount));
                ArrayList<Expense> arrayList = (ArrayList<Expense>) dbHelper.expenseDao().getAllExpense();

                for (int i = 0; i < arrayList.size(); i++) {

                    Log.d("Data","Title : "+arrayList.get(i).getTitle()+" Amount : "+arrayList.get(i).getAmount());

                }

            }
        });



    }
}