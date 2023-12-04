package com.example.project2;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.Ignore;
import java.io.Serializable;

@Entity(tableName = "users")
public class User implements Serializable {

    @ColumnInfo(name = "person_id")
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "username")
    private String userName;

    @ColumnInfo(name = "password")
    private String password;

    @ColumnInfo(name = "isAdmin")
    private boolean isAdmin;

    @Ignore
    public User(){

    }

    public User(String userName, String password, boolean isAdmin) {
        this.userName = userName;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}
