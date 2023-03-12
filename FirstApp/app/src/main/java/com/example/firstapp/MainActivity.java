package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //interface objects
    private Button showButton;
    private Button hideButton;
    private TextView infoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // wire object with widgets
        showButton = findViewById(R.id.button);
        hideButton = findViewById(R.id.button2);
        infoTextView = findViewById(R.id.textView);

        // deal with buttons events
        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String info = "Margareta\n" + " Mea";
                infoTextView.setText(info);
            }
        });

        hideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                infoTextView.setText("");
            }
        });
    }
}