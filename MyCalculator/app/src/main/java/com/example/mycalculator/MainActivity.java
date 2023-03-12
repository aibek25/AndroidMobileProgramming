package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // objects and variables
    private TextView screen = null;
    private String screenValue = "";
    private String operation = "";
    private String prevScreenValue = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        screen = findViewById(R.id.textView);
    }

    public void onDigitClick(View v) {
        // get screenValue
        screenValue = screen.getText().toString();

        // only one decimal point is allowed

        // append v's label to it
        screenValue += ((Button) v).getText().toString();

        // place it back to screen
        screen.setText(screenValue);
    }

    public void onOperClick(View v) {
        // store the operation to compute
        operation = ((Button) v).getText().toString();

        // store the screen value
        prevScreenValue = screen.getText().toString();

        // reset screen
        screen.setText("");
    }

    public void onEqualClick(View v) {
        // convert strings to numbers
        Double screenNumber = Double.parseDouble(screenValue);
        Double prevScreenNumber = Double.parseDouble(prevScreenValue);
        Double result = 0.0;

        // check what operation
        switch (operation) {
            case "+":
                result = screenNumber + prevScreenNumber;
                screen.setText("" + result);
                break;
            case "-":
                result = -screenNumber + prevScreenNumber;
                screen.setText("" + result);
                break;
            case "*":
                result = screenNumber * prevScreenNumber;
                screen.setText("" + result);
                break;
            case "/":
                if (screenNumber == 0) {
                    screen.setText("ERROR");

                } else {
                    result = prevScreenNumber / screenNumber;
                    screen.setText("" + result);
                }
                break;
            default:
                break;
        }
    }

    public void onBackClick(View v) {

        // remove the last digit from screen
        screenValue = screen.getText().toString();
        screenValue = screenValue.substring(0, screenValue.length() - 1);

        // place it back to screen
        screen.setText(screenValue);
    }

    public void onClearClick(View v) {
        // clear screen and reset all vars
        screen.setText("");
        screenValue = "";
        operation = "";
        prevScreenValue = "";

    }
}