package com.example;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailsActivity extends AppCompatActivity {
    public TextView nameTextView, addressTextView, phoneTextView, urlTextView, imageTextView;
    private Button webButton;

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
        webButton = findViewById(R.id.button2);

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

        // deal with button's events
        webButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // create intent and bundle
                Intent intent1 = new Intent(DetailsActivity.this, WebActivity.class);
                Bundle bundle1 = new Bundle();

                // bundle data
                bundle1.putString("urlPerson", person.getUrl());
                intent1.putExtras(bundle1);

                // start activity
                startActivity(intent1);
            }
        });
    }
}