package com.example;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView fileTextView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fileTextView = findViewById(R.id.textView);

        // FileThread thread = new FileThread("thread", fileTextView);
        // thread.start();

        FileAsyncTask task = new FileAsyncTask(fileTextView);
        task.execute("poezie.txt");
    }
}