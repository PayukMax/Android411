package com.example.prototypeapplication;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class AdminAct extends AppCompatActivity implements OnDialogCloseListener{
    FloatingActionButton add_user;
    RecyclerView rc;
    DbHelper myDB;
    private List<UsersData> mList;
    private UsListAdaptor adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        rc = findViewById(R.id.recyclerView);
        add_user = findViewById(R.id.addButton);
        myDB = new DbHelper(AdminAct.this);
        mList = new ArrayList<>();
        adapter = new UsListAdaptor(myDB,AdminAct.this);

        rc.setHasFixedSize(true);
        rc.setLayoutManager(new LinearLayoutManager(this));
        rc.setAdapter(adapter);

        mList = myDB.getAllUsers();
        adapter.setUser(mList);

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new RecyclerViewTouchHelper(adapter));
        itemTouchHelper.attachToRecyclerView(rc);
add_user.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        AddNewUser.newInstance().show(getSupportFragmentManager(), AddNewUser.TAG);
    }
});

    }

    @Override
    public void onDialogClose(DialogInterface dialogInterface) {
        mList = myDB.getAllUsers();
        adapter.setUser(mList);
        adapter.notifyDataSetChanged();
    }
}