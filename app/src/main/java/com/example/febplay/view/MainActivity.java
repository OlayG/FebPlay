package com.example.febplay.view;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.febplay.R;
import com.example.febplay.viewmodel.MainViewModel;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;

import java.util.Locale;

/**
 * MVC, MVP, REDUX, CLEAN Architecture
 * MVVM [Model View ViewModel]
 * <p>
 * MVVM is a architecture pattern we use to organize or code to become more decoupled and testable
 * <p>
 * Model - data/pojo class
 * *Repository* - Layer between Model and ViewModel, allows us to manage our local and server data
 * ViewModel - Logic for data
 * View - What users see and interacts with
 */

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    // Declare our views
    private AppCompatEditText etNumOne, etNumTwo;
    private MaterialButton btnEnter;
    private MaterialTextView tvResult;

    // Declare viewmodel
    private MainViewModel viewModel;

    /**
     * Lifecycle 1: Entry point, we create any components we need here
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // This line right here, allows the parent to still run its method details
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: ");
        setContentView(R.layout.activity_main);

        // Initialize our views
        initViews();

        // Initialize viewModel
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        // Observe data
        viewModel.getSum().observe(this, new Observer<Float>() {
            @Override
            public void onChanged(Float sum) {
                String sumString = sum.toString();
                tvResult.setText(sumString);
            }
        });
    }

    private void initViews() {
        etNumOne = findViewById(R.id.et_num_one);
        etNumTwo = findViewById(R.id.et_num_two);
        btnEnter = findViewById(R.id.btn_enter);
        tvResult = findViewById(R.id.tv_result);

        btnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float num1 = 0f;
                if (etNumOne.getText() != null)
                    num1 = Float.parseFloat(etNumOne.getText().toString());
                float num2 = 0f;
                if (etNumTwo.getText() != null)
                    num2 = Float.parseFloat(etNumTwo.getText().toString());

                viewModel.calculateSum(num1, num2);
            }
        });
    }

    /**
     * Lifecycle 2: Activity is now visible to user, here we can start listeners
     */
    @Override
    protected void onStart() {
        super.onStart();
    }

    /**
     * Lifecycle 3: User can now interact with the Activity,
     */
    @Override
    protected void onResume() {
        super.onResume();
    }

    /**
     * Lifecycle 4: Activity is leaving foreground
     */
    @Override
    protected void onPause() {
        super.onPause();
    }

    /**
     * Lifecycle 5: Activity is being moved to background
     */
    @Override
    protected void onStop() {
        super.onStop();
    }

    /**
     * Lifecycle 6: Activity is being moved back to foreground
     */
    @Override
    protected void onRestart() {
        super.onRestart();
    }

    /**
     * Lifecycle 7: Activity was killed
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}