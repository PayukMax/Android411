package com.example.hw_recycleview;

import static android.app.PendingIntent.getActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button btnAdd, btnClose;
    EditText textA, textB;
    RecyclerView recyclerView;

    List<String> dataList = new ArrayList<>();
    DataAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textA = findViewById(R.id.text1);
        textB = findViewById(R.id.text2);
        btnAdd = findViewById(R.id.btnAdd);
        btnClose = findViewById(R.id.btnExit);
        recyclerView = findViewById(R.id.recView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        adapter = new DataAdapter(dataList);
        recyclerView.setAdapter(adapter);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data = textA.getText().toString()+"/"+textB.getText().toString();
                dataList.add(data);
                textA.setText("");
                textB.setText("");
                adapter.notifyDataSetChanged();

            }
        });


        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}