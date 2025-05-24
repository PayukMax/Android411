package com.example.mymenu_hw;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MaterialToolbar materialToolbar = findViewById(R.id.materialToolbar);
        setSupportActionBar(materialToolbar); // типа запустили меню...

        NavigationView navigationView = findViewById(R.id.navigation_view);
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(MainActivity.this, drawerLayout, materialToolbar, R.string.drawer_open, R.string.drawer_cloce);
        drawerLayout.addDrawerListener(toggle);

//        TextView txt = findViewById(R.id.text1);


        SharedPreferences sharedPreferences = getSharedPreferences("myhwmenu", MODE_PRIVATE);
        String userName = sharedPreferences.getString("name", null);
        Boolean menuMode = sharedPreferences.getBoolean("menumode", false);

        if (userName == null ) {
            Intent intent = new Intent(MainActivity.this, Registration.class);
            startActivity(intent);
        } else {
//        txt.setText(userName+"/"+menuMode.toString());//
        }

        replaceFragment(new PageFirst());


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.first_page) {
                    replaceFragment(new PageFirst());
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else if (item.getItemId() == R.id.second_page) {
                    replaceFragment(new SecondPage());
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else if (item.getItemId() == R.id.thrid_page) {
                    replaceFragment(new ThridPage());
                    drawerLayout.closeDrawer(GravityCompat.START);
                }
//                else if (item.getItemId() == R.id.fourth_page) {
//                    replaceFragment(new SecondPage());
//                    drawerLayout.closeDrawer(GravityCompat.START);
//                }
                return false;
            }
        });



    }

    private void replaceFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }
}