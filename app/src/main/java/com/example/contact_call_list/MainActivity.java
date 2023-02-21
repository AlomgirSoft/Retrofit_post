package com.example.contact_call_list;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.contact_call_list.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {



    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding= ActivityMainBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());


        binding.favoritelayout.setOnClickListener(v->{

            Intent intent = new Intent(MainActivity.this,Favorite.class);
            startActivity(intent);





        });


        binding.contactlayout.setOnClickListener(v->{

            Intent intent = new Intent(MainActivity.this,Contacts_User.class);
            startActivity(intent);


        });



    }
}