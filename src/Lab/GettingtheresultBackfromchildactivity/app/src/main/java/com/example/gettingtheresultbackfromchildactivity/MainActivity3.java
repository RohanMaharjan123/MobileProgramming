package com.example.gettingtheresultbackfromchildactivity;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        EditText num1Activity3=findViewById(R.id.editTextNum1InActivity3);
        EditText num2Activity3=findViewById(R.id.editTextNum2InActivity3);
        Button btnActivity3=findViewById(R.id.subButtonInActivity3);
        btnActivity3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int n1,n2,resActivity3;
                n1=Integer.parseInt(num1Activity3.getText().toString());
                n2=Integer.parseInt(num2Activity3.getText().toString());
                resActivity3=n1-n2;

                Intent resultIntent = new Intent();
                resultIntent.putExtra("resActivity3_key", resActivity3);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });

    }
}