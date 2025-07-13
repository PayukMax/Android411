package com.example.loginsignapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {
    private EditText loginEmail, loginPassword;
    private Button loginButton;
    private DataBaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginEmail = findViewById(R.id.loginEmail);
        loginPassword = findViewById(R.id.loginPassword);
        loginButton = findViewById(R.id.LoginButton);
        myDb = new DataBaseHelper(this);
        loginUser();


    }

    private void loginUser() {
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = loginEmail.getText().toString();
                String passwd = loginPassword.getText().toString();

                if (email.isEmpty() || passwd.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "All fields are mandatory...", Toast.LENGTH_SHORT).show();
                } else {
                    boolean log = myDb.checkUser(email, passwd);
                    if (log) {
                        Toast.makeText(LoginActivity.this, "Login successfully...", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                        startActivity(intent);

                    } else {
                        Toast.makeText(LoginActivity.this, "Login failure!!!!!", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });
    }
}