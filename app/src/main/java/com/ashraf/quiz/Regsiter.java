package com.ashraf.quiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Regsiter extends AppCompatActivity {
    userdb userdbs;
    EditText name;
    Button reg;
    quizmodel quizmodel,quizmodel1;
    quizdb quizdbs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regsiter);
        name = findViewById(R.id.name);
        reg = findViewById(R.id.register);

        userdbs = Room.databaseBuilder(this, userdb.class, "users").allowMainThreadQueries().build();
        quizdbs = Room.databaseBuilder(this, quizdb.class, "quizdb").allowMainThreadQueries().build();

        quizmodel = new quizmodel("WHO IS THE BEST CRICKETER", "SACHIN TENDULKAR", "VIRAT KOHLI", "ADAM GILCHRIST", "JACQUES KALLIS");
        quizdbs.quizdaos().inserts(quizmodel);
        quizmodel1 = new quizmodel("COLORS IN THE NATIONAL FLAG ARE", "GREEN", "SAFFRON", "WHITE", "RED");
        quizdbs.quizdaos().inserts(quizmodel1);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String uname = name.getText().toString();
                if (!uname.isEmpty()) {
                    user us = new user(uname);
                    userdbs.userdaos().insert(us);

                    Intent i = new Intent(getApplicationContext(), Quizs.class);
                    startActivity(i);

                }
            }
        });
    }
}
