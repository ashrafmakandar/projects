package com.ashraf.quiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class History extends AppCompatActivity {
    RecyclerView recyclerView;
    List<history> histories;
    historyDb historyDbs;
    historyAdapter historyAdapters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        histories = new ArrayList<>();
        recyclerView = findViewById(R.id.rec);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setHasFixedSize(true);
        historyDbs = Room.databaseBuilder(getApplicationContext(), historyDb.class, "historydb").allowMainThreadQueries().build();
        histories = historyDbs.hsitoryDaos().gethistory();
        historyAdapters = new historyAdapter(histories, getApplicationContext());
        recyclerView.setAdapter(historyAdapters);
    }
}
