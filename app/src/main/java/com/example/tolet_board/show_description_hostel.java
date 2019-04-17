package com.example.tolet_board;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class show_description_hostel extends AppCompatActivity {
    private DatabaseHelper2 databaseHelper2;
    TextView monthTextview,rentTextview,categoryTextview,phonenumberTextView,locationTextView,descriptionTextView;
    ListView listView;
    ArrayList<String> listData;
    Cursor cursor;
    view_posts obj;
    String value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_description_hostel);

        monthTextview=findViewById(R.id.monthID);
        rentTextview=findViewById(R.id.rentID);
        categoryTextview=findViewById(R.id.categoryID);
        phonenumberTextView=findViewById(R.id.TextViewPhoneNumberID);
        locationTextView=findViewById(R.id.TextViewLocationID);
        descriptionTextView=findViewById(R.id.TextViewDescriptionID);

        listView=findViewById(R.id.listViewid);


        databaseHelper2 = new DatabaseHelper2(this);
        obj=new view_posts();

        loadData();
    }



    public void loadData() {
        cursor = databaseHelper2.showAllData();
        listData=new ArrayList<>();
        Bundle bundle=getIntent().getExtras();
        value=bundle.getString("selectedvalue");


        if (cursor.getCount() == 0) {
            Toast.makeText(getApplicationContext(), "No data is available in database", Toast.LENGTH_LONG).show();
        } else {
            while (cursor.moveToNext()) {
                //listData.add(cursor.getString(1) + "\n" + cursor.getString(5) + "\n" + cursor.getString(3) + " BDT");
                if(value.equals(cursor.getString(0)))
                {
                    monthTextview.setText("Month\n"+cursor.getString(4) );
                    //monthTextview.setText(value);
                    rentTextview.setText("Rent\n"+cursor.getString(3)+" BDT");
                    categoryTextview.setText("Category\n"+cursor.getString(2) );
                    phonenumberTextView.setText(cursor.getString(6) );
                    locationTextView.setText(cursor.getString(5) );
                    descriptionTextView.setText(cursor.getString(7) );
                }

            }
        }


    }
}
