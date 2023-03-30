package com.example.jsonparse;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
//import android.view.animation.Animation;
//import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    Context context;
    ArrayList<List> listArrayList;
//    private int lastposition =-1;
    MyAdapter(Context context,ArrayList<List> listArrayList){
    this.context = context;
    this.listArrayList = listArrayList;
}
    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.row,parent,false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder holder, int position) {
        holder.txtId.setText(listArrayList.get(position).id);
        holder.txtName.setText(listArrayList.get(position).name);

    }

    @Override
    public int getItemCount() {
        return listArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtId,txtName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtId = itemView.findViewById(R.id.txtId);
            txtName = itemView.findViewById(R.id.txtName);
        }
    }}
