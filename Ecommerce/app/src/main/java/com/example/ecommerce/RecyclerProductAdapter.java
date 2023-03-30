package com.example.ecommerce;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerProductAdapter extends RecyclerView.Adapter<RecyclerProductAdapter.ViewHolder> {
    int coun = 0;
    Context context;
    ArrayList<ProductList> arrayList;
    RecyclerProductAdapter(Context context , ArrayList<ProductList> arrayList){
        this.context = context;
        this.arrayList = arrayList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.layout_product,parent,false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imgpro.setImageResource(arrayList.get(position).img);
        holder.proname.setText(arrayList.get(position).name);
        holder.propri.setText(arrayList.get(position).price);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgpro;
        TextView propri,proname;
        ImageButton imageButton;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            proname = itemView.findViewById(R.id.proname);
            propri = itemView.findViewById(R.id.propri);
            imgpro = itemView.findViewById(R.id.imgpro);
            imageButton = itemView.findViewById(R.id.imageButton);
            imageButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (coun == 0){
                                        imageButton.setImageResource(android.R.drawable.star_big_on);
                                        coun++;
                            }
                            else if (coun == 1){
                                        imageButton.setImageResource(android.R.drawable.star_big_off);
                                        coun--;
                            }
                        }
                    });
        }
    }

}
