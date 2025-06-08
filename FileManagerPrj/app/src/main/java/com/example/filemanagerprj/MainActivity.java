package com.example.filemanagerprj;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.filemanagerprj.fragments.CardFragment;
import com.example.filemanagerprj.fragments.InternalFragment;
import com.google.android.material.navigation.NavigationView;
import android.os.Environment;
import java.io.File;

public class MainActivity extends AppCompatActivity {
    String sss;
    



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        NavigationView navigationView = findViewById(R.id.nav_view);
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_drawer, R.string.close_drawer);
        drawerLayout.addDrawerListener(toggle);
//        toggle.syncState();
//        File mmm = ContextCompat.getExternalFilesDirs(this, null)[1];
//        sss = mmm.getPath();

        replaceFragment(new InternalFragment());

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId()==R.id.nav_internal) {
                    replaceFragment(new InternalFragment());
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else if (item.getItemId()==R.id.nav_card) {
                    replaceFragment(new CardFragment());
                } else if (item.getItemId()==R.id.nav_about)
                    Toast.makeText(MainActivity.this, "asdasdasdasdasdasdasdasd", Toast.LENGTH_LONG).show();

                drawerLayout.closeDrawer(GravityCompat.START);
                return false;
            }
        });

    }

    private void replaceFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();
    }
}