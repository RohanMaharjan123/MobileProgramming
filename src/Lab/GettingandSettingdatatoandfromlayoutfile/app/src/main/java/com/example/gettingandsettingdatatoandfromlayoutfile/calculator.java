package com.example.gettingandsettingdatatoandfromlayoutfile;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class calculator extends Activity {
    protected void onCreate(Bundle b)
    {
        super.onCreate(b);
        setContentView(R.layout.calculator);
        Button btn = findViewById(R.id.btnadd);
        EditText number1 = findViewById(R.id.num1);
        EditText number2 = findViewById(R.id.num2);
        TextView result = findViewById(R.id.txtresult);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n1,n2,res;
                n1=Integer.parseInt(number1.getText().toString());
                n2 = Integer.parseInt(number2.getText().toString());
                res = n1+n2;
                result.setText("Result ="+res);
            }
        });
    }
}