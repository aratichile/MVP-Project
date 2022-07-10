package com.example.virtusaicicimvpapplication.roomDatabase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.virtusaicicimvpapplication.model.DataRes;
import com.example.virtusaicicimvpapplication.model.Datum;
import com.example.virtusaicicimvpapplication.model.Support;

@Database(entities = {DataRes.class, Datum.class, Support.class}, version = 1)
@TypeConverters(DataConverter.class)
public abstract class AppDataBase extends RoomDatabase {
    private static AppDataBase instance;

    public abstract DataDao dataDao();

    public static AppDataBase getAppDatabase(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            AppDataBase.class,
                            "data-db")
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
}
