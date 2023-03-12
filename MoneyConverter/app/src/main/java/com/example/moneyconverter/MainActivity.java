package com.example.moneyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText euroEt, dollarEt;
    private Button clearBt, convertBt;
    private double rate = 1.234;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //wire objects with widgets

        euroEt = findViewById(R.id.editTxtEuro);
        dollarEt = findViewById(R.id.editTxtDollar);

        clearBt = findViewById(R.id.button);
        convertBt = findViewById(R.id.button2);

        //deal with buttons

        clearBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                euroEt.setText("");
                dollarEt.setText("");

            }
        });

        convertBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //get the text from euroEt and cast it to double
                String euroStr = euroEt.getText().toString();
                double euros = Double.parseDouble(euroStr);

                //do money conversion
                double dollars = euros * rate;

                //set the result in dollarEt
                dollarEt.setText(String.valueOf(dollars));

            }
        });
    }
}