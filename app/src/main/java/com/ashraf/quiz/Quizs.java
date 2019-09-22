package com.ashraf.quiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Quizs extends AppCompatActivity {
    userdb userdbs;
    quizdb quizdbs;
    List<user> users;
    List<quizmodel> quizmodels;
    TextView q1;
    Button ans1, ans2, ans3, ans4, next;
    String selectedanser = "";
   static String uname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizs);
        q1 = findViewById(R.id.que1);
        ans1 = findViewById(R.id.ans1);

        ans2 = findViewById(R.id.ans2);

        ans3 = findViewById(R.id.ans3);

        ans4 = findViewById(R.id.ans4);
        next = findViewById(R.id.next);
        quizmodels = new ArrayList<>();
        userdbs = Room.databaseBuilder(getApplicationContext(), userdb.class, "users").allowMainThreadQueries().build();
        users = new ArrayList<>();
        quizdbs = Room.databaseBuilder(this, quizdb.class, "quizdb").allowMainThreadQueries().build();


        users = userdbs.userdaos().userlist();
        uname = users.get(users.size() - 1).getName().toString();
        Toast.makeText(this, "" + users.get(users.size() - 1).getName().toString(), Toast.LENGTH_SHORT).show();


        quizmodels = quizdbs.quizdaos().quiz();

        q1.setText("" + quizmodels.get(0).getQue().toString());

        ans1.setText("" + quizmodels.get(0).getAns1().toString());

        ans2.setText("" + quizmodels.get(0).getAns2().toString());

        ans3.setText("" + quizmodels.get(0).getAns3().toString());

        ans4.setText("" + quizmodels.get(0).getAns4().toString());

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Next.class);
                i.putExtra("answer1", selectedanser);
                i.putExtra("que1", q1.getText().toString());
                i.putExtra("name", uname);

                startActivity(i);
            }
        });
    }

    public void clicked(View view) {

        switch (view.getId()) {
            case R.id.ans1:

                ans1.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                ans2.setEnabled(false);
                ans3.setEnabled(false);
                ans4.setEnabled(false);
                selectedanser = ans1.getText().toString();
                Toast.makeText(this, "" + selectedanser, Toast.LENGTH_SHORT).show();
                break;

            case R.id.ans2:
                selectedanser = ans2.getText().toString();
                ans2.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                ans1.setEnabled(false);
                ans3.setEnabled(false);
                ans4.setEnabled(false);

                Toast.makeText(this, "" + selectedanser, Toast.LENGTH_SHORT).show();
                break;

            case R.id.ans3:

                selectedanser = ans3.getText().toString();
                ans3.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                ans2.setEnabled(false);
                ans1.setEnabled(false);
                ans4.setEnabled(false);

                Toast.makeText(this, "" + selectedanser, Toast.LENGTH_SHORT).show();
                break;

            case R.id.ans4:
                selectedanser = ans4.getText().toString();
                ans4.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                ans2.setEnabled(false);
                ans3.setEnabled(false);
                ans1.setEnabled(false);
                Toast.makeText(this, "" + selectedanser, Toast.LENGTH_SHORT).show();
                break;
        }
    }

}
