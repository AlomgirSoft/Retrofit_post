package com.example.contact_call_list;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import de.hdodenhof.circleimageview.CircleImageView;

public class Call_ViewHolder extends RecyclerView.ViewHolder {
    TextView name, phoneNumber;
    CircleImageView circleImageView;
    ImageView callImage;


    public Call_ViewHolder(@NonNull View itemView) {
        super(itemView);


        name= itemView.findViewById(R.id.name);
        phoneNumber = itemView.findViewById(R.id.phoneNumber);
        callImage = itemView.findViewById(R.id.callImage);
        circleImageView= itemView.findViewById(R.id.image);



    }
}
