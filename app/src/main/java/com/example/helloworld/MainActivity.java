package com.example.helloworld;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView tvResult;
    private double firstNumber = 0;
    private String operator = "";
    private boolean isNewOp = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvResult = findViewById(R.id.tvResult);
    }

    public void onNumberClick(View view) {
        if (isNewOp) tvResult.setText("");
        isNewOp = false;
        Button button = (Button) view;
        String val = button.getText().toString();
        if (tvResult.getText().toString().equals("0") && !val.equals(".")) {
            tvResult.setText(val);
        } else {
            tvResult.append(val);
        }
    }

    public void onOperatorClick(View view) {
        firstNumber = Double.parseDouble(tvResult.getText().toString());
        operator = ((Button) view).getText().toString();
        isNewOp = true;
    }

    public void onClearClick(View view) {
        tvResult.setText("0");
        firstNumber = 0;
        operator = "";
        isNewOp = true;
    }

    public void onEqualClick(View view) {
        double secondNumber = Double.parseDouble(tvResult.getText().toString());
        double result = 0;
        switch (operator) {
            case "+": result = firstNumber + secondNumber; break;
            case "-": result = firstNumber - secondNumber; break;
            case "×": result = firstNumber * secondNumber; break;
            case "÷": if (secondNumber != 0) result = firstNumber / secondNumber; break;
        }
        tvResult.setText(String.valueOf(result));
        isNewOp = true;
    }
}