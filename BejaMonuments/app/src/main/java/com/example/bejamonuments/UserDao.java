package com.example.bejamonuments;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDao {

    @Query("SELECT * FROM User")
    LiveData<List<User>> getUsers();

    @Query("SELECT * FROM User WHERE email = :email AND password = :password")
    LiveData<User> getUserAccount(String email, String password);

    @Query("SELECT * FROM User WHERE email = :email")
    User getUserByEmail(String email);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addAll(List<User> users);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void add(User user);

    @Update
    void update(User users);

    @Delete
    void delete(User user);
}
