package com.enjamamulhoque.bottomnavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation_view);

        HomeFragment homeFragment = new HomeFragment();
        NotificationFragment notificationFragment = new NotificationFragment();
        AccountFragment accountFragment = new AccountFragment();

        // load home fragment by default
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_view, homeFragment).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){

                    case R.id.home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_view, homeFragment).commit();
                        return true;

                    case R.id.notification:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_view, notificationFragment).commit();
                        return true;

                    case R.id.account:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_view, accountFragment).commit();
                        return true;

                    default:
                        return true;

                }

            }
        });
    }
}