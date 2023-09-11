package com.mrsoft.sharedpreference;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextName, editTextAge;
    private TextView textViewData;
    private Button buttonSave, buttonRetrieve;

    private SharedPreferencesHelper sharedPreferencesHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize SharedPreferencesHelper
        sharedPreferencesHelper = new SharedPreferencesHelper(this);

        // Bind UI elements
        editTextName = findViewById(R.id.edName);
        editTextAge = findViewById(R.id.edAge);
        textViewData = findViewById(R.id.tvDisplay);
        buttonSave = findViewById(R.id.btnSaveData);
        buttonRetrieve = findViewById(R.id.btnRetrive);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });

        buttonRetrieve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });
    }

    private void saveData() {
        String name = editTextName.getText().toString().trim();
        int age = Integer.parseInt(editTextAge.getText().toString().trim());


        sharedPreferencesHelper.saveData(name, age);

        Toast.makeText(this, "Data saved Successfully", Toast.LENGTH_SHORT).show();

        clearInputFields();
    }



    private void clearInputFields() {
        editTextName.setText("");
        editTextAge.setText("");
    }
}
