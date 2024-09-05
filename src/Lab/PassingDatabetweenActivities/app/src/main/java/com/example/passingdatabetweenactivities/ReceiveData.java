package com.example.passingdatabetweenactivities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ReceiveData extends Activity {
    protected void onCreate(Bundle b)
    {
        super.onCreate(b);
        setContentView(R.layout.receivedata);

        TextView receivedata = findViewById(R.id.myinfo);

        Intent in = getIntent();

        String name = in.getStringExtra("name_key");
        String address = in.getStringExtra("address_key");
        String phone = in.getStringExtra("phone_key");

        receivedata.setText("Name = "+ name +"\n Address = "+address+"\n Phone No = "+phone);

    }
}