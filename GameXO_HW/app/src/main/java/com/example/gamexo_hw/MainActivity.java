package com.example.gamexo_hw;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

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

        EditText playerOne = findViewById(R.id.player1);
        EditText playerTwo = findViewById(R.id.player2);
        Button startBtn = findViewById(R.id.start);
        rbt1 = findViewById(R.id.rBtn1);
        rbt2 = findViewById(R.id.rBtn2);
        text = findViewById(R.id.textView);

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getPlOne = playerOne.getText().toString();
                String getPlTwo = playerTwo.getText().toString();
                if (getPlOne.isEmpty()||getPlTwo.isEmpty()){
                    Toast.makeText(MainActivity.this, "Please enter names of Players...", Toast.LENGTH_SHORT).show();
                } else {
                    if (rbt1.isChecked()) {
                        text.setText("RB1 = ON");

                        Intent intent = new Intent(MainActivity.this, PlayField.class);
                        intent.putExtra("playerOne",getPlOne);
                        intent.putExtra("playerTwo",getPlTwo);
                        startActivity(intent);
                    }
                    if (rbt2.isChecked()) {
                        text.setText("RB2 = ON");
                        Intent intent = new Intent(MainActivity.this, PlayField2.class);
                        intent.putExtra("playerOne",getPlOne);
                        intent.putExtra("playerTwo",getPlTwo);
                        startActivity(intent);
                    }
                }

            }
        });


    }


}