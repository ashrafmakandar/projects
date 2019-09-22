package com.ashraf.quiz;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {quizmodel.class}, version = 1, exportSchema = false)
public abstract class quizdb extends RoomDatabase {

    abstract quizdao quizdaos();
}
