package com.example.thrid;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Date;

public class HWActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hwactivity2);
        CalendarView calendar = findViewById(R.id.calendarView);
        TextView tablo = findViewById(R.id.textView5);
        Button btnhw = findViewById(R.id.button3);


        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                tablo.setText(String.valueOf(dayOfMonth)+"-"+String.valueOf(month)+"-"+String.valueOf(year));
            }
        });


        btnhw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Long dat = calendar.getDate();
               Date dates = new Date(dat);
               tablo.setText(dates.toString());
            }
        });



    }
}