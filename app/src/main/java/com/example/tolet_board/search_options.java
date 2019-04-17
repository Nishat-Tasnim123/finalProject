package com.example.tolet_board;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class search_options extends AppCompatActivity implements View.OnClickListener{
    private CardView searchhomeCardView,searchhostelCardView,searchshopCardView,searchofficeCardView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_options);

        searchhomeCardView=findViewById(R.id.SearchHomeCradViewID);
        searchhostelCardView=findViewById(R.id.SearchHostelCradViewID);
        searchshopCardView=findViewById(R.id.SearchShopCradViewID);
        searchofficeCardView=findViewById(R.id.SearchOfficeCradViewID);

        searchhomeCardView.setOnClickListener(this);
        searchhostelCardView.setOnClickListener(this);
        searchshopCardView.setOnClickListener(this);
        searchofficeCardView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.SearchHomeCradViewID)
        {
            Intent home = new Intent(getApplicationContext(),view_posts.class);
            startActivity(home);

        }
        else if(v.getId()==R.id.SearchHostelCradViewID)
        {
            Intent home = new Intent(getApplicationContext(),view_post_hostel.class);
            startActivity(home);

        }
        else if(v.getId()==R.id.SearchOfficeCradViewID)
        {
            Intent home = new Intent(getApplicationContext(),view_post_office.class);
            startActivity(home);

        }
    }
}
