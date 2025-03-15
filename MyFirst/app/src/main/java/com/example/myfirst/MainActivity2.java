package com.example.myfirst;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {
    private TextView res;
    private EditText num1, num2;
    private Button cs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        res = findViewById(R.id.result);
        num1 = findViewById(R.id.editNumber1);
        num2 = findViewById(R.id.editNumber2);
        cs = findViewById(R.id.calcSum);

        cs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer number1 = Integer.parseInt(num1.getText().toString());
                Integer number2 = Integer.parseInt(num2.getText().toString());
                res.setText(String.valueOf(number1+number2));
            }
        });

    }
}