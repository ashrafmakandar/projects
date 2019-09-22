package com.ashraf.quiz;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {history.class}, version = 1, exportSchema = false)
public abstract class historyDb extends RoomDatabase {

    abstract hsitoryDao hsitoryDaos();
}
