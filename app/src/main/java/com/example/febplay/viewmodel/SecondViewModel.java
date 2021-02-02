package com.example.febplay.viewmodel;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.febplay.R;

public class SecondViewModel extends AndroidViewModel {
    private static final String STRING_DATA_KEY = "STRING_DATA_KEY";

    private final SharedPreferences sharedPref = getApplication().getSharedPreferences(
            getApplication().getString(R.string.preference_file_key), Context.MODE_PRIVATE);


    public SecondViewModel(@NonNull Application application) {
        super(application);
    }

    public void saveStringData(String data) {
        sharedPref.edit().putString(STRING_DATA_KEY, data).apply();
    }

    public String getStringData() {
        return sharedPref.getString(STRING_DATA_KEY, "");
    }
}
