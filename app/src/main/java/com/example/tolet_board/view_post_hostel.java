package com.example.tolet_board;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;

public class view_post_hostel extends AppCompatActivity {
    private ListView listView;
    private SearchView searchView;

    private DatabaseHelper2 databaseHelper2;
    private DatabaseHelper databaseHelper;
    ArrayList<String> listData;
    ArrayList<String>listData1;
    String selectedValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_post_hostel);

        listView=findViewById(R.id.listViewid);
        searchView=findViewById(R.id.searchViewID);
        databaseHelper2=new DatabaseHelper2(this);

        //listView.setOnClickListener(this);

        loadData();
    }

    public void loadData()
    {
        listData=new ArrayList<>();
        listData1=new ArrayList<>();

        Cursor cursor=databaseHelper2.showAllData();
        //Cursor cursor1=databaseHelper.showAllData();

        if(cursor.getCount() == 0)
        {
            Toast.makeText(getApplicationContext(),"No data is available in database",Toast.LENGTH_LONG).show();
        }
        else
        {
            while(cursor.moveToNext())
            {
                listData.add(cursor.getString(0)+"."+cursor.getString(1)+"\n"+cursor.getString(5)+"\n"+cursor.getString(3)+" BDT");
                listData1.add(cursor.getString(5));
                //listData.add(Username);
            }
        }


        /*if(cursor1.getCount() == 0)
        {
            Toast.makeText(getApplicationContext(),"No data is available in database",Toast.LENGTH_LONG).show();
        }
        else
        {
            while(cursor1.moveToNext())
            {
                listData.add(cursor1.getString(1)+"\t"+cursor1.getString(2)+"\t"+cursor1.getString(3)+"\t"+cursor1.getString(4)+"\t"+cursor1.getString(4));
                //listData.add(Username);
            }
        }*/

        //listView.setAdapter(adapter1);
        final ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(),R.layout.list_item_hostel,R.id.TextViewUsernameID,listData);
        listView.setAdapter(adapter);
        //final ArrayAdapter<String>adapter1=new ArrayAdapter<String>(getApplicationContext(),R.layout.list_item_hostel,R.id.TextViewUsernameID,listData1);


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //adapter1.getFilter().filter(newText);
                ArrayList<String>cityList1=new ArrayList<>();

                for(String city1: listData)
                {
                    if(city1.toLowerCase().contains(newText.toLowerCase()))
                    {
                        cityList1.add(city1);
                    }
                }
                final ArrayAdapter<String>adapter=new ArrayAdapter<String>(getApplicationContext(),R.layout.list_item_hostel,R.id.TextViewUsernameID,cityList1);
                listView.setAdapter(adapter);



                return false;
            }
        });

        /*listView.setOnItemClickListener(onItemClick(adapterView, view, int i ,l){
            String selectedValue= adapterView.getItemAtPosition(i).toString();
            Toast.makeText(getApplicationContext(),"Selected value: "+selectedValue,Toast.LENGTH_LONG).show();
    });*/
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Cursor cursor=databaseHelper2.showAllData();
                selectedValue=listView.getItemAtPosition(position).toString();
                int count = (int) listView.getItemIdAtPosition(position);
                String[] parts=selectedValue.split("\\.");
                String beforeFirstDot=parts[0];


                Bundle bundle =new Bundle();
                bundle.putString("selectedvalue",beforeFirstDot);

                while(cursor.moveToNext())
                {
                    if(beforeFirstDot.equals(cursor.getString(0)))
                    {
                        //Toast.makeText(getApplicationContext(),cursor.getString(1)+"\n"+cursor.getString(5)+"\n"+cursor.getString(3)+" BDT",Toast.LENGTH_LONG).show();
                        Intent intent =new Intent(view_post_hostel.this,show_description_hostel.class);
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }
                }
                //Intent intent =new Intent(view_posts.this,show_description.class);
                //startActivity(intent);

            }
        });

        /*listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedValue= AdapterView.getItemAtPosition().toString();
                Toast.makeText(getApplicationContext(),"Selected value: "+selectedValue,Toast.LENGTH_LONG).show();

            }
        });*/


    }

    /*@Override
    public void onClick(View v) {

    }*/

   /* public void onClick(View v) {
        String selecedValue =adapterView.getItemAtPosition(),toString();
        Toast.makeText(getApplicationContext(),"Selected value: " );

    }*/
}