package com.ashraf.quiz;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "history")
public class history {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")

    int id;


    @ColumnInfo(name = "time")
    String time;
    @ColumnInfo(name = "username")
    String name;
    @ColumnInfo(name = "q1")
    String q1;
    @ColumnInfo(name = "q2")
    String q2;
    @ColumnInfo(name = "answer1")
    String answer1;

    @ColumnInfo(name = "answer2")
    String answer2;

    public history(String time, String name, String q1, String q2, String answer1, String answer2) {
        this.time = time;
        this.name = name;
        this.q1 = q1;
        this.q2 = q2;
        this.answer1 = answer1;
        this.answer2 = answer2;
    }

    public String getTime() {
        return time;
    }

    public String getName() {
        return name;
    }

    public String getQ1() {
        return q1;
    }

    public String getQ2() {
        return q2;
    }

    public String getAnswer1() {
        return answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQ1(String q1) {
        this.q1 = q1;
    }

    public void setQ2(String q2) {
        this.q2 = q2;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }
}
