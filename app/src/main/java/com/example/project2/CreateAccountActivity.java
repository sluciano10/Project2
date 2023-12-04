package com.example.project2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CreateAccountActivity extends AppCompatActivity {
    private EditText userName;
    private EditText userPassword;
    private EditText confirmPassword;

    //TODO: ROOM DATABASE
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        userName = findViewById(R.id.userName);
        userPassword = findViewById(R.id.password);
        confirmPassword = findViewById(R.id.confirmPassword);

        Button createAccountButton = findViewById(R.id.createAccountButton);
        createAccountButton.setOnClickListener(v -> createAccount());
    }

    private void createAccount() {
        String username = userName.getText().toString();
        String password = userPassword.getText().toString();
        String confirmPassword = this.confirmPassword.getText().toString();

        if (!password.equals(confirmPassword)) {
            Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!username.isEmpty() && !password.isEmpty() && !confirmPassword.isEmpty()){
            Toast.makeText(this, "Account created successfully", Toast.LENGTH_SHORT).show();
            goToLoginActivity(new View(this));
        }
        else{
            Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show();
        }
    }
        public void goToLoginActivity(View view) {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }
}
