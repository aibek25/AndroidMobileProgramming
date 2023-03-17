package com.example;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements IRecyclerView {

    private RecyclerView listView = null;
    private DataAdapter adapter = null;
    private final People people = new People();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // setup list
        listView = findViewById(R.id.listView);
        listView.setLayoutManager(new LinearLayoutManager(this));
        listView.setItemAnimator(new DefaultItemAnimator());

        // initialize adapter
        adapter = new DataAdapter(this, R.layout.row_layout, people.getData(), this);
        listView.setAdapter(adapter);
    }

    @Override
    public void onClickItem(int position) {
        // what we want if we click position
        Toast.makeText(this, "Selected " + people.getPerson(position).getName(),
                Toast.LENGTH_SHORT).show();
    }
}
