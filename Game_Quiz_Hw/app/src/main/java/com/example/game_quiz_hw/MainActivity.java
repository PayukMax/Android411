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
        TextView pointsText = findViewById(R.id.points);

        Button btnGame1 = findViewById(R.id.btn_game1);
        Button btnGame2 = findViewById(R.id.btn_game2);
        Button btnGame3 = findViewById(R.id.btn_game3);
        Button btnGame4 = findViewById(R.id.btn_game4);

        btnGame1.setEnabled(false);
        btnGame2.setEnabled(false);
        btnGame3.setEnabled(false);
        btnGame4.setEnabled(false);


        sharedPreferences = getSharedPreferences("myhwpref", MODE_PRIVATE); // создаем файл с именем и правами только из этого приложения, MOD_WORD_WR....
        String name = sharedPreferences.getString("name", null); // читаем имя ну и так далее что ранее сохранили
        int points = sharedPreferences.getInt("points", 0);
        int levels = sharedPreferences.getInt("Level", 1);
        if (name == null) {
            Intent intent = new Intent(MainActivity.this, Register.class); // сначала указываем текущее ативити.this после запятой то в которую хотим нырнуть - обязательно должнабыть объявоена в манифесте
            startActivity(intent);
        } else {
            firstText.setText(name);
            pointsText.setText(points + " points...");
        }
        // теперь блокируем кнопки согласно открытого уровня
        switch (levels) {
            case 4:
                btnGame4.setEnabled(true);
            case 3:
                btnGame3.setEnabled(true);
            case 2:
                btnGame2.setEnabled(true);
            case 1:
                btnGame1.setEnabled(true);
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

        btnGame1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Level1.class);
                startActivity(intent);
            }
        });

        btnGame2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Level2.class);
                startActivity(intent);
            }
        });

        btnGame3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Level1.class);
                startActivity(intent);
            }
        });

        btnGame4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Level1.class);
                startActivity(intent);
            }
        });


    }
}