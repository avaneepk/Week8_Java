package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText inputFirstText;
    private EditText inputSecondText;
    private TextView outputText;

    @SuppressLint("MissingInflatedId")
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

        inputFirstText = findViewById(R.id.inputFirstText);
        inputSecondText = findViewById(R.id.inputSecondText);
        outputText = findViewById(R.id.outputText);
    }

    public void addition(View view) {
        if (!validateInput()) return;
        int num1 = Integer.parseInt(inputFirstText.getText().toString());
        int num2 = Integer.parseInt(inputSecondText.getText().toString());
        outputText.setText(String.valueOf(num1 + num2));
    }

    public void subtract(View view) {
        if (!validateInput()) return;
        int num1 = Integer.parseInt(inputFirstText.getText().toString());
        int num2 = Integer.parseInt(inputSecondText.getText().toString());
        outputText.setText(String.valueOf(num1 - num2));
    }

    public void multiply(View view) {
        if (!validateInput()) return;
        int num1 = Integer.parseInt(inputFirstText.getText().toString());
        int num2 = Integer.parseInt(inputSecondText.getText().toString());
        outputText.setText(String.valueOf(num1 * num2));
    }

    public void divide(View view) {
        if (!validateInput()) return;
        int num1 = Integer.parseInt(inputFirstText.getText().toString());
        int num2 = Integer.parseInt(inputSecondText.getText().toString());
        if (num2 == 0) {
            outputText.setText("Please don't enter 0 as input");
        } else {
            outputText.setText(String.valueOf(num1 / num2));
        }
    }

    private boolean validateInput() {
        String num1Str = inputFirstText.getText().toString().trim();
        String num2Str = inputSecondText.getText().toString().trim();

        if (num1Str.isEmpty() || num2Str.isEmpty()) {
            outputText.setText("Please enter both numbers");
            return false;
        }
        return true;
    }
}
