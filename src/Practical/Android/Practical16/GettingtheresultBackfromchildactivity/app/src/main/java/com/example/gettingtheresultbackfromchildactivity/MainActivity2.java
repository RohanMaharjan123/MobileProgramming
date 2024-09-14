package com.example.gettingtheresultbackfromchildactivity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        EditText num1Activity2 = findViewById(R.id.editTextNum1InActivity2);
        EditText num2Activity2 = findViewById(R.id.editTextNum2InActivity2);
        Button btnActivity2 = findViewById(R.id.addButtonInActivity2);

        // Using lambda expression for the OnClickListener
        btnActivity2.setOnClickListener(v -> {
            try {
                // Get the input from EditText fields and convert them to integers
                int n1 = Integer.parseInt(num1Activity2.getText().toString());
                int n2 = Integer.parseInt(num2Activity2.getText().toString());

                // Perform the addition
                int resActivity2 = n1 + n2;

                // Create an Intent to send the result back to MainActivity
                Intent resultIntent = new Intent();
                resultIntent.putExtra("resActivity2_key", resActivity2);

                // Set the result to RESULT_OK and finish the activity
                setResult(RESULT_OK, resultIntent);
                finish();

            } catch (NumberFormatException e) {
                // Show a toast message if invalid input is entered (non-integer or empty)
                Toast.makeText(MainActivity2.this, "Please enter valid numbers", Toast.LENGTH_SHORT).show();
            }
        });
    }
}