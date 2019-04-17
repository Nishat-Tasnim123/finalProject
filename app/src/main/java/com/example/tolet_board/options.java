package com.example.tolet_board;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;

public class options extends AppCompatActivity implements View.OnClickListener{
    private CardView homeCardView,hostelCardView,shopCardView,officeCardView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        homeCardView=findViewById(R.id.homeCradViewID);
        hostelCardView=findViewById(R.id.hostelCradViewID);
        shopCardView=findViewById(R.id.shopCradViewID);
        officeCardView=findViewById(R.id.officeCradViewID);

        homeCardView.setOnClickListener(this);
        hostelCardView.setOnClickListener(this);
        shopCardView.setOnClickListener(this);
        officeCardView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.homeCradViewID)
        {
            Intent home = new Intent(getApplicationContext(),home_post.class);
            startActivity(home);

        }
        else if(v.getId()==R.id.hostelCradViewID)
        {
            Intent mess = new Intent(getApplicationContext(),hostel_post.class);
            startActivity(mess);

        }
        else if(v.getId()==R.id.shopCradViewID)
        {
            Intent shop = new Intent(getApplicationContext(),shop_post.class);
            startActivity(shop);

        }
        else if(v.getId()==R.id.officeCradViewID)
        {
            Intent office = new Intent(getApplicationContext(),office_post.class);
            startActivity(office);

        }


    }
}
