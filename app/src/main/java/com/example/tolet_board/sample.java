package com.example.tolet_board;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class sample extends AppCompatActivity {

    private TextView textview,textView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);
        Bundle bundle =getIntent().getExtras();

        textview=findViewById(R.id.sampleTextViewid);

        if(bundle!=null){
            String value1=bundle.getString("address");
            String value2=bundle.getString("phone_number");
            //textview.setText(value1);
            //textview1.setText(value2);
        }
    }
}
