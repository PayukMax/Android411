package com.example.second;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Hw2903 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hw2903);
        boolean flag = false;
        ImageView img = findViewById(R.id.hwImageView);
        Button btn = findViewById(R.id.button4);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ttt=btn.getText().toString();
                if (ttt.equals("Запускаем отсчет...")) {
                    ((AnimationDrawable) img.getDrawable()).start();
                    btn.setText("Останавливаем отсчет...");
                } else {
                    ((AnimationDrawable) img.getDrawable()).stop();
                    btn.setText("Запускаем отсчет...");
                }
            }
        });


    }
}