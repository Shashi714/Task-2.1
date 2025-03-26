package com.example.unitconverter;



import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Spinner spinnerFrom, spinnerTo;
    private EditText inputValue;
    private Button convertButton;
    private TextView resultView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerFrom = findViewById(R.id.spinnerFrom);
        spinnerTo = findViewById(R.id.spinnerTo);
        inputValue = findViewById(R.id.inputValue);
        convertButton = findViewById(R.id.convertButton);
        resultView = findViewById(R.id.resultView);

        // Load all units into the dropdowns
        ArrayAdapter<CharSequence> unitAdapter = ArrayAdapter.createFromResource(this,
                R.array.all_units, android.R.layout.simple_spinner_item);
        unitAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerFrom.setAdapter(unitAdapter);
        spinnerTo.setAdapter(unitAdapter);

        convertButton.setOnClickListener(v -> convert());
    }

    private void convert() {
        String fromUnit = spinnerFrom.getSelectedItem().toString();
        String toUnit = spinnerTo.getSelectedItem().toString();
        String inputText = inputValue.getText().toString();

        if (inputText.isEmpty()) {
            Toast.makeText(this, "Please enter a value", Toast.LENGTH_SHORT).show();
            return;
        }

        double input = Double.parseDouble(inputText);
        double result = UnitConverter.convert(fromUnit, toUnit, input);

        if (Double.isNaN(result)) {
            Toast.makeText(this, "Invalid conversion", Toast.LENGTH_SHORT).show();
        } else {
            resultView.setText(String.format("%.2f %s", result, toUnit));
        }
    }
}

