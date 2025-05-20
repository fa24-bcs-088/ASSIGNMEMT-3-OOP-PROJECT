package com.example.fitnessapp20;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class WaterIntake extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_waterintake);

    }


    public double calculateWaterIntake(double weightKg) {
        return weightKg * 0.033; // 33 ml per kg of body weight
    }
}