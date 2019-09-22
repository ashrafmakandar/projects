package com.ashraf.quiz;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
@Dao
public interface quizdao {


    @Insert
    void inserts(quizmodel quizmodel);


    @Query("select * from quiz")
    List<quizmodel> quiz();
}
