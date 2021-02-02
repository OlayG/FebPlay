package com.example.febplay.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.febplay.R;
import com.google.android.material.button.MaterialButton;

public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener {

    private MaterialButton btnSave2,btnSave3,btnSave4;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        findViewById(R.id.btn_save).setOnClickListener(this);

        btnSave2 = findViewById(R.id.btn_save2);
        btnSave3 = findViewById(R.id.btn_save3);
        btnSave4 = findViewById(R.id.btn_save4);
        btnSave2.setOnClickListener(this);
        btnSave3.setOnClickListener(this);
        btnSave4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_save:
                 somethingCrazy();
                break;
            case R.id.btn_save3:
                Toast.makeText(this, "Save ODD", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_save2:
            case R.id.btn_save4:
                String num = ((MaterialButton) v).getText().toString();
                // set num to textview
                Toast.makeText(this, "SAVE EVEN", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private void somethingCrazy() {

    }
}
