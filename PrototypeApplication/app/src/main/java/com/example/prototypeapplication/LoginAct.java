package com.example.prototypeapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginAct extends AppCompatActivity {

    Button btn_login;
    EditText login_name, login_passw;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        DbHelper dbh = new DbHelper(this);

        btn_login = findViewById(R.id.btn_login);
        login_name = findViewById(R.id.edit_user);
        login_passw = findViewById(R.id.edit_passw);
        tv = findViewById(R.id.tv);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (login_name.getText().toString().isEmpty()||login_passw.getText().toString().isEmpty()) {
                    Toast.makeText(LoginAct.this, "Имя и пароль обязательны!!!", Toast.LENGTH_SHORT).show();
                } else {
                    boolean result = dbh.checkUser(login_name.getText().toString(), login_passw.getText().toString());
                    if (result) {
                        Toast.makeText(LoginAct.this, "Авторизация успешно пройдена...", Toast.LENGTH_SHORT).show();
                        if (dbh.getRole(login_name.getText().toString())==0){
                            login_passw.setText("");
                            Intent intent = new Intent(LoginAct.this, AdminAct.class);
                            startActivity(intent);
                            dbh.close();
                        }
                        if (dbh.getRole(login_name.getText().toString())==1){
                            login_passw.setText("");
                            Intent intent = new Intent(LoginAct.this, Role1Act.class);
                            startActivity(intent);
                            dbh.close();
                        }
                    } else {
                        Toast.makeText(LoginAct.this, "Ошибка в имени пользоватея или пароле....", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}