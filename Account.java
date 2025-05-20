package com.example.fitnessapp20;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.firebase.auth.FirebaseAuth;

public class Account extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private GoogleSignInClient mGoogleSignInClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_account);

        mAuth = FirebaseAuth.getInstance();

        // Configure sign out client
        mGoogleSignInClient = com.google.android.gms.auth.api.signin.GoogleSignIn.getClient(this,
                new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                        .requestIdToken(getString(R.string.default_web_client_id))
                        .requestEmail()
                        .build());

        TextView emailView = findViewById(R.id.textEmail);
        Button signOutBtn = findViewById(R.id.btnSignOut);

        if (mAuth.getCurrentUser() != null) {
            emailView.setText(mAuth.getCurrentUser().getEmail());
        }

        signOutBtn.setOnClickListener(v -> {
            mAuth.signOut();
            mGoogleSignInClient.signOut().addOnCompleteListener(task -> {
                // Go back to login screen
                Intent intent = new Intent(Account.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            });
        });
    }
}
