package com.example.eventhandling0;

import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView t ;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        b = (Button)findViewById(R.id.btn1);
        b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                t = (TextView)findViewById(R.id.tv2);
                t.setText("On Click Event Activated");
            }
        });
    }
}
