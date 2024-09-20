# Program for using EventHandlng with on click method

**Name**: Program for using EventHandlng with on click method

**Date**: September 20th, 2024

## Source Code

## MainActivity.java Code

```java
package com.example.eventhandling;

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


        b = (Button) findViewById(R.id.btn1);
        b.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                t = (TextView) findViewById(R.id.tv2);
                t.setText("Long Click Activated");
                return false;
            }
        });
    }
}
```

## xml Code

```xml
<?xml version="1.0" encoding="utf-8"?>
<TableLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">
    <TableRow
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_margin="10dp">
       <TextView
           android:id="@+id/tv1"
           android:layout_width="wrap_content"
           android:layout_height="wrap_content"
           android:text="On Click Long Event Handler Demo"
           android:textSize="20sp"
           android:gravity="center"
           android:layout_column="2"
           />
    </TableRow>
    <TableRow
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_margin="10dp">
        <Button
            android:id="@+id/btn1"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Click"
            android:textSize="20sp"
            android:backgroundTint="#00BCD4"
            android:layout_column="2"
            />
    </TableRow>
    <TableRow
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_margin="10dp">
        <TextView
            android:id="@+id/tv2"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Result"
            android:textSize="20sp"
            android:gravity="center"
            android:layout_column="2"
            />
    </TableRow>
</TableLayout>
```

## strings.xml File

```xml
<resources>
    <string name="app_name">Event Handling</string>
</resources>
```

## Output

![Program for using EventHandlng with on click method](./output.png)
