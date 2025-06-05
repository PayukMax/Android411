package com.example.fileapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private final static String FILE_NAME = "content.txt";
    Button btnSave, btnOpen;
    EditText edText;
    TextView text;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSave = findViewById(R.id.save_text);
        btnOpen = findViewById(R.id.open_text);
        edText = findViewById(R.id.editor);
        text = findViewById(R.id.text);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FileOutputStream fos = null;
                try {
                    fos = openFileOutput(FILE_NAME, MODE_PRIVATE); //MODE_APPEND
                    fos.write(edText.getText().toString().getBytes());
                    Toast.makeText(MainActivity.this, "File saved...", Toast.LENGTH_SHORT).show();

                } catch (IOException e) {
                    Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                } finally {
                    try {
                        if (fos!=null)  fos.close();
                    } catch (IOException e) {
                        Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }



            }
        });

        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FileInputStream fis = null;
                try {
                    fis = openFileInput(FILE_NAME);
                    byte[] bytes = new byte[fis.available()];
                    fis.read(bytes);
                    String txt = new String(bytes);
                    text.setText(txt);
                } catch (IOException e) {
                    Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                } finally {
                    if (fis!=null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }


            }
        });


    }
}