package com.ashraf.quiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;

public class Summary extends AppCompatActivity {
    TextView username, question1, question2, answer1, answer2;
    Button finish, histor;
    historyDb historyDbs;

    history historys;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
        username = findViewById(R.id.username);
        question1 = findViewById(R.id.quest1);
        question2 = findViewById(R.id.quest2);
        answer1 = findViewById(R.id.ansr1);
        answer2 = findViewById(R.id.ansr2);
        finish = findViewById(R.id.goback);
        String ansr2 = getIntent().getStringExtra("answer2");
        histor = findViewById(R.id.history);
        String ansr1 = getIntent().getStringExtra("answer1");

        String q2 = getIntent().getStringExtra("q2");
        Toast.makeText(this, "" + Quizs.uname, Toast.LENGTH_SHORT).show();

        String q1 = getIntent().getStringExtra("q1");
        username.setText("HELLO     " + Quizs.uname);
        question1.setText("Q1 is :" + q1);
        question2.setText("Q2 is :" + q2);
        answer1.setText("YOUR ANSWER:" + ansr1);

        answer2.setText("YOUR ANSWER :" + ansr2);
        Calendar c = Calendar.getInstance();
        String time = DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime());
        historyDbs = Room.databaseBuilder(getApplicationContext(), historyDb.class, "historydb").allowMainThreadQueries().build();

        historys = new history(time, Quizs.uname, q1, q2, ansr1, ansr2);


        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });
        histor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), History.class);
                startActivity(i);
                historyDbs.hsitoryDaos().insert(historys);
            }
        });

    }
}
