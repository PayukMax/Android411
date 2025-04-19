package com.example.thrid;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegisterActivity2 extends AppCompatActivity {

    EditText editTextName, editTextEmail;
    Button saveBtn;
    SharedPreferences sharedPreferences; // понадобится для сохранения чего-то внутри телефона, формат ключь-значение
    private static final String SHARED_PREF_NAME="mypref"; // название для общих настроек - типа создаем файлик с именем
    private static final String KEY_NAME="name"; // здесь сохраним имя
    private static final String KEY_EMAIL="email"; // здесь сохраним имя


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);

        editTextName = findViewById(R.id.editName);
        editTextEmail = findViewById(R.id.editTextEmail);
        saveBtn = findViewById(R.id.buttonSave);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE); // создаем файл с именем и правами только из этого приложения, MOD_WORD_WR....
        String name = sharedPreferences.getString(KEY_NAME,null);

        if (name != null) {
            Intent intent = new Intent(RegisterActivity2.this, HomeActivity2.class);
            startActivity(intent);
        }

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(KEY_NAME,editTextName.getText().toString());
                editor.putString(KEY_EMAIL,editTextEmail.getText().toString());
                editor.apply();
                Intent intent = new Intent(RegisterActivity2.this, HomeActivity2.class);
                startActivity(intent);

                Toast.makeText(RegisterActivity2.this, "Login success", Toast.LENGTH_SHORT).show();

            }
        });

    }
}