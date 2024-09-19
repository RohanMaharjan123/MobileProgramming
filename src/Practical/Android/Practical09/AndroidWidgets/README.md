# Program for using Widgets on layout

**Name**: Program for using Widgets on layout

**Date**: September 19th, 2024

## Source Code

## MainActivity.java Code

```java
package com.example.androidwidgets;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
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
    android:paddingRight="20dp"
    android:paddingLeft="20dp"
    tools:context=".MainActivity">

    <TableRow>
        <TextView
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:text="Subjects:"
            android:gravity="start"/>
        <CheckBox
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:text="C#"/>
        <CheckBox
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:text="Java"/>
    </TableRow>

    <TableRow>
        <TextView
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:text="Sex"
            android:gravity="start"/>
        <RadioButton
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:text="Male"/>
        <RadioButton
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:text="Female"/>
    </TableRow>

    <TableRow>
        <TextView
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:text="Select the items"
            android:gravity="start"/>
        <Spinner
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_weight="2"
            android:entries="@array/spinner_item"
            android:spinnerMode="dropdown"/>
    </TableRow>

    <TableRow>
        <ToggleButton
            android:layout_width="match_parent"
            android:layout_height="wrap_content"/>
    </TableRow>

    <TableRow>
        <RatingBar
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"/>
    </TableRow>

    <TableRow>
        <ProgressBar
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"/>
    </TableRow>
</TableLayout>
```

## strings.xml File

```xml
<resources>
    <string name="app_name">TableLayout</string>
    <string-array name="spinner_item">
        <item>Item-1</item>
        <item>Item-2</item>
        <item>Item-3</item>
        <item>Item-4</item>
        <item>Item-5</item>
    </string-array>
</resources>
```

## Output

![Program for using Widgets on layout](./output.png)
