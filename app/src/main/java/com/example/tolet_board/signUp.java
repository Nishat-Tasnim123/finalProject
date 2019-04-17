package com.example.tolet_board;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;

public class signUp extends AppCompatActivity {

    private EditText signUpPwEditText,signUpEeditText;
    private Button signUpButton;
    //private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //mAuth = FirebaseAuth.getInstance();

        signUpPwEditText=findViewById(R.id.pwWditText);
        signUpEeditText=findViewById(R.id.editTextEmailid);
        signUpButton=findViewById(R.id.signUpButton);

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }
}
