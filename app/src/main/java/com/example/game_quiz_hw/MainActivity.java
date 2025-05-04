package com.example.game_quiz_hw;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN); //убираем верхнюю строку состояния
        SharedPreferences sharedPreferences;
        Button btnLogout = findViewById(R.id.btn_logout);
        TextView firstText = findViewById(R.id.first_text);


        sharedPreferences = getSharedPreferences("myhwpref", MODE_PRIVATE); // создаем файл с именем и правами только из этого приложения, MOD_WORD_WR....
        String name = sharedPreferences.getString("name", null); // читаем имя ну и так далее что ранее сохранили
        if (name == null) {
            Intent intent = new Intent(MainActivity.this, Register.class); // сначала указываем текущее ативити.this после запятой то в которую хотим нырнуть - обязательно должнабыть объявоена в манифесте
            startActivity(intent);
        } else {
            firstText.setText(name);

        }

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.apply();
                finish();
            }
        });


    }
}