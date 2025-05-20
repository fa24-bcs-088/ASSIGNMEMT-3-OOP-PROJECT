package com.example.fitnessapp20;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Calories extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calories);

    }

    public static double calculateCalories(String gender, int age, double weightKg, double heightCm) {
        if (gender.equalsIgnoreCase("male")) {
            return 10 * weightKg + 6.25 * heightCm - 5 * age + 5;
        } else {
            return 10 * weightKg + 6.25 * heightCm - 5 * age - 161;
        }
    }
}