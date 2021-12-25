package com;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.NormalRecyclerView;
import com.example.navigationdrawer.Fragments.FragmentChat;
import com.example.navigationdrawer.Fragments.FragmentMail;
import com.example.navigationdrawer.Fragments.FragmentProfile;
import com.example.navigationdrawer.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;
    private BottomNavigationView bottomNavigationView;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


          getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
//
//        Locale farsi = new Locale("fa", "IR");
//        getResources().getConfiguration().setLocale(farsi);


        //add Toolbar in Activity
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        drawer = findViewById(R.id.drawer_layout);
        bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnItemSelectedListener(navListener);


        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


    }


    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        Fragment selectFragment = null;

        @Override
        public boolean onNavigationItemSelected(MenuItem item) {

            switch (item.getItemId()) {

                case R.id.nav_home:
                    selectFragment = new FragmentMail();
                    break;
                case R.id.nav_favorites:
                    selectFragment = new FragmentChat();
                    break;
                case R.id.nav_search:
                    selectFragment = new FragmentProfile();
                    break;

            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectFragment).commit();

            return true;


        }
    };

    @Override
    public void onBackPressed() {

        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {

            super.onBackPressed();
        }

    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.nav_message:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new FragmentChat()).commit();
                break;
            case R.id.nav_chat:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new FragmentMail()).commit();
                break;
            case R.id.nav_profile:
//                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
//                        new FragmentProfile()).commit();
                Intent Login =new Intent(MainActivity.this, LoginActivity.class);
                startActivity(Login);
                break;
            case R.id.share:
//                Toast.makeText(this, "اشتراک داده ها !", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(MainActivity.this, NormalRecyclerView.class);
                startActivity(intent);
                break;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}