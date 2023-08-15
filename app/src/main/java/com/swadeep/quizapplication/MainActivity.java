package com.swadeep.quizapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button startButton = (Button)findViewById(R.id.startbtn);
        EditText userName = (EditText)findViewById(R.id.userName);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = userName.getText().toString();
                if (name.trim().equals(""))
                {
                    Toast.makeText(MainActivity.this, "First enter the name to play the game",
                            Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Intent intent = new Intent(getApplicationContext(),QuestionsActivity.class);
                    intent.putExtra("uname",name);
                    startActivity(intent);
                }
            }
        });

    }
}