package com.example.bejamonuments;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface InterestPointDao {

    @Query("SELECT * FROM InterestPointVisited WHERE id = :id")
    InterestPointVisited getById(long id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void update(InterestPointVisited InterestPointVisited);
}
