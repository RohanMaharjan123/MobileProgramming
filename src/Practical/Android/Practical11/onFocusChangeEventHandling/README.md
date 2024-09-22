# Program for using onFocusChange EventHandling

**Name**: Program for using onFocusChange EventHandling

**Date**: September 22th, 2024

## Source Code

## MainActivity.java Code

```java
package com.example.onfocuschangeeventhandling;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText ed1 = findViewById(R.id.e1);
        EditText ed2 = findViewById(R.id.e2);

        ed1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    Toast.makeText(getApplicationContext(), "Enter your user name", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "User name input completed", Toast.LENGTH_SHORT).show();
                }
            }
        });

        ed2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    Toast.makeText(getApplicationContext(), "Enter your password", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Password input completed", Toast.LENGTH_SHORT).show();
                }
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
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:padding="16dp"
    tools:context=".MainActivity">

    <TableRow
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginBottom="16dp">
        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="User Name:"
            android:textSize="20sp"/>
        <EditText
            android:id="@+id/e1"
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:hint="Enter user name"
            android:textSize="18sp"
            android:inputType="textPersonName"
            android:contentDescription="Enter user name"/>
    </TableRow>

    <TableRow
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginBottom="16dp">
        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Password:"
            android:textSize="20sp"/>
        <EditText
            android:id="@+id/e2"
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:hint="Enter password"
            android:textSize="18sp"
            android:inputType="textPassword"
            android:contentDescription="Enter password"/>
    </TableRow>

    <TableRow
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:gravity="center_horizontal">
        <Button
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Submit"
            android:textSize="20sp"
            android:contentDescription="Submit button"/>
    </TableRow>
</TableLayout>
```

## strings.xml File

```xml
<resources>
    <string name="app_name">onFocusChangeEventHandling</string>
</resources>
```

## Output

![Program for using onFocusChange EventHandling](./output.png)
