package com.example.game_quiz_hw;

//import static com.example.game_quiz_hw.MainActivity.KEY_NAME;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN); //убираем верхнюю строку состояния

        Button btnSave = findViewById(R.id.btnSaveReg);
        EditText name_user = findViewById(R.id.name_field);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = name_user.getText().toString();
                if (name.isEmpty()){
                    Toast.makeText(Register.this, "Enter name please...", Toast.LENGTH_SHORT).show();
                } else {
                    SharedPreferences sharedPreferences = getSharedPreferences("myhwpref", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("name",name);
                    editor.apply();
                    Intent intent = new Intent(Register.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });

    }
}