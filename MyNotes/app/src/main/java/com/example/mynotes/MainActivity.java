package com.example.mynotes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnCreateNote;
    FloatingActionButton fabAdd;
    RecyclerView recyclerNotes;
    public DBHelper dbHelper;
    LinearLayout noNotes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initVar();
        showNotes();

        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.add_note_lay);

                EditText edtTitle,edtContent;
                Button btnAdd;



                edtTitle = dialog.findViewById(R.id.edtTitle);
                edtContent = dialog.findViewById(R.id.edtContent);
                btnAdd = dialog.findViewById(R.id.btnAdd);

                btnAdd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String title=edtTitle.getText().toString();
                        String content = edtContent.getText().toString();
                        
                        if (!content.equals("")){

                            dbHelper.noteDao().addNote(new Note(title,content));

                            showNotes();

                            dialog.dismiss();

                        }else{
                            Toast.makeText(MainActivity.this, "Please Enter Something", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                dialog.show();

            }
        });
        btnCreateNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fabAdd.performClick();
            }
        });

    }
    public void showNotes() {
        ArrayList<Note> arrNotes = (ArrayList<Note>) dbHelper.noteDao().getNotes();
        if (arrNotes.size()>0){
            noNotes.setVisibility(View.GONE);
            recyclerNotes.setVisibility(View.VISIBLE);
            RecyclerAdapter ad = new RecyclerAdapter(this,arrNotes,dbHelper);
            recyclerNotes.setAdapter(ad);
        }
        else{
            noNotes.setVisibility(View.VISIBLE);
            recyclerNotes.setVisibility(View.GONE);
        }
    }
    private void initVar() {
        btnCreateNote = findViewById(R.id.btnCreateNote);
        fabAdd = findViewById(R.id.fabAdd);
        recyclerNotes = findViewById(R.id.recyclerNotes);
        noNotes = findViewById(R.id.noNotes);
        recyclerNotes.setLayoutManager(new GridLayoutManager(this,2));
        dbHelper=DBHelper.getInstance(this);
    }
}