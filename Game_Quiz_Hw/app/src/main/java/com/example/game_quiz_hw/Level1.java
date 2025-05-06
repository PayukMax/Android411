package com.example.game_quiz_hw;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;



import java.util.Objects;
import java.util.Random;

public class Level1 extends AppCompatActivity {
    Dialog dialog;
    Dialog dialogEnd;

    public int numLeft, numRight; // переменная для левой картинки + правой картинки

//    Array array = new Array();
//    Random random = new Random();
    public int count = 0; // счетчик правильных ответов

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.universal);
        TextView textLevels = findViewById(R.id.textView);
        textLevels.setText(R.string.level1);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN); //убираем верхнюю строку состояния

        final ImageView imgLeft = findViewById(R.id.img_left);
        final ImageView imgRight = findViewById(R.id.img_roght);

        imgLeft.setClipToOutline(true); // скругляем углы - к картинке применилась маска фона (на фон перед этим установился background со скругленными углами )
        imgRight.setClipToOutline(true);

        final TextView textLeft = findViewById(R.id.textLeft);
        final TextView textRight = findViewById(R.id.textRight);

        // вызыываем диалоговое окно в начале игры
        dialog = new Dialog(this); // создаем новое диалоговое окно в этом же активити
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // скрываем заголовок
        dialog.setContentView(R.layout.preview_dialog); // указываем шаблон диалогового окна
        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT)); // добавляем прозрачный фон диалогового окна
        dialog.setCancelable(false); // запрещаем закрытие окна кликом зе пределами диалогового окна

        TextView btnClose = dialog.findViewById(R.id.button_close);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Level1.this, MainActivity.class);
                startActivity(intent);
                dialog.dismiss(); // закрытие диалогового окна
            }
        });

        Button btnContinue = dialog.findViewById(R.id.button_continue);
        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show(); // собственно отобразить диалоговое окно

        Button btnBackMain = findViewById(R.id.button_back_level1);
        btnBackMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Level1.this, MainActivity.class);
                startActivity(intent);

            }
        });

    }
}
