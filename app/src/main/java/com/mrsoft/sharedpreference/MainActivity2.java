package com.mrsoft.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    TextView tvREsult;

    public SharedPreferencesHelper sharedPreferencesHelper;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tvREsult = findViewById(R.id.tvREsult);

        sharedPreferencesHelper = new SharedPreferencesHelper(this);



        retrieveData();



    }

    private void retrieveData() {
        displayAllData();
    }

    private void displayAllData() {
        int counter = sharedPreferencesHelper.getCounter();
        StringBuilder dataStringBuilder = new StringBuilder();

        for (int i = 1; i < counter; i++) {
            String name = sharedPreferencesHelper.getName(i);
            int age = sharedPreferencesHelper.getAge(i);
            dataStringBuilder.append("").append(i).append(": ").append(name).append(", ").append(age).append("\n");
        }

        String allData = dataStringBuilder.toString();
        tvREsult.setText(allData);
    }




}