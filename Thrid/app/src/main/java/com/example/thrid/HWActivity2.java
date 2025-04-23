package com.example.thrid;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Switch;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;
import java.util.Date;

public class HWActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hwactivity2);

        CalendarView calendar = findViewById(R.id.calendarView);
        TextView tablo = findViewById(R.id.tablo);
        Button btnBack = findViewById(R.id.btn_back);
        RatingBar starBar = findViewById(R.id.ratingBar);
        RadioGroup rgStar = findViewById(R.id.radioGroup2);
        Switch swLamp = findViewById(R.id.sw_lamp);
        ImageView lamp=findViewById(R.id.lamp);


        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                tablo.setText(String.valueOf(dayOfMonth)+"-"+String.valueOf(month+1)+"-"+String.valueOf(year));
            }
        });

        rgStar.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radioButton) {
                    starBar.setNumStars(1);
                    } else if (checkedId == R.id.radioButton3) {
                    starBar.setNumStars(3);
                } else if (checkedId== R.id.radioButton4) starBar.setNumStars(5);

            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//               Long dat = calendar.getDate();
//               Date dates = new Date(dat);
//               tablo.setText(dates.toString());
                Intent intent = new Intent(HWActivity2.this, MainActivity.class);
                startActivity(intent);

            }
        });

        swLamp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (swLamp.isChecked()) lamp.setImageResource(R.drawable.lanp_on); else lamp.setImageResource(R.drawable.lanp_off);
            }
        });



    }
}