package com.example.loginsignapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SignUpActivity extends AppCompatActivity {
private EditText emailSignUp, passwordSignUp, passwordConfirmSignUp;
private Button signUpButton;
private DataBaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        emailSignUp = findViewById(R.id.signUpEmail);
        passwordSignUp = findViewById(R.id.signUpPassword);
        passwordConfirmSignUp = findViewById(R.id.signUpConfirmPassword);
        signUpButton = findViewById(R.id.signUpButton);

        myDb = new DataBaseHelper(this);
        insertUser();



    }

    private void insertUser(){

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailSignUp.getText().toString();
                String password = passwordSignUp.getText().toString();
                String conf_passw = passwordConfirmSignUp.getText().toString();
                if (email.isEmpty()|| password.isEmpty()||conf_passw.isEmpty()){
                    Toast.makeText(SignUpActivity.this, "All fields are mandatory...", Toast.LENGTH_SHORT).show();
                } else {
                    if (password.equals(conf_passw)){
                        boolean checkUserEmail = myDb.checkEmail(email);
                        if(!checkUserEmail){
                            boolean insert = myDb.registerUser(email,password);
                            if (insert){
                                Toast.makeText(SignUpActivity.this, "User registration complete...", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                                startActivity(intent);
                            } else
                                Toast.makeText(SignUpActivity.this, "User registration ERROR!!!", Toast.LENGTH_SHORT).show();
                        } else Toast.makeText(SignUpActivity.this, "User already exists, Please login...", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(SignUpActivity.this, "Invalid password...", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}