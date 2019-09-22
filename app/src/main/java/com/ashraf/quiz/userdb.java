package com.ashraf.quiz;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {user.class},version = 1,exportSchema = false)
public abstract class userdb extends RoomDatabase {

    abstract userdao userdaos();
}
