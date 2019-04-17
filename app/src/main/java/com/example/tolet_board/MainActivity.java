package com.example.tolet_board;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button  signupButtonMain,signinButtonMain;
    private EditText usernameEditText, passwordEditText;
    public String username;
    DatabaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        signupButtonMain =(Button) findViewById(R.id.signUpButtonId);
        signinButtonMain= (Button)findViewById(R.id.SignInButtonid);

        usernameEditText=(EditText)findViewById(R.id.editTextUsernameid) ;
        passwordEditText=(EditText)findViewById(R.id.editTextPasswordid);

        databaseHelper= new DatabaseHelper(this);



        /*signinButtonMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signup = new Intent(getApplicationContext(),options.class);
                startActivity(signup);
            }
        });*/


        /*signupButtonMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signup = new Intent(getApplicationContext(),post_search.class);
                startActivity(signup);
            }
        });*/
        signinButtonMain.setOnClickListener(this);
        signupButtonMain.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        username= usernameEditText.getText().toString();
        String password= passwordEditText.getText().toString();

        //Bundle bundle =new Bundle();
        //bundle.putString("Username",username);

        //Intent intent =new Intent(MainActivity.this,view_my_posts.class);
        //intent.putExtras(bundle);
        //startActivity(intent);

        if(view.getId()==R.id.SignInButtonid){
            //Intent signin = new Intent(getApplicationContext(),post_search.class);
            //startActivity(signin);
            Boolean result = databaseHelper.findPassword(username,password);
            if(result==true)
            {
                //Bundle bundle1 =new Bundle();
                //bundle1.putString("Username",username);

                //Intent intent =new Intent(MainActivity.this,view_my_posts.class);
                //intent.putExtras(bundle1);
                Intent signin=new Intent(MainActivity.this,post_search.class);
                startActivity(signin);
            }
            else
            {
                Toast.makeText(getApplicationContext(),"Username and Password didn't match",Toast.LENGTH_LONG).show();
            }

        }
        else if(view.getId()==R.id.signUpButtonId){
            //Intent signup = new Intent(getApplicationContext(),register.class);
            //startActivity(signup);
            Intent signup =new Intent(MainActivity.this,register.class);
            startActivity(signup);

        }

    }
}
