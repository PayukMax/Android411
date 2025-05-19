package com.example.game_quiz_hw;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;
import java.util.Random;

public class Level2 extends AppCompatActivity {

    Dialog dialog;
    Dialog dialogEnd;

    public int numLeft; // переменная для левой картинки + текст
    public int numRight;

    Array array = new Array();
    Random random = new Random();
    public int count = 0; // счетчик правильных ответов

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.universal);

        TextView textLevels = findViewById(R.id.textView);
        textLevels.setText(R.string.level2);

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
        ImageView previewImg = dialog.findViewById(R.id.preview_img);
        previewImg.setImageResource(R.drawable.number_lev_two);
        TextView textDescription = dialog.findViewById(R.id.text_description);
        textDescription.setText(R.string.level_two);

        TextView btnClose = dialog.findViewById(R.id.button_close);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Level2.this, MainActivity.class);
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

        ////-------------------------------------------------------------------------------------
        // вызов диалогового окна в конце игры
        dialogEnd = new Dialog(this);
        dialogEnd.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogEnd.setContentView(R.layout.dialog_end);
        dialogEnd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT)); // прозрачный фон диалогового окна - нет белой рамки вокруг
        dialogEnd.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
        dialogEnd.setCancelable(false); // запрет закрытия за пределами окна
        TextView textDescrEnd = dialogEnd.findViewById(R.id.text_description_end);
        textDescrEnd.setText(R.string.level_two_end);

        TextView btnClose2 = dialogEnd.findViewById(R.id.button_close);
        btnClose2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // возвращаемся к выбору уровня
                Intent intent = new Intent(Level2.this, MainActivity.class);
                startActivity(intent);
                dialogEnd.dismiss();
            }
        });

        Button btn_continue_2 = dialogEnd.findViewById(R.id.button_continue);
        btn_continue_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Level2.this, Level2.class);
                startActivity(intent);
                dialogEnd.dismiss();
            }
        });

//        //-------------------------------------------------------------------------------------


        Button btnBack = findViewById(R.id.button_back_level1);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Level2.this, MainActivity.class);
                startActivity(intent);
            }
        });

        final Animation animation = AnimationUtils.loadAnimation(Level2.this, R.anim.alpha);
        numLeft = random.nextInt(10);
        imgLeft.setImageResource(array.images2[numLeft]);
        textLeft.setText(array.text2[numLeft]); // достаем из массива текст

        numRight = random.nextInt(10);
        while (numLeft == numRight) {
            numRight = random.nextInt(10);
        }
        imgRight.setImageResource(array.images2[numRight]);
        textRight.setText(array.text2[numRight]); // достаем из массива текст

        // массив для прогресса игры
        final int[] progress = {R.id.point1,
                R.id.point2,
                R.id.point3,
                R.id.point4,
                R.id.point5,
                R.id.point6,
                R.id.point7,
                R.id.point8,
                R.id.point9,
                R.id.point10,
                R.id.point11,
                R.id.point12,
                R.id.point13,
                R.id.point14,
                R.id.point15,
                R.id.point16,
                R.id.point17,
                R.id.point18,
                R.id.point19,
                R.id.point20};


        // обрабатываем нажатие на левую картинку
        imgLeft.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    imgRight.setEnabled(false); // если нажали левую - блокируем правую
                    if (numLeft > numRight) {
                        imgLeft.setImageResource(R.drawable.img_true);
                    } else {
                        imgLeft.setImageResource(R.drawable.img_false);
                    }
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (numLeft > numRight) {
                        if (count < 20) {
                            count++;
                        }
                        // закрашиваем прогресс серым цветом
                        for (int j : progress) {
                            TextView tv = findViewById(j);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        for (int i = 0; i < count; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                    } else {
                        if (count > 0) {
                            if (count == 1) count = 0;
                            else count -= 2;
                            for (int i = 0; i < progress.length - 1; i++) {
                                TextView tv = findViewById(progress[i]);
                                tv.setBackgroundResource(R.drawable.style_points);
                            }
                            for (int i = 0; i < count; i++) {
                                TextView tv = findViewById(progress[i]);
                                tv.setBackgroundResource(R.drawable.style_points_green);
                            }
                        }
                    }
                    if (count == 20) { //выход из уровня
                        SharedPreferences save = getSharedPreferences("myhwpref", MODE_PRIVATE); // сохраняем текущую ситуацию по пройденным уровням
                        int level = save.getInt("Level", 1);
                        int points = save.getInt("points", 0);
                        if (level <= 2) level = 2;

                        SharedPreferences.Editor editor = save.edit();
                        points = points + 20;
                        editor.putInt("points", points);
                        editor.putInt("Level", level);
                        editor.apply();
                        dialogEnd.show();

                    } else {
                        numLeft = random.nextInt(10);
                        imgLeft.setImageResource(array.images2[numLeft]);
                        imgLeft.startAnimation(animation);
                        textLeft.setText(array.text2[numLeft]);
                        do {
                            numRight = random.nextInt(10);
                        } while (numLeft == numRight);

                        imgRight.setImageResource(array.images2[numRight]);
                        imgRight.startAnimation(animation);
                        textRight.setText(array.text2[numRight]);
                        imgRight.setEnabled(true);


                    }

                }

                return true;
            }
        });

        // обрабатываем нажатие на правую картинку
        imgRight.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    imgLeft.setEnabled(false); // если нажали левую - блокируем правую
                    if (numRight > numLeft) {
                        imgRight.setImageResource(R.drawable.img_true);
                    } else {
                        imgRight.setImageResource(R.drawable.img_false);
                    }
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (numRight > numLeft) {
                        if (count < 20) {
                            count++;
                        }
                        // закрашиваем прогресс серым цветом
                        for (int j : progress) {
                            TextView tv = findViewById(j);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        for (int i = 0; i < count; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }


                    } else {
                        if (count > 0) {
                            if (count == 1) count = 0;
                            else count -= 2;
                            for (int i = 0; i < progress.length - 1; i++) {
                                TextView tv = findViewById(progress[i]);
                                tv.setBackgroundResource(R.drawable.style_points);
                            }
                            for (int i = 0; i < count; i++) {
                                TextView tv = findViewById(progress[i]);
                                tv.setBackgroundResource(R.drawable.style_points_green);
                            }
                        }
                    }
                    if (count == 20) { //выход из уровня
                        SharedPreferences save = getSharedPreferences("myhwpref", MODE_PRIVATE); // сохраняем текущую ситуацию по пройденным уровням
                        int level = save.getInt("Level", 1);
                        int points = save.getInt("points", 0);
                        if (level <= 2) level = 2;

                        SharedPreferences.Editor editor = save.edit();
                        points = points + 20;
                        editor.putInt("points", points);
                        editor.putInt("Level", level);
                        editor.apply(); // в конце первого уровня считываем текущее значение из куков и если оно меньше текущего то сохряняем текущее+1, дабы следующий уровень открылся
                        dialogEnd.show();
                    } else {
                        numRight = random.nextInt(10);
                        imgRight.setImageResource(array.images2[numRight]);
                        imgRight.startAnimation(animation);
                        textRight.setText(array.text2[numRight]);
                        do {
                            numLeft = random.nextInt(10);
                        } while (numRight == numLeft);

                        imgLeft.setImageResource(array.images2[numLeft]);
                        imgLeft.startAnimation(animation);
                        textLeft.setText(array.text2[numLeft]);
                        imgLeft.setEnabled(true);


                    }

                }

                return true;
            }
        });

    }
}