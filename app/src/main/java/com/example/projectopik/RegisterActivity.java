package com.example.projectopik;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    private EditText nameEditText, emailEditText, passwordEditText, confirmPasswordEditText;
    private Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        emailEditText = findViewById(R.id.email);
        passwordEditText = findViewById(R.id.password);
        registerButton = findViewById(R.id.button);

        registerButton.setOnClickListener(v -> registerUser());
    }

    public void registerUser() {
        // Get the values from the fields
        String name = nameEditText.getText().toString().trim();
        String email = emailEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();
        String confirmPassword = confirmPasswordEditText.getText().toString().trim();

        // Check if any field is empty
        if (name.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            // Display alert if any field is empty
            Toast.makeText(this, "All fields must be filled!", Toast.LENGTH_SHORT).show();
        } else {
            // Check if passwords match
            if (!password.equals(confirmPassword)) {
                // Display alert if passwords don't match
                Toast.makeText(this, "Passwords do not match!", Toast.LENGTH_SHORT).show();
            } else {
                // Simulate a successful registration
                // Here, you would save the user data to the database or server
                // For now, show a success message and redirect to the login screen

                new AlertDialog.Builder(this)
                        .setTitle("Registration Successful")
                        .setMessage("You have registered successfully. Do you want to login now?")
                        .setPositiveButton("OK", (dialog, which) -> {
                            // Redirect to Login screen
                            Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish();  // Close the RegisterActivity
                        })
                        .setNegativeButton("Cancel", null)
                        .show();
            }
        }
    }

    public void login(View view) {
        // Redirect to Login activity
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
