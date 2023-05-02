package com.example.capitalquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button trueButton;
    private Button falseButton;

    private Button nextButton;
    private TextView questionText;

    int questionResId;

    private final Question[] questions = {
            new Question(R.string.ques_il, true),
            new Question(R.string.ques_ca, false),
            new Question(R.string.ques_ny, false),
            new Question(R.string.ques_tx, false),
            new Question(R.string.ques_wa, true)
    };
    private int currentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        trueButton = findViewById(R.id.button);
        falseButton = findViewById(R.id.button2);

        nextButton = findViewById(R.id.button3);
        questionText = findViewById(R.id.textView);
        questionResId = questions[currentIndex].textResId;
        questionText.setText(questionResId);


        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(true);
            }
        });

        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(false);

            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentIndex = (currentIndex + 1) % questions.length;
                updateQuestion();
            }
        });
    }

    private void checkAnswer(boolean userAnswer) {
        boolean correctAnswer = questions[currentIndex].answer;
        int messageResId = userAnswer == correctAnswer ? R.string.correct : R.string.incorrect;
        Toast.makeText(getApplicationContext(), messageResId, Toast.LENGTH_SHORT).show();
    }

    private void updateQuestion() {
        questionResId = questions[currentIndex].textResId;
        questionText.setText(questionResId);
    }
}