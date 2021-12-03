package com.example.higherorlower;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    int randomNumber;
    public int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(20) + 1;
    }

    public void pressBtnGuess(View view) {
        EditText guessEditText = (EditText) findViewById(R.id.guessEditText);
        int guess = Integer.parseInt(guessEditText.getText().toString());
        String message;
        if (guess == randomNumber) {
            message = "Correct try again :)";
            randomNumber = getRandomNumber();
            guessEditText.getText().clear();
        } else if (guess < randomNumber) {
            message = "Higher";
        } else {
            message = "Lower";
        }
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        randomNumber = getRandomNumber();
    }
}