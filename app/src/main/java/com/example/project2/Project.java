package com.example.project2;

import android.app.Application;
import androidx.room.Room;

public class Project extends Application {
    public static UserDatabase database;

    @Override
    public void onCreate(){
        super.onCreate();

        database = Room.databaseBuilder(getApplicationContext(), UserDatabase.class, "app_database")
                .allowMainThreadQueries()
                .build();

        User testUser = new User("testuser1", "password", false);
        User adminUser = new User("admin2", "secret", true);

        database.userDao().insertUser(testUser);
        database.userDao().insertUser(adminUser);
    }
}
