package com.example.passingdatabetweenactivities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PassData extends Activity {
    protected void onCreate(Bundle b)
    {
        super.onCreate(b);
        setContentView(R.layout.passdata);

        EditText myname = findViewById(R.id.idname);
        EditText myaddr = findViewById(R.id.idaddr);
        EditText myphon = findViewById(R.id.idphn);
        Button btnsend = findViewById(R.id.btnsub);

        btnsend.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                String sendname = myname.getText().toString();
                String sendaddr = myaddr.getText().toString();
                String sendphn = myphon.getText().toString();

                Intent intent = new Intent(getApplicationContext(),ReceiveData.class);

                intent.putExtra("name_key",sendname);
                intent.putExtra("address_key",sendaddr);
                intent.putExtra("phone_key",sendphn);

                startActivity(intent);
            }
        });
    }
}
