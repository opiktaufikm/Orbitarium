package com.example.projectopik;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText emailEditText, passwordEditText;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Initialize the EditText and Button views
        emailEditText = findViewById(R.id.email);  // The EditText for email
        passwordEditText = findViewById(R.id.password);  // The EditText for password
        login = findViewById(R.id.login);  // The login button

        // Adjust the padding for system bars (status bar, navigation bar, etc.)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    // Handle the 'daftar' (register) button click
    public void daftar(View view) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    // Handle the 'login' button click
    public void login(View view) {
        // Get the email and password entered by the user
        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        // Check if the email and password are correct
        if (email.equals("opik@gmail.com") && password.equals("123")) {
            // Start the HomeActivity if the credentials match
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
        } else {
            // Show an error message as a toast notification
            Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show();
        }
    }
}
