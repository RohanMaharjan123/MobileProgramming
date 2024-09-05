package com.example.gettingtheresultbackfromchildactivity;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE_ADD = 1;
    private static final int REQUEST_CODE_SUB = 2;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTextView = findViewById(R.id.result);

        Button addBut = findViewById(R.id.addButton);
        addBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, MainActivity2.class);
                startActivityForResult(i, REQUEST_CODE_ADD);
            }
        });

        Button subBut = findViewById(R.id.subButton);
        subBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, MainActivity3.class);
                startActivityForResult(i, REQUEST_CODE_SUB);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            int result = 0;
            if (data != null) {
                switch (requestCode) {
                    case REQUEST_CODE_ADD:
                        result = data.getIntExtra("resActivity2_key", 0);
                        resultTextView.setText("Add Result: " + result);
                        break;
                    case REQUEST_CODE_SUB:
                        result = data.getIntExtra("resActivity3_key", 0);
                        resultTextView.setText("Sub Result: " + result);
                        break;
                }
            }
        }
    }

}