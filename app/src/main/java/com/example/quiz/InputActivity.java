package com.example.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class InputActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_input);

        Button submitUsernameBtn = findViewById(R.id.submitUsernameButton);
        submitUsernameBtn.setOnClickListener((view) -> {
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("username", ((EditText) findViewById(R.id.username)).getText().toString());
            startActivity(intent);
        });
    }
}
