package com.example.contact_call_list;

import static android.net.Uri.parse;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.Toast;

import java.util.ArrayList;

public class Contacts_User extends AppCompatActivity {


    ArrayList<Call_Model>call_list = new ArrayList<>();

    RecyclerView recyclerView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        recyclerView = findViewById(R.id.recyclerview);

        checkPermission();

    }
    //======================================================
    private void checkPermission() {

        if (ContextCompat.checkSelfPermission(Contacts_User.this, Manifest.permission.READ_CONTACTS)!= PackageManager.PERMISSION_GRANTED){

            ActivityCompat.requestPermissions(Contacts_User.this,new String[]{Manifest.permission.READ_CONTACTS},100);
        }else {
            getContactlist();
        }


    }
    //======================================================
    private void getContactlist() {
        Uri uri = ContactsContract.Contacts.CONTENT_URI;

      String strot=  ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME+"ASC";

        Cursor cursor =getContentResolver().query(uri,null,null,null,null);

  if (cursor.getCount()>0){



      while (cursor.moveToNext()){


     String id= cursor.getString(cursor.getColumnIndexOrThrow(ContactsContract.Contacts._ID));
     String name = cursor.getString(cursor.getColumnIndexOrThrow(ContactsContract.Contacts.DISPLAY_NAME));


     Uri uriPhone= parse(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME);
     String selection= ContactsContract.CommonDataKinds.Phone.CONTACT_ID+"=?";

     Cursor cursorphone= getContentResolver().query(uriPhone,null,selection,new String[]{id},null);


     if (cursorphone.moveToNext()){
         String number= cursorphone.getString(cursorphone.getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone.NUMBER));


         Call_Model model = new Call_Model();

         model.setName(name);
         model.setPhone(number);

         call_list.add(model);

         cursorphone.close();
     }

      }
      cursor.close();
  }
recyclerView.setLayoutManager(new LinearLayoutManager(this));

  Call_Adepter adepter = new Call_Adepter(this,call_list);
  recyclerView.setAdapter(adepter);
    }
    //======================================================


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);


        if (requestCode==100 && grantResults.length>0 && grantResults[0]== PackageManager.PERMISSION_GRANTED){
            getContactlist();
        }else {
            Toast.makeText(Contacts_User.this,"done", Toast.LENGTH_LONG).show();
            checkPermission();
        }
    }

    //============================================
}