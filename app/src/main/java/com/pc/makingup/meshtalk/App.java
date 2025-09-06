package com.pc.makingup.meshtalk;

import android.app.Application;

import androidx.room.Room;
import androidx.room.Database;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

public class App extends Application {
    private static App instance;
    private static AppDatabase database;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        // Init Room Database
        database = Room.databaseBuilder(
                getApplicationContext(),
                AppDatabase.class,
                "meshtalk.db"
        ).fallbackToDestructiveMigration().build();
    }

    public static App getInstance() {
        return instance;
    }

    public static AppDatabase getDatabase() {
        return database;
    }
}