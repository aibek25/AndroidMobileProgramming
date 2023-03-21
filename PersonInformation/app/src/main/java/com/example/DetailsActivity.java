package com.example;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
    public TextView nameTextView, addressTextView, phoneTextView, urlTextView, imageTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        // wire the objects
        nameTextView = findViewById(R.id.textView3);
        addressTextView = findViewById(R.id.textView4);
        phoneTextView = findViewById(R.id.textView5);
        urlTextView = findViewById(R.id.textView6);
        imageTextView = findViewById(R.id.textView7);

        // get intent and extract data
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        Person person = (Person) bundle.getSerializable("personData");

        // populate fields with data
        nameTextView.setText(person.getName());
        addressTextView.setText(person.getAddress());
        phoneTextView.setText(person.getPhone());
        urlTextView.setText(person.getUrl());
        imageTextView.setText(person.getImage());
    }
}