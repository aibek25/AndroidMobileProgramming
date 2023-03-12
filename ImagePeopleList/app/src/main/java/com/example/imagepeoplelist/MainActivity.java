package com.example.imagepeoplelist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView listView = null;
    private PeopleArrayAdapter adapter = null;

    private Person[] people = {
            new Person("Cristian", "0740123401", "UniTBv", "www.cristian.com", "image.jpg"),
            new Person("Cristian", "0740123401", "UniTBv", "www.cristian.com", "image.jpg"),
            new Person("Cristian", "0740123401", "UniTBv", "www.cristian.com", "image.jpg"),
            new Person("Cristian", "0740123401", "UniTBv", "www.cristian.com", "image.jpg"),
            new Person("Cristian", "0740123401", "UniTBv", "www.cristian.com", "image.jpg"),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // connect the list
        listView = findViewById(R.id.listView);
        adapter = new PeopleArrayAdapter(this, R.layout.row_layout, people);
        listView.setAdapter(adapter);

        // listen to the list
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "selected " + people[position].getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}