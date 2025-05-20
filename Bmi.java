package com.example.fitnessapp20;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Bmi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bmi);

        };



    public double calculateBMI(double weightKg, double heightCm) {
        double heightM = heightCm / 100.0;
        return weightKg / (heightM * heightM);
    }
}