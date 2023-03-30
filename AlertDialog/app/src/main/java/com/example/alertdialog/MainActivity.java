package com.example.alertdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Single Button Alert Dialog
        AlertDialog alert = new AlertDialog.Builder(this).create();
        alert.setTitle("Terms & Condition");
        alert.setIcon(R.drawable.ic_baseline_info_24);
        alert.setButton("Proceed",new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Yes,You Can Proceed Now", Toast.LENGTH_SHORT).show();
            }
        });
        alert.show();


        //Multiple Button
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Delete?");
        builder.setIcon(R.drawable.ic_baseline_delete_24);
        builder.setMessage("Are You Sure Want To Delete?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Deleted", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Item Not Deleted", Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();



    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder exitAlert = new AlertDialog.Builder(this);
        exitAlert.setIcon(R.drawable.ic_baseline_exit_to_app_24);
        exitAlert.setTitle("Exit?");
        exitAlert.setMessage("Are You Sure?");
        exitAlert.setPositiveButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Welcome Back", Toast.LENGTH_SHORT).show();
            }
        });
        exitAlert.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MainActivity.super.onBackPressed();
            }
        });
        exitAlert.setNeutralButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Operation Canceled", Toast.LENGTH_SHORT).show();
            }
        });
        exitAlert.show();
    }
}