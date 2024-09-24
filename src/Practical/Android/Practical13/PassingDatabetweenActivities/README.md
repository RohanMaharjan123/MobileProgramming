# Program for Implementing Passing Multiple Data between Activities

**Name**: Program for Implementing Passing Multiple Data between Activities

**Date**: September 24th, 2024

## Source Code

## PassData.java Code

```java
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
```

## ReceiveData.java Code

```java
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
```

## passdata.xml Code

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical">

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_gravity="center"
        android:layout_marginTop="40dp"
        android:text="Enter your information">

    </TextView>
    <EditText
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_gravity="center"
        android:id="@+id/idname"
        android:layout_marginTop="20dp"
        android:hint="Enter Your Name">
    </EditText>
    <EditText
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_gravity="center"
        android:id="@+id/idaddr"
        android:hint="Enter Your Address">
    </EditText>
    <EditText
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_gravity="center"
        android:id="@+id/idphn"
        android:hint="Enter Your Phone Number">
    </EditText>
    <Button
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_gravity="center"
        android:id="@+id/btnsub"
        android:text="submit">

    </Button>

</LinearLayout>
```

## receivedata.xml

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical">
    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="40dp"
        android:text="My Information:"
        android:layout_gravity="center">
    </TextView>
    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="40dp"
        android:id="@+id/myinfo"
        android:layout_gravity="center">
    </TextView>

</LinearLayout>

```

## strings.xml File

```xml
<resources>
    <string name="app_name">Passing Data between Activities</string>
</resources>
```

## Output

![Program for Implementing Passing Multiple Data between Activities](./output.png)
