package com.example.thrid;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.switchmaterial.SwitchMaterial;

import java.text.NumberFormat;
import java.util.Locale;

public class CalcActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        Button btn = findViewById(R.id.calcBtn);
        TextView tipResult = findViewById(R.id.tip_result);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText cost = findViewById(R.id.costOfService);
//                String keyword = cost.getText().toString(); // забрали строку
                int value = Integer.parseInt(cost.getText().toString()); // преобразовали в числовое значение
                double tip = 0;
                RadioGroup tipOptions = findViewById(R.id.tip_options);
                int selectedId = tipOptions.getCheckedRadioButtonId();
                if (selectedId == R.id.options_ten_percent) {
                    tip = value * 0.1;
                } else if (selectedId == R.id.options_seven_percent) {
                    tip = value * 0.07;
                } else {
                    tip = value * 0.05;
                }
                SwitchMaterial roundSwitch = findViewById(R.id.round_switch);

                if (roundSwitch.isChecked()) tip = Math.ceil(tip);

                TextView tr = findViewById(R.id.tip_result);
//                tr.setText(String.valueOf(tip));
                Locale usLocale = new Locale("ru","RU");
                NumberFormat usCurrencyFormat = NumberFormat.getCurrencyInstance(usLocale);
                String currencyType = usCurrencyFormat.format(tip);
//                tr.setText(currencyType);
                String text = "Оставьте на чай "+currencyType;
                        tr.setText(text);
            }
        });


    }
}