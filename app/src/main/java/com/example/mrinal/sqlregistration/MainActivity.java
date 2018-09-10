package com.example.mrinal.sqlregistration;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText phoneNumber,yourName,email;
    String userName,userPhone,userEmail;
    SQLiteDatabase myDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConstraintLayout layout=(ConstraintLayout)findViewById(R.id.layout);

        layout.setOnClickListener(this);

    }

    public void registerUser(View view){

        phoneNumber=(EditText)findViewById(R.id.phoneEditText);
        yourName=(EditText)findViewById(R.id.nameEditText);
        email=(EditText)findViewById(R.id.emailEditText);

        userName=yourName.getText().toString();
        userEmail=email.getText().toString();
        userPhone=phoneNumber.getText().toString();

        try{

            myDatabase=this.openOrCreateDatabase("Registered Members",MODE_PRIVATE,null);

            myDatabase.execSQL("CREATE TABLE IF NOT EXISTS registeredMembers(name VARCHAR, email VARCHAR, phone VARCHAR)");

            String sqlCommand="INSERT INTO registeredMembers(name, email, phone) VALUES('"+userName+"','"+userEmail+"','"+userPhone+"'"+")";
            myDatabase.execSQL(sqlCommand);

        }catch(Exception e){

        }

        Intent intent=new Intent(getApplicationContext(),Main2Activity.class);
        startActivity(intent);

    }

    public void onClick(View view) {

        if(view.getId()==R.id.layout){

            InputMethodManager imm=(InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),0);

        }

    }

}
