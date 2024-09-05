package com.example.intentactivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
    protected void onCreate(Bundle b)
    {
        super.onCreate(b);
        setContentView(R.layout.activity_main);  // Replace 'activity_main' with the actual layout file name
        EditText enteredurl = findViewById(R.id.urlid);
        Button visitbtn = findViewById(R.id.visitbtnid);

        visitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String myurl = enteredurl.getText().toString();
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(myurl));
                startActivity(i);
            }
        });
    }
}