package com.example.spinnermoneyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private Spinner fromSpinner = null, toSpinner = null;
    private EditText fromEditText = null, toEditText = null;
    private Button clearButton = null, convertButton = null;

    private String[] currencies = {"Ron", "Eur", "Usd", "Ukp", "Huf"};
    private Double[] rates = {1.0, 4.95, 5.12, 6.23, 3.21};

    private ArrayAdapter<String> adapter = null;

    private int toIndex = -1, fromIndex = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // wire objects
        fromSpinner = findViewById(R.id.fromSpinner);
        toSpinner = findViewById(R.id.toSpinner);

        fromEditText = findViewById(R.id.fromEditText);
        toEditText = findViewById(R.id.toEditText);

        clearButton = findViewById(R.id.clearButton);
        convertButton = findViewById(R.id.convertButton);

        // populate the spinners
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, currencies);
        fromSpinner.setAdapter(adapter);
        toSpinner.setAdapter(adapter);

        // listeners for spinners
        fromSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                fromIndex = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        toSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                toIndex = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        clearButton.setOnClickListener(view -> {
            // reset spinners and edit texts
            fromEditText.setText("");
            toEditText.setText("");
            fromSpinner.setSelection(0, true);
            toSpinner.setSelection(0, true);
        });

        convertButton.setOnClickListener(view -> {
            // get the amount fromEditText
            String fromAmountStr = fromEditText.getText().toString();
            Double fromAmount = Double.parseDouble(fromAmountStr);

            // find the conversion rate using fromIndex and toIndex
            Double rate = rates[fromIndex] / rates[toIndex];

            // do conversion and place it toEdittext
            double toAmount = fromAmount * rate;
            toEditText.setText("" + toAmount);
        });
    }
}