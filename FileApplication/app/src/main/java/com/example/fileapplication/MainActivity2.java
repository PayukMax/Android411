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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity2 extends AppCompatActivity {


    private final static String FILE_NAME = "document.txt";
    Button btnSave, btnOpen;
    EditText edText;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        btnSave = findViewById(R.id.save_text);
        btnOpen = findViewById(R.id.open_text);
        edText = findViewById(R.id.editor);
        text = findViewById(R.id.text);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try (FileOutputStream fos = new FileOutputStream(getExternalPath())) {
                    String txt = edText.getText().toString();
                    fos.write(txt.getBytes());
                    Toast.makeText(MainActivity2.this, "File 2222 saved", Toast.LENGTH_LONG).show();
                } catch (IOException e) {
                    Toast.makeText(MainActivity2.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }


            }
        });

        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                File file = getExternalPath();
                if (!file.exists()) {
                    Toast.makeText(MainActivity2.this, "No file", Toast.LENGTH_SHORT).show();
                    return;
                }
                try (FileInputStream fis = new FileInputStream(file)) {
                    byte[] bytes = new byte[fis.available()];
                    fis.read(bytes);
                    text.setText(new String(bytes));

                } catch (IOException e) {
                    Toast.makeText(MainActivity2.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }

            }
        });


    }

    private File getExternalPath() {
        return new File(getExternalFilesDir(null), FILE_NAME);
    }
}