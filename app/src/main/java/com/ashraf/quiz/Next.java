package com.ashraf.quiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.List;

public class Next extends AppCompatActivity {
    TextView que2;
    CheckBox ans11, ans12, ans13, ans14;
    Button submit;
    String selectedanswer2 = "";
    quizdb quizdbs;
    List<quizmodel> quizmodels;
    String finalanswer = "";
    String a1, q1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        que2 = findViewById(R.id.que2);
        ans11 = findViewById(R.id.ans11);

        ans12 = findViewById(R.id.ans12);

        ans13 = findViewById(R.id.ans13);

        ans14 = findViewById(R.id.ans14);

        submit = findViewById(R.id.submit);
        a1 = getIntent().getStringExtra("answer1");

        q1 = getIntent().getStringExtra("que1");
        Toast.makeText(this, "" + a1, Toast.LENGTH_SHORT).show();
        quizmodels = new ArrayList<>();
        quizdbs = Room.databaseBuilder(this, quizdb.class, "quizdb").allowMainThreadQueries().build();

        quizmodels = quizdbs.quizdaos().quiz();

        que2.setText("" + quizmodels.get(1).getQue().toString());

        ans11.setText("" + quizmodels.get(1).getAns1().toString());

        ans12.setText("" + quizmodels.get(1).getAns2().toString());

        ans13.setText("" + quizmodels.get(1).getAns3().toString());

        ans14.setText("" + quizmodels.get(1).getAns4().toString());

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Summary.class);
                i.putExtra("answer2", finalanswer);
                i.putExtra("answer1", a1);
                i.putExtra("q1", q1);
                i.putExtra("q2", que2.getText().toString());
                startActivity(i);
            }
        });
    }

    public void checked(View view) {
        switch (view.getId()) {
            case R.id.ans11:
                ans11.isChecked();
                selectedanswer2 = ans11.getText().toString() + ",";
                finalanswer = finalanswer.concat(selectedanswer2);
                Toast.makeText(this, "" + selectedanswer2, Toast.LENGTH_SHORT).show();
                break;

            case R.id.ans12:

                selectedanswer2 = ans12.getText().toString() + ",";
                ans12.isChecked();
                finalanswer = finalanswer.concat(selectedanswer2);
                Toast.makeText(this, "" + selectedanswer2, Toast.LENGTH_SHORT).show();
                break;

            case R.id.ans13:

                selectedanswer2 = ans13.getText().toString() + ",";
                ans13.isChecked();
                finalanswer = finalanswer.concat(selectedanswer2);
                Toast.makeText(this, "" + selectedanswer2, Toast.LENGTH_SHORT).show();
                break;

            case R.id.ans14:

                selectedanswer2 = ans14.getText().toString() + ",";
                ans14.isChecked();
                finalanswer = finalanswer.concat(selectedanswer2);
                Toast.makeText(this, "" + selectedanswer2, Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
