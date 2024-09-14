package com.example.wiringthewidgetsinfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnRed = findViewById(R.id.idred);
        Button btnGreen = findViewById(R.id.idgreen);
        TextView placeholderText = findViewById(R.id.placeholder_text);

        btnRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                placeholderText.setVisibility(View.GONE); // Hide the placeholder text
                loadFragment(new RedFragment());
            }
        });

        btnGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                placeholderText.setVisibility(View.GONE); // Hide the placeholder text
                loadFragment(new GreenFragment());
            }
        });
    }

    private void loadFragment(Fragment fragment) {
        // Create a FragmentManager
        FragmentManager fm = getSupportFragmentManager();

        // Create a FragmentTransaction to begin the transaction and replace the Fragment
        FragmentTransaction ft = fm.beginTransaction();

        // Replace the FrameLayout with the new Fragment
        ft.replace(R.id.fragment_container, fragment);
        ft.addToBackStack(null);

        // Commit the transaction
        ft.commit();
    }
}