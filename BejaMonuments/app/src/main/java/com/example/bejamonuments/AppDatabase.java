package com.example.bejamonuments;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = User.class, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract UserDao getUserDao();

    public abstract InterestPointDao getInterestPointDao();

    private static AppDatabase INSTANCE;

    public static AppDatabase getInstance(Context context){
        INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "MonumentsDB").build();

        return INSTANCE;
    }


}
