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

public class MainActivity extends AppCompatActivity {
//private TextView tS1;
//private Button but1;
//private boolean b1=false;
//private TextView tS2;
//private Button but2;
//private boolean b2=false;

    private TextView rv;
    private EditText n1, n2;
    private Button b1, b2, b3, b4;


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
//        setContentView(R.layout.hw3);
        setContentView(R.layout.hw4);

        rv = findViewById(R.id.resView);
        n1 = findViewById(R.id.num1);
        n2 = findViewById(R.id.num2);
        b1 = findViewById(R.id.bt1);
        b2 = findViewById(R.id.bt2);
        b3 = findViewById(R.id.bt3);
        b4 = findViewById(R.id.bt4);


//        tS1=findViewById(R.id.textView28);
//        but1=findViewById(R.id.button15);
//        tS2=findViewById(R.id.textView29);
//        but2=findViewById(R.id.button16);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer number1 = Integer.parseInt(n1.getText().toString());
                Integer number2 = Integer.parseInt(n2.getText().toString());
                String str = "Result: " + n1.getText() + " + " + n2.getText() + " = " + String.valueOf(number1 + number2);
                rv.setText(str);

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer number1 = Integer.parseInt(n1.getText().toString());
                Integer number2 = Integer.parseInt(n2.getText().toString());
                String str = "Result: " + n1.getText() + " - " + n2.getText() + " = " + String.valueOf(number1 - number2);
                rv.setText(str);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer number1 = Integer.parseInt(n1.getText().toString());
                Integer number2 = Integer.parseInt(n2.getText().toString());
                String str = "Result: " + n1.getText() + " * " + n2.getText() + " = " + String.valueOf(number1*number2);
                rv.setText(str);
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer number1 = Integer.parseInt(n1.getText().toString());
                Integer number2 = Integer.parseInt(n2.getText().toString());
                if (number2 != 0) {
                    float resultat = (float) number1 / number2;
                    String str = "Result: " + n1.getText() + " / " + n2.getText() + " = " + String.valueOf(resultat);
                    rv.setText(str);
                } else rv.setText("На 0 делить нельзя!");
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