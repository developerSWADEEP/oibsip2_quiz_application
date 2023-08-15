package com.swadeep.quizapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class QuestionsActivity extends AppCompatActivity {

    TextView textView;
    Button submitbtn,quitbtn;
    RadioGroup radioGroup;
    RadioButton rbtn1,rbtn2,rbtn3,rbtn4;
    String questions[] =
            {
                    "What is the full form of TCS ?",
                    "Who is the founder of Android ?",
                    "Which is the smallest country in the world ?",
                    "Which is the longest river in the world ?",
                    "Which is the 29th state of India ?",
                    "Which is the highest dam of India ?",
                    "Which metal is the lightest metal in world ?",
                    "LED stands for what?",
                    "What is Sun ?",
                    "How many players are there in an ice hockey team ?"
            };
    String answers[] =
            {
                    "Tata Consultancy Services","Andy Rubin","Vatican City","Nile","Telangana","Tehri Dam","Lithium",
                    "Light Emitting Diode","Star","6"
            };
    String options[] =
            {
                    "Tata Communication Services","Tata Consumers Services","Tata Consultancy Servicing","Tata Consultancy Services",
                    "Andy Rubin","Dennis Ritchie","Tim Berners-Lee","John McCarthy",
                    "Nauru","Vatican City","San Marino","Qatar",
                    "Ganga","Nile","Amazon","Niger",
                    "Uttarakhand","Chattisgarh","Leh & Laddakh","Telangana",
                    "Sardar Sarovar Dam","Bhakra Nangal Dam","Tehri Dam","Mettur Dam",
                    "Sodium","Lithium","Zinc","Gold",
                    "Light Emitting Diode","Light Electronic Diode","Low emitting Diode","Light Electronic Device",
                    "Satellite","Star","Planet","Comet",
                    "11","7","9","6",
            };

    int flag = 0;
    public static int marks=0,correct=0,wrong=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        final TextView score = (TextView) findViewById(R.id.finalscoreTV);

        TextView displayName=(TextView)findViewById(R.id.displayname);
        Intent intent = getIntent();
        String name= intent.getStringExtra("uname");
        displayName.setText("Hello "+name);

        submitbtn = (Button) findViewById(R.id.nextbtn);
        quitbtn = (Button) findViewById(R.id.buttonquit);
        textView = (TextView) findViewById(R.id.questiontextview);
        radioGroup = (RadioGroup) findViewById(R.id.answergrp);
        rbtn1 = (RadioButton) findViewById(R.id.radioButton1);
        rbtn2 = (RadioButton) findViewById(R.id.radioButton2);
        rbtn3 = (RadioButton) findViewById(R.id.radioButton3);
        rbtn4 = (RadioButton) findViewById(R.id.radioButton4);

        textView.setText(questions[flag]);
        rbtn1.setText(options[0]);
        rbtn2.setText(options[1]);
        rbtn3.setText(options[2]);
        rbtn4.setText(options[3]);

        TextView finalTextView = textView;

        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (radioGroup.getCheckedRadioButtonId()==-1)
                {
                    Toast.makeText(QuestionsActivity.this, "Please select an option", Toast.LENGTH_SHORT).show();
                    return;
                }

                RadioButton selbtn = (RadioButton) findViewById(radioGroup.getCheckedRadioButtonId());
                String answered = selbtn.getText().toString();

                if (answered.equals(answers[flag]))
                {
                    correct++;
                    Toast.makeText(QuestionsActivity.this, "Correct Answer", Toast.LENGTH_SHORT).show();
                }

                else
                {
                    wrong++;
                    Toast.makeText(QuestionsActivity.this, "Wrong!!", Toast.LENGTH_SHORT).show();
                }

                flag ++;

                if (score!=null)
                    score.setText(""+correct);

                if (flag<questions.length)
                {
                    textView.setText(questions[flag]);
                    rbtn1.setText(options[flag*4]);
                    rbtn2.setText(options[flag*4 + 1]);
                    rbtn3.setText(options[flag*4 + 2]);
                    rbtn4.setText(options[flag*4 + 3]);
                }

                else
                {
                    marks = correct;
                    Intent intent1 = new Intent(getApplicationContext(),ResultActivity.class);
                    startActivity(intent1);
                }

                radioGroup.clearCheck();

            }
        });

        quitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(QuestionsActivity.this, MainActivity.class);
                startActivity(intent1);
            }
        });

    }
}