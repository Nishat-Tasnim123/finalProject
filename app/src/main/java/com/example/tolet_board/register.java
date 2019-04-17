package com.example.tolet_board;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class register extends AppCompatActivity implements View.OnClickListener {

    //DatabaseHelper databaseHelper;
    //private FirebaseAuth mAuth;
    //private EditText pwEditText,emailEditText;
    //private Button signUpButton;
    private EditText nameEditText, contactnoEditText,emailEditText,pwEditText,cityEditText;
    private Button signUpButton;
    UserDetails userDetails;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nameEditText=(EditText)findViewById(R.id.editTextNameid);
        contactnoEditText=(EditText) findViewById(R.id.editTextcontact_numberid);
        emailEditText=(EditText)findViewById(R.id.editTextEmailid);
        pwEditText=(EditText) findViewById(R.id.pwEditText);
        cityEditText=(EditText)findViewById(R.id.cityEditTextid);
        signUpButton=(Button)findViewById(R.id.signUpButton);

        databaseHelper= new DatabaseHelper(this);
        userDetails =new UserDetails();
        signUpButton.setOnClickListener(this);

        //mAuth = FirebaseAuth.getInstance();


        //pwEditText=findViewById(R.id.pwWditText);
        //emailEditText=findViewById(R.id.editTextEmailid);
        //signUpButton=findViewById(R.id.signUpButton);

        //signUpButton.setOnClickListener(this);

        //databaseHelper = new DatabaseHelper(this);
        //SQLiteDatabase sqLiteDatabase=databaseHelper.getWritableDatabase();
    }


    @Override
    public void onClick(View view) {
        String name=nameEditText.getText().toString();
        String ConNo=contactnoEditText.getText().toString();
        String email=emailEditText.getText().toString();
        String pw=pwEditText.getText().toString();
        String city=cityEditText.getText().toString();

        userDetails.setname(name);
        userDetails.setConNo(ConNo);
        userDetails.setEmail(email);
        userDetails.setPw(pw);
        userDetails.setCity(city);

        long rowId= databaseHelper.saveData(userDetails);

        if(rowId>0)
        {
            Toast.makeText(getApplicationContext(),"Row"+rowId+ " is successfully inserted",Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Row insertion failed",Toast.LENGTH_LONG).show();

        }
        if(view.getId()==R.id.signUpButton){
            Intent signup = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(signup);
            //Intent signup =new Intent(MainActivity.this,register.class);
           // startActivity(signup);

        }
        /*switch (v.getId()){
            case R.id.signUpButton:
                //userRegister();
                //Intent intent = new Intent(getApplicationContext(),post_search.class);
                //startActivity(intent);
                //break;

        }*/
    }

    /*private void userRegister() {

        String email = emailEditText.getText().toString().trim();
        String password = pwEditText.getText().toString().trim();

        if(email.isEmpty()){
            emailEditText.setError("Enter an email");
            emailEditText.requestFocus();
            return;
        }

        if(!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            emailEditText.setError("Enter a valid email");
            emailEditText.requestFocus();
            return;
        }

        if(password.isEmpty()){
            pwEditText.setError("Enter an email");
            pwEditText.requestFocus();
            return;
        }

        if(password.length()<6){
            pwEditText.setError("Enter a valid email");
            pwEditText.requestFocus();
            return;
        }

        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(getApplicationContext(),"Registered",Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(getApplicationContext(),"Not Registered",Toast.LENGTH_LONG).show();
                }
            }
        });
    }*/
}
