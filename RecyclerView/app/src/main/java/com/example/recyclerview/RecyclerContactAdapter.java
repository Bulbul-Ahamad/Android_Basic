package com.example.recyclerview;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerContactAdapter extends RecyclerView.Adapter<RecyclerContactAdapter.ViewHolder>{
    Context context;
    ArrayList<ContactModel> arrayContact;
    private int lastposition = -1;
    RecyclerContactAdapter(Context context , ArrayList<ContactModel> arrayContact ){
        this.context = context;
        this.arrayContact = arrayContact;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.contact_row,parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.imgcontact.setImageResource(arrayContact.get(position).img);
        holder.txtname.setText(arrayContact.get(position).name);
        holder.txtnum.setText(arrayContact.get(position).number);
        setAnimation(holder.itemView,position);
        holder.row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.add_update);

                EditText edtname = dialog.findViewById(R.id.edtname);
                EditText edtnum = dialog.findViewById(R.id.edtnum);
                Button btnaction = dialog.findViewById(R.id.btnaction);
                TextView txtitle = dialog.findViewById(R.id.txtitle);

                txtitle.setText("Update Contact");
                btnaction.setText("Update");
                edtname.setText((arrayContact.get(position)).name);
                edtnum.setText((arrayContact.get(position)).number);



                btnaction.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String name="",num="";
                        if (!edtname.getText().toString().equals("")) {
                            name = edtname.getText().toString();
                        }
                        else{
                            Toast.makeText(context, "Please Enter Contact Name", Toast.LENGTH_SHORT).show();
                        }
                        if (!edtnum.getText().toString().equals("")) {
                            num = edtnum.getText().toString();
                        }
                        else{
                            Toast.makeText(context, "Please Enter Contact Number", Toast.LENGTH_SHORT).show();
                        }
                        arrayContact.set(position,new ContactModel(arrayContact.get(position).img,name,num));
                        notifyItemChanged(position);
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });
        holder.row.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Builder builder = new AlertDialog.Builder(context).setTitle("Delete Contact").setMessage("Are You Sure Want To Delete?").setIcon(androidx.constraintlayout.widget.R.drawable.notification_icon_background).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        arrayContact.remove(position);
                        notifyItemRemoved(position);
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.show();

                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayContact.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtname,txtnum;
        ImageView imgcontact;
        LinearLayout row;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtname = itemView.findViewById(R.id.txtname);
            txtnum = itemView.findViewById(R.id.txtnum);
            imgcontact = itemView.findViewById(R.id.imgcontact);
            row = itemView.findViewById(R.id.row);

        }
    }
    private void setAnimation(View viewToanimate,int position){
        if (position>lastposition) {
            Animation slideIn = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
            viewToanimate.startAnimation(slideIn);
            lastposition = position;
        }
    }
}
