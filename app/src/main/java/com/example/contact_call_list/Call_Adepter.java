package com.example.contact_call_list;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Call_Adepter extends RecyclerView.Adapter<Call_ViewHolder> {

    private Context context;
    private ArrayList<Call_Model>call_list;

    @SuppressLint("NotifyDataSetChanged")
    public Call_Adepter(Context context, ArrayList<Call_Model> call_list) {
        this.context = context;
        this.call_list = call_list;

        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public Call_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.call_item_list,parent,false);
        return new Call_ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Call_ViewHolder holder, int position) {


        Call_Model model= call_list.get(position);


        holder.name.setText(model.getName());
        holder.phoneNumber.setText(model.getPhone());







    }

    @Override
    public int getItemCount() {
        return call_list.size();



    }
}
