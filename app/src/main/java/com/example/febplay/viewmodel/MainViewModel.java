package com.example.febplay.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 *                  ViewModel
 *  - Lifecycle aware (it knows when VIEW is going through a config change
 *      and it holds the data while the VIEW recreates)
 */
public class MainViewModel extends ViewModel {

    /**
     *                  MutableLiveData && LiveData
     *
     * LiveData -> Generic DataHolder that uses Observer Pattern. READ only
     * MutableLiveData -> Same as LiveData but is READ & WRITE
     *
     */
    private MutableLiveData<Float> _sum = new MutableLiveData<Float>();


    /**
     * Provides a READ only data observer for the sum
     *
     */
    public LiveData<Float> getSum() {
        return _sum;
    }


    public void calculateSum(Float num1, Float num2) {
        _sum.setValue(num1 + num2);
    }

}
