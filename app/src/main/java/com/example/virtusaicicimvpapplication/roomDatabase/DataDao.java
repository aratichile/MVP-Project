package com.example.virtusaicicimvpapplication.roomDatabase;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.virtusaicicimvpapplication.model.Datum;

import java.util.List;

@Dao
public interface DataDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Datum> items);

    @Query("Select * FROM Datum")
    List<Datum> loadAllDataList();

}
