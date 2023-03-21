package com.example;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class PersonActivity extends AppCompatActivity {
    private TextView nameTextView;
    private Button detailsButton;
    private ImageView personImageView;
    private Person personData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);

        // wire objects with widgets
        nameTextView = findViewById(R.id.textView);
        detailsButton = findViewById(R.id.button);
        personImageView = findViewById(R.id.imageView);

        // make person data
        personData = new Person("Cristian George", "Home", "1234", "www.cristian.com", "cristian.jpg");

        // populate UI
        nameTextView.setText(personData.getName());

        String iconName = personData.getImage();
        iconName = iconName.substring(0, iconName.indexOf('.'));

        int imageId = this.getResources()
                .getIdentifier(iconName, "drawable", this.getPackageName());

        personImageView.setImageResource(imageId);

        // deal with button events
        detailsButton.setOnClickListener(v -> {
            // make the intent and its bundle
            Intent intent = new Intent(PersonActivity.this, DetailsActivity.class);
            Bundle bundle = new Bundle();

            // place data in bundle and then in intent
            bundle.putSerializable("personData", personData);
            intent.putExtras(bundle);

            // start activity
            startActivity(intent);
        });
    }
}