package com.example.mynotes;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>{
    Context context;
    ArrayList<Note> arrNotes = new ArrayList<>();
    DBHelper dbHelper;
    RecyclerAdapter(Context context,ArrayList<Note>arrNotes,DBHelper dbHelper){
        this.context = context;
        this.arrNotes = arrNotes;
        this.dbHelper=dbHelper;
    }
    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.note_row,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.txtTitle.setText(arrNotes.get(position).getTitle());
        holder.txtContent.setText(arrNotes.get(position).getContent());

        holder.deleteNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteItem(position);
            }
        });

        holder.llrow.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                deleteItem(position);
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrNotes.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtTitle,txtContent;
        LinearLayout llrow;
        ImageButton deleteNotes;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.txtTitle);
            txtContent = itemView.findViewById(R.id.txtContent);
            llrow = itemView.findViewById(R.id.llrow);
            deleteNotes = itemView.findViewById(R.id.deleteNotes);
        }
    }
    public void deleteItem(int pos){
        AlertDialog dialog = new AlertDialog.Builder(context)
                .setTitle("Delete")
                .setMessage("Are You Sure Want To Delete")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dbHelper.noteDao().deleteNote(new Note(arrNotes.get(pos).getId(),arrNotes.get(pos).getTitle(),arrNotes.get(pos).getContent()));
                        ((MainActivity)context).showNotes();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .show();
    }
}
