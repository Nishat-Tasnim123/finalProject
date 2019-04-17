package com.example.tolet_board;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
//import android.view.View;
//import android.widget.AdapterView;
//import android.view.View;
//import android.widget.AdapterView;
//import android.view.View;
//import android.widget.AdapterView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;
import android.widget.Toolbar;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class view_posts extends AppCompatActivity {

    private ListView listView;
    private SearchView searchView;

    private DatabaseHelper3 databaseHelper3;
    private DatabaseHelper databaseHelper;
    ArrayList<String>listData;
    ArrayList<String>listData1;
    String selectedValue;

   // private AdapterView adapterView;
    //private AdapterView adapterView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_posts);


        listView=findViewById(R.id.listViewid);
        searchView=findViewById(R.id.searchViewID);
        databaseHelper3=new DatabaseHelper3(this);

        //listView.setOnClickListener(this);

        loadData();

        /*Bundle bundle =getIntent().getExtras();

        arrayList=new ArrayList<String>();

        if(bundle!=null){
            String value1=bundle.getString("address");
            String value2=bundle.getString("phone_number");
            arrayList.add(value1);
            arrayList.add(value2);

            //textview1.setText(value2);
        }



        ArrayAdapter<String>adapter=new ArrayAdapter<String>(getApplicationContext(),R.layout.activity_sample,R.id.sampleTextViewid,arrayList);
        listView.setAdapter(adapter);*/
    }

   // @Override
    /*public boolean onCreateOptionsMenu(Menu menu) {
        //MenuInflater inflater=getMenuInflater();
        //inflater.inflate(R.menu.list_item.);
        return super.onCreateOptionsMenu(menu);
    }*/

    public void loadData()
    {
        listData=new ArrayList<>();
        listData1=new ArrayList<>();

        Cursor cursor=databaseHelper3.showAllData();
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

        //final ArrayAdapter<String>adapter=new ArrayAdapter<String>(getApplicationContext(),R.layout.list_item ,R.id.TextViewUsernameID,listData);

        final ArrayAdapter<String>adapter1=new ArrayAdapter<String>(getApplicationContext(),R.layout.list_item,R.id.TextViewUsernameID,listData);
        listView.setAdapter(adapter1);



        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //final ArrayAdapter<String>adapter1=new ArrayAdapter<String>(getApplicationContext(),R.layout.list_item,R.id.TextViewUsernameID,listData1);

                //listView.setAdapter(adapter1);
                //adapter1.getFilter().filter(newText);
                //listView.setAdapter(adapter);


                ArrayList<String>cityList=new ArrayList<>();

                for(String city: listData)
                {
                    if(city.toLowerCase().contains(newText.toLowerCase()))
                    {
                        cityList.add(city);
                    }
                }
                final ArrayAdapter<String>adapter=new ArrayAdapter<String>(getApplicationContext(),R.layout.list_item,R.id.TextViewUsernameID,cityList);
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
                Cursor cursor=databaseHelper3.showAllData();
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
                        Intent intent =new Intent(view_posts.this,show_description.class);
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
