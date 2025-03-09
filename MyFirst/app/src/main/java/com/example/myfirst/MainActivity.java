package com.example.myfirst;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
private TextView tS1;
private Button but1;
private boolean b1=false;
private TextView tS2;
private Button but2;
private boolean b2=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_main);
//        setContentView(R.layout.first_layout);
//        setContentView(R.layout.second_layout);
//        setContentView(R.layout.liner_layout2);
//        setContentView(R.layout.table_layout);
//        setContentView(R.layout.frame_layout);
//        setContentView(R.layout.button_panel);
        setContentView(R.layout.hw3);

        tS1=findViewById(R.id.textView28);
        but1=findViewById(R.id.button15);
        tS2=findViewById(R.id.textView29);
        but2=findViewById(R.id.button16);

        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (b1) {
                    tS1.setText("Строка 1 надпись первая");
                    but1.setText("Кнопка 1 надпись 2");
                    b1=false;
                } else {
                    tS1.setText("Строка 1 надпись вторая");
                    but1.setText("Кнопка 1 надпись 1");
                    b1=true;
                }
            }
        });

        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (b2) {
                    tS2.setText("Строка 2 надпись первая");
                    but2.setText("Кнопка 2 надпись 2");
                    b2=false;
                } else {
                    tS2.setText("Строка 2 надпись вторая");
                    but2.setText("Кнопка 2 надпись 1");
                    b2=true;
                }
            }
        });


//        setContentView(R.layout.sclorr_view);
//        setContentView(R.layout.hw_layout);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
    }

//    public void sayHello(View view){
//        textSample.setText("Привет...");
//        textSample.setTextSize(25);
//    }
}