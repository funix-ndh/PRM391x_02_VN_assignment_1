package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        new CountDownTimer(60000, 1000) {

            public void onTick(long millisUntilFinished) {
                ((TextView) findViewById(R.id.countdownTimer)).setText("Seconds remaining: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                ((TextView) findViewById(R.id.countdownTimer)).setText("Finished!");
                Button submitBtn = findViewById(R.id.submitButton);
                submitBtn.performClick();
            }
        }.start();

        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        TextView usernameTextView = findViewById(R.id.username);
        usernameTextView.setText("User Name: " + username);

        Button submitBtn = findViewById(R.id.submitButton);
        submitBtn.setOnClickListener((view) -> {
            // count correct answer
            int totalCorrectAns = 0;

            // get answer question 1
            if (((RadioGroup) findViewById(R.id.answer1)).getCheckedRadioButtonId() == R.id.answer1_option3)
                totalCorrectAns++;

            // get answer question 2
            if (((EditText) findViewById(R.id.answer2)).getText().toString().equals("Vulcanizing"))
                totalCorrectAns++;

            // get answer question 3
            if (((CheckBox) findViewById(R.id.answer3_option1)).isChecked()
                    && !((CheckBox) findViewById(R.id.answer3_option2)).isChecked()
                    && ((CheckBox) findViewById(R.id.answer3_option3)).isChecked()
                    && !((CheckBox) findViewById(R.id.answer3_option4)).isChecked())
                totalCorrectAns++;

            // get answer question 4
            if (((EditText) findViewById(R.id.answer4)).getText().toString().equals("Gravity"))
                totalCorrectAns++;

            // get answer question 5
            if (((RadioGroup) findViewById(R.id.answer5)).getCheckedRadioButtonId() == R.id.answer5_option2)
                totalCorrectAns++;

            // get answer question 6
            if (((EditText) findViewById(R.id.answer6)).getText().toString().equals("Clouds") ||
                    ((EditText) findViewById(R.id.answer6)).getText().toString().equals("Cloud"))
                totalCorrectAns++;

            // get answer question 7
            if (!((CheckBox) findViewById(R.id.answer7_option1)).isChecked()
                    && !((CheckBox) findViewById(R.id.answer7_option2)).isChecked()
                    && ((CheckBox) findViewById(R.id.answer7_option3)).isChecked()
                    && ((CheckBox) findViewById(R.id.answer7_option4)).isChecked())
                totalCorrectAns++;

            // get answer question 8
            if (((EditText) findViewById(R.id.answer8)).getText().toString().equals("Wrist"))
                totalCorrectAns++;

            // get answer question 9
            if (((RadioGroup) findViewById(R.id.answer9)).getCheckedRadioButtonId() == R.id.answer9_option2)
                totalCorrectAns++;

            // get answer question 10
            if (((EditText) findViewById(R.id.answer10)).getText().toString().equals("Smelting"))
                totalCorrectAns++;

            String toastMsg;
            if (totalCorrectAns == 10) {
                toastMsg = "Perfect!";
            } else {
                toastMsg = "Try again.";
            }
            Toast.makeText(this, toastMsg + " You scored " + totalCorrectAns + " out of 10", Toast.LENGTH_SHORT).show();
        });
    }
}
