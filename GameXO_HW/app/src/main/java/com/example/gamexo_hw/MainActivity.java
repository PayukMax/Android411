package com.example.gamexo_hw;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private RadioButton rbt1, rbt2;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button startBtn = findViewById(R.id.start);
        rbt1 = findViewById(R.id.rBtn1);
        rbt2 = findViewById(R.id.rBtn2);
        text = findViewById(R.id.textView);

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rbt1.isChecked()) {
                    text.setText("RB1 = ON");
                    Intent intent = new Intent(MainActivity.this, PlayField.class);
                    startActivity(intent);
                }
                if (rbt2.isChecked()) {
                    text.setText("RB2 = ON");
                    Intent intent = new Intent(MainActivity.this, PlayField2.class);
                    startActivity(intent);
                }


            }
        });


    }


}