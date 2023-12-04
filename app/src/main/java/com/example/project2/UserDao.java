package com.example.project2;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

@Dao
public interface UserDao {
    @Insert
    void insertUser(User user);

    @Delete
    void deleteUser(User user);

    @Query("SELECT * FROM users WHERE userName = :userName AND password = :password")
    User loginUser(String userName, String password);

    @Query("SELECT * FROM users")
    List<User> getAllUsers();

    @Query("SELECT * FROM users WHERE userName = :username AND password = :password")
    User getUser(String username, String password);

    @Query("SELECT * FROM users WHERE isAdmin = 1")
    List<User> getAdminUsers();
}
