package com.example.febplay.view;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.lifecycle.ViewModelProvider;

import com.example.febplay.R;
import com.example.febplay.viewmodel.SecondViewModel;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;

public class SecondActivity extends AppCompatActivity {

    private SecondViewModel viewModel;
    private AppCompatEditText etDisplay;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        viewModel = new ViewModelProvider.AndroidViewModelFactory(getApplication())
                .create(SecondViewModel.class);
        etDisplay = findViewById(R.id.et_display);

        // Get saved text from shared preferences
        etDisplay.setText(viewModel.getStringData());

        // Save text from
        ((MaterialButton) findViewById(R.id.btn_save)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.saveStringData(etDisplay.getText().toString());
            }
        });
    }
}
