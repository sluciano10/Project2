package com.example.project2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class LoginActivity extends AppCompatActivity {
    private EditText userName;
    private EditText userPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userName = findViewById(R.id.userName);
        userPassword = findViewById(R.id.password);
        Button loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(v -> login());
    }

    private void login(){
        String username = userName.getText().toString();
        String password = userPassword.getText().toString();
        List<User> adminUsers = Project.database.userDao().getAdminUsers();
        User user = Project.database.userDao().getUser(username, password);

        if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please enter both username and password", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(user!= null) {
            if (isUserAdmin(user, adminUsers)) {
                Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show();
                goToAdminLandingPage(user);
            } else {
                Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show();
                goToLandingPage(user);
            }
        }
        else{
            Toast.makeText(this, "Incorrect username or password", Toast.LENGTH_SHORT).show();
        }
    }

    private static boolean isUserAdmin(User user, List<User> adminUsers) {
        for (User adminUser : adminUsers) {
            if (adminUser.isAdmin() && adminUser.getId() == user.getId()) {
                return true;
            }
        }
        return false;
    }

    public void goToCreateAccountActivity(View view) {
        Intent intent = new Intent(this, CreateAccountActivity.class);
        startActivity(intent);
    }

    private void goToAdminLandingPage(User user) {
        Intent intent = new Intent(this, AdminLandingPageActivity.class);
        intent.putExtra("user", user);
        startActivity(intent);
        finish();
    }

    private void goToLandingPage(User user) {
        Intent intent = new Intent(this, AdminLandingPageActivity.class);
        intent.putExtra("user", user);
        startActivity(intent);
        finish();
    }
}

