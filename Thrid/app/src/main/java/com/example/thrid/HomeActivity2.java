package com.example.thrid;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HomeActivity2 extends AppCompatActivity {
    TextView name, email;
    Button logout;

    SharedPreferences sharedPreferences; // понадобится для сохранения чего-то внутри телефона, формат ключь-значение
    private static final String SHARED_PREF_NAME = "mypref"; // название для общих настроек - типа создаем файлик с именем
    private static final String KEY_NAME = "name"; // здесь сохраним имя
    private static final String KEY_EMAIL = "email"; // здесь сохраним имя


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);

        name = findViewById(R.id.textFullName);
        email = findViewById(R.id.textEmail);
        logout = findViewById(R.id.button_logout);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
        String name_tmp = sharedPreferences.getString(KEY_NAME, null);
        String email_tmp = sharedPreferences.getString(KEY_EMAIL, null);

        if (name_tmp != null || email_tmp != null) {
            name.setText("Full name - " + name_tmp);
            email.setText("Email - " + email_tmp);

        }

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.apply();
                finish();
                Toast.makeText(HomeActivity2.this, "Logout sacessfully...", Toast.LENGTH_SHORT).show();
            }
        });


    }
}