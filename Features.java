package com.example.fitnessapp20;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Features extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_features);


        // Image click listeners
        ImageView img1 = findViewById(R.id.imageView8);
        ImageView img2 = findViewById(R.id.imageView9);
        ImageView img3 = findViewById(R.id.imageView10);
        ImageView img4 = findViewById(R.id.imageView11);

        img1.setOnClickListener(v-> startActivity(new Intent(Features.this, Bmi.class)));
        img2.setOnClickListener(v -> startActivity(new Intent(Features.this, Calories.class)));
        img3.setOnClickListener(v -> startActivity(new Intent(Features.this, WaterIntake.class)));
        img4.setOnClickListener(v -> startActivity(new Intent(Features.this, FatCalculator.class)));

// Inside onCreate() of features.java:
        TextView profileIcons = findViewById(R.id.profileIcon);

// Get current Firebase user
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        if (user != null) {
            String name = user.getDisplayName();
            String email = user.getEmail();

            // Fallback logic: use first letter of name or email
            String initial = "U"; // Default
            if (name != null && !name.isEmpty()) {
                initial = name.substring(0, 1).toUpperCase();
            } else if (email != null && !email.isEmpty()) {
                initial = email.substring(0, 1).toUpperCase();
            }

            profileIcons.setText(initial);
        }


        profileIcons.setOnClickListener(v -> {
            Intent intent = new Intent(Features.this, Account.class);
            startActivity(intent);
        });


    }
}







