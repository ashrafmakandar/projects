package com.ashraf.quiz;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface userdao {

    @Insert
    void insert(user user);


    @Query("select * from user")
    List<user> userlist();




}
