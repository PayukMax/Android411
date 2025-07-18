package com.example.prototypeapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btn_save;
    EditText name, passw;
    RadioGroup rg;
    RadioButton rb4;

    TextView tv;
    int role=10;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // проверяем на предмет наличия базы и записи учетки админа в базе. если записей с ролью 0 нет ни одной - значит первый запуск.
        DbHelper dbh = new DbHelper(this);
        if (dbh.checkRoot()) {
            Intent intent = new Intent(MainActivity.this, LoginAct.class);
            startActivity(intent);
            dbh.close();
        }


        tv=findViewById(R.id.testText);
        name = findViewById(R.id.editName);
        passw = findViewById(R.id.editPassw);
        btn_save = findViewById(R.id.btnSave);
        rb4=findViewById(R.id.rb4);
        rg = findViewById(R.id.roleSelector);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                int selectedId = rg.getCheckedRadioButtonId();
                if (selectedId==R.id.rb1) role=1;
                if (selectedId==R.id.rb2) role=2;
                if (selectedId==R.id.rb3) role=3;
                if (selectedId==R.id.rb4) role=0;

                tv.setText(String.valueOf(role));

            }
        });



        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (name.getText().toString().isEmpty() || passw.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Поля должны быть заполнены!!!", Toast.LENGTH_SHORT).show();
                } else {
                    // Сохраняем в базу учетку с ролью 0
                    boolean result = dbh.addUser(name.getText().toString(),passw.getText().toString(),role);
                    if (result) {Toast.makeText(MainActivity.this, "Пользователь добавлен!!!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, LoginAct.class);
                    startActivity(intent);} else
                        Toast.makeText(MainActivity.this, "Ошибка добавления пользователя!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}