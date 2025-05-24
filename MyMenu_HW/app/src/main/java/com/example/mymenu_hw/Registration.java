package com.example.mymenu_hw;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.BufferedReader;

public class Registration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        Button regClear = findViewById(R.id.btn_clear);
        Button regBack = findViewById(R.id.btn_back);
        Button regSave = findViewById(R.id.reg_save);
        EditText userName = findViewById(R.id.user_name);
        Switch swMenu = findViewById(R.id.switch1);


        regBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Registration.this, "!!!!!!!!!!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Registration.this, MainActivity.class);
                startActivity(intent);
            }
        });

        regClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userName.setText("");
                swMenu.setChecked(false);
                SharedPreferences sharedPreferences = getSharedPreferences("myhwmenu", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("name",null);
                editor.putBoolean("menumode",swMenu.isChecked());
                editor.apply();
            }
        });

        regSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!userName.getText().isEmpty()){
                    SharedPreferences sharedPreferences = getSharedPreferences("myhwmenu", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("name",userName.getText().toString());
                    editor.putBoolean("menumode",swMenu.isChecked());
                    editor.apply();
                } else {
                    Toast.makeText(Registration.this, "!!!!!!!!!!", Toast.LENGTH_SHORT).show();} // иначе влепим TOAST что поле имя не должно быть пустым
            }
        });



    }
}