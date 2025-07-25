package com.example.sqlliteapplication;

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

import java.util.LinkedList;

public class HelperActivity extends AppCompatActivity {

    DBHelper dbHelper;
    EditText e_name,e_surname, e_year;
    TextView tvOut;
    Button btnAdd, btnGet, btnDel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helper);

        dbHelper = new DBHelper(this);
        tvOut= findViewById(R.id.tvOut);
        e_name = findViewById(R.id.editName);
        e_surname = findViewById(R.id.editSurname);
        e_year = findViewById(R.id.editYear);

        btnAdd = findViewById(R.id.buttonAdd);
        btnGet = findViewById(R.id.buttonGet);
        btnDel = findViewById(R.id.buttonDel);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = e_name.getText().toString();
                String surname = e_surname.getText().toString();
                int year = Integer.parseInt(e_year.getText().toString());

                Data data = new Data(name, surname, year);
                dbHelper.addOne(data);

                e_name.setText("");
                e_surname.setText("");
                e_year.setText("");


            }
        });

        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinkedList<Data> list = dbHelper.getAll();
                String text ="";
                for (Data d: list) {
                text = text+" "+ d.name+" "+ d.surname +" "+ d.age + " \n";
                }
                tvOut.setText(text);
            }
        });

        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.deleteAll();
            }
        });

    }
}