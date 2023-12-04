package com.example.project2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (isLoggedIn()) {
            startActivity(new Intent(this, LandingPageActivity.class));
            finish();
        }

        Button loginButton = findViewById(R.id.loginButton);
        Button createAccountButton = findViewById(R.id.createAccountButton);

        loginButton.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, LoginActivity.class)));
        createAccountButton.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, CreateAccountActivity.class)));
        }
        private boolean isLoggedIn() {
            SharedPreferences preferences = getPreferences(MODE_PRIVATE);
            return preferences.getBoolean("isLoggedIn", false);
        }
    }

