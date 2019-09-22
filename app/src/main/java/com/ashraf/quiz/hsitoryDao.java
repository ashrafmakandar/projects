package com.ashraf.quiz;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface hsitoryDao {


    @Insert
    void insert(history history);


    @Query("SELECT * FROM history")
    List<history> gethistory();
}
