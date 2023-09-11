package com.mrsoft.sharedpreference;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesHelper {
    private static final String PREFS_NAME = "MyPrefs";
    private static final String KEY_COUNTER = "counter";

    private SharedPreferences sharedPreferences;

    public SharedPreferencesHelper(Context context) {
        sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
    }

    public void saveData(String name, int age) {
        int counter = getCounter();
        String keyName = "KEY_NAME_" + counter;
        String keyAge = "KEY_AGE_" + counter;

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(keyName, name);
        editor.putInt(keyAge, age);
        editor.putInt(KEY_COUNTER, counter + 1);
        editor.apply();
    }

    public int getCounter() {
        return sharedPreferences.getInt(KEY_COUNTER, 1);
    }

    public String getName(int index) {
        String keyName = "KEY_NAME_" + index;
        return sharedPreferences.getString(keyName, "");
    }

    public int getAge(int index) {
        String keyAge = "KEY_AGE_" + index;
        return sharedPreferences.getInt(keyAge, 0);
    }
}
