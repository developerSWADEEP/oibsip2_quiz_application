package com.swadeep.quizapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView correctTV, wrongTV, finalScoreTV;
    Button restartbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        correctTV = (TextView) findViewById(R.id.correcttextview);
        wrongTV = (TextView) findViewById(R.id.wrongtextview);
        finalScoreTV = (TextView) findViewById(R.id.finaltextview);

        StringBuffer sb1 = new StringBuffer();
        sb1.append("Correct Answers :" + QuestionsActivity.correct + "\n");

        StringBuffer sb2 = new StringBuffer();
        sb2.append("Wrong Answers :" + QuestionsActivity.wrong + "\n");

        StringBuffer sb3 = new StringBuffer();
        sb3.append("Final Score :" + QuestionsActivity.correct + "\n");

        correctTV.append(sb1);
        wrongTV.append(sb2);
        finalScoreTV.append(sb3);
        QuestionsActivity.correct = 0;
        QuestionsActivity.wrong = 0;

    }
}