package com.testing.quizapplication;

import android.content.Intent;
import android.opengl.Visibility;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity extends AppCompatActivity {

public int points = 0;
public int currentIndex = 0;
public quizQuestions[] mathQuestions = {
new quizQuestions(R.string.q1, true),
        new quizQuestions(R.string.q2, false),
        new quizQuestions(R.string.q3, true),
        new quizQuestions(R.string.q4, true),
        new quizQuestions(R.string.q5, false)

};
    private View background;
    private TextView title;
    private TextView question;
    private TextView questionNo;
    private Button start;
    private Button trueButton;
    private Button falseButton;
    private Button Finish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;


        });

        background = findViewById(R.id.background);
        background.setVisibility(View.INVISIBLE);

        title = findViewById(R.id.Front);
        question = findViewById(R.id.question);
        questionNo = findViewById(R.id.questionNo);

        questionNo.setVisibility(View.INVISIBLE);
        question.setVisibility(View.INVISIBLE);
        title.setVisibility(View.VISIBLE);

        start = findViewById(R.id.begin);
        trueButton = findViewById(R.id.truth);
        falseButton = findViewById(R.id.lies);
        Finish = findViewById(R.id.Finish);

        start.setVisibility(View.VISIBLE);
        trueButton.setVisibility(View.INVISIBLE);
        falseButton.setVisibility(View.INVISIBLE);
        Finish.setVisibility(View.INVISIBLE);

        start.setOnClickListener(v ->  {
                background.setVisibility(View.VISIBLE);
                questionNo.setVisibility(View.VISIBLE);
                question.setVisibility(View.VISIBLE);
                title.setVisibility(View.INVISIBLE);

                start.setVisibility(View.INVISIBLE);
                falseButton.setVisibility(View.VISIBLE);
                trueButton.setVisibility(View.VISIBLE);

                currentIndex = 0;
                points = 0;
                updateQuestion();
            });
        trueButton.setOnClickListener(v -> checkAnswer(true));
        falseButton.setOnClickListener(v -> checkAnswer(false));

        Finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                //passes to second Act. Put extra can act like a transfer
                intent.putExtra("EXTRA_POINTS", points);
                intent.putExtra("EXTRA_TOTAL", mathQuestions.length * 2);
                startActivity(intent);
            }
        });


        };


        private void updateQuestion() {
            if(currentIndex < mathQuestions.length){
                questionNo.setText("Question " + (currentIndex+1));
                question.setText(mathQuestions[currentIndex].getAnsLocation());
            }
            else {
                falseButton.setVisibility(View.INVISIBLE);
                trueButton.setVisibility(View.INVISIBLE);
                Finish.setVisibility(View.VISIBLE);

                Toast.makeText(MainActivity.this, "Quiz finished! Score: "+ points + "/" +
                        mathQuestions.length*2, Toast.LENGTH_LONG).show();

            }
        }


        private void checkAnswer(boolean userInput) {
            if(currentIndex < mathQuestions.length){
                if(mathQuestions[currentIndex].isTrue() == userInput){
                    Toast.makeText(MainActivity.this, "Correct", Toast.LENGTH_SHORT).show();
                    points+=2;
                }

            }else{
                Toast.makeText(MainActivity.this, "Wrong", Toast.LENGTH_SHORT).show();

            }
            currentIndex++;
            updateQuestion();

        }



            //Coded for start up & hiding/shown option buttons for title and question slid

            }


