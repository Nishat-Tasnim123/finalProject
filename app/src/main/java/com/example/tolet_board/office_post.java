package com.example.tolet_board;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class office_post extends AppCompatActivity implements View.OnClickListener{

    private EditText address,phonenumber,title,rent,month,description,ownername;
    private Button home_postButton;
    private DatabaseHelper4 databaseHelper4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hostel_post);

        databaseHelper4=new DatabaseHelper4(this);
        SQLiteDatabase sqLiteDatabase= databaseHelper4.getWritableDatabase();

        ownername=findViewById(R.id.ownernamehomeID);
        title=findViewById(R.id.titlehomeID);
        rent=findViewById(R.id.flatRentID);
        month=findViewById(R.id.monthflatID);
        address=findViewById(R.id.phonenumberflatID);
        phonenumber=findViewById(R.id.addressflatID);
        description=findViewById(R.id.descriptionflatID);
        home_postButton=findViewById(R.id.home_postButtonId);

        home_postButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String Ownername=ownername.getText().toString();
        String Title=title.getText().toString();
        String Rent=rent.getText().toString();
        String Month=month.getText().toString();
        String phone_Number=phonenumber.getText().toString();
        String location=address.getText().toString();
        String Description=description.getText().toString();
        if(v.getId()==R.id.home_postButtonId) {

            if (Ownername.equals("") && Title.equals("") && Rent.equals("") && Month.equals("") && phone_Number.equals("") && location.equals("") && Description.equals("")) {
                Toast.makeText(getApplicationContext(), "Please enter all the data", Toast.LENGTH_LONG).show();

            } else {
                //databaseHelper1.saveData(phone_Number,location);
                long rowId = databaseHelper4.saveData(Ownername,Title,Rent,Month,phone_Number, location,Description);

                if (rowId > -1) {
                    Toast.makeText(getApplicationContext(), "Row" + rowId + " is successfully inserted", Toast.LENGTH_LONG).show();
                    ownername.setText("");
                    title.setText("");
                    rent.setText("");
                    month.setText("");
                    phonenumber.setText("");
                    address.setText("");
                    description.setText("");

                } else {
                    Toast.makeText(getApplicationContext(), "Row insertion failed", Toast.LENGTH_LONG).show();

                }


            }


            Intent intent = new Intent(getApplicationContext(), view_post_office.class);
            //intent.putExtra("address",address.getText().toString());
            //intent.putExtra("phone_number",phonenumber.getText().toString());
            startActivity(intent);

        }
    }
}
