package com.example.tolet_board;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class post_search extends AppCompatActivity implements View.OnClickListener{
    private Button postButton,searchButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_search);

        postButton=findViewById(R.id.postButtonid);
        searchButton=findViewById(R.id.searchButtonid);
        //searchMyPostsButton=findViewById(R.id.searchMyPostButtonid);

        //searchMyPostsButton.setOnClickListener(this);
        postButton.setOnClickListener(this);
        searchButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //Intent post = new Intent(getApplicationContext(),options.class);
        //startActivity(post);
        if(v.getId()==R.id.postButtonid)
        {
            Intent post = new Intent(getApplicationContext(),options.class);
            startActivity(post);
        }
        else if(v.getId()==R.id.searchButtonid)
        {
            Intent search = new Intent(getApplicationContext(),search_options.class);
            startActivity(search);
        }

    }
}
