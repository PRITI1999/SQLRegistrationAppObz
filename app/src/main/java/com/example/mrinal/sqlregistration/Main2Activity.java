package com.example.mrinal.sqlregistration;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    ListView listView;
    SQLiteDatabase myDatabase;
    ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent=getIntent();

        listView=(ListView)findViewById(R.id.listView);

        ArrayList<String> myData=new ArrayList<String>();

        try{

            myDatabase = this.openOrCreateDatabase("Registered Members", MODE_PRIVATE, null);

            Cursor c=myDatabase.rawQuery("SELECT * FROM registeredMembers" ,null);

            int nameIndex=c.getColumnIndex("name");
            int phoneIndex=c.getColumnIndex("phone");
            int emailIndex=c.getColumnIndex("email");
            c.moveToFirst();

            while(c!=null){

                myData.add("Registration details:\nName : "+c.getString(nameIndex)+
                        "\nPhone : "+c.getString(phoneIndex)+
                        "\nEmail : "+c.getString(emailIndex));

                Log.i("Name:",c.getString(nameIndex));
                Log.i("Phone:",c.getString(phoneIndex));
                Log.i("Email:",c.getString(emailIndex));

                arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,myData);

                listView.setAdapter(arrayAdapter);

                c.moveToNext();

            }



        }
        catch (Exception e){

        }

    }
}
