# Program for creating a GridView

**Name**: Program for creating a GridView

**Date**: October 14th, 2024

## Source Code

## MainActivity.java Code

```java
package com.example.gridview;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    GridView g;
    String myarray[]={"\nRoyal Enfield", "Ducati Panigale V4", "BMW S 1000 RR", "Ducati Streetfighter V4","Kawasaki Ninja ZX-10R", "Jawa 42 Bobber", "Harley Davidson Road Glide "};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        g = (GridView) findViewById(R.id.grid);
        ArrayAdapter<String>  arr = new ArrayAdapter<String>(this, R.layout.layout_grid, R.id.tv1, myarray);
        g.setAdapter(arr);
    }
}
```

## activity_main.xml Code

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context=".MainActivity">

    <TextView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="List of Bikes"
        android:textAlignment="center"
        android:layout_gravity="center"
        android:padding="10dp"
        android:textSize="18sp"
        android:textStyle="bold"/>

    <GridView
        android:layout_width="match_parent"
        android:layout_height="0dp"
        android:id="@+id/grid"
        android:numColumns="2"
        android:layout_weight="1"
        android:horizontalSpacing="10dp"
        android:verticalSpacing="10dp"
        android:padding="10dp"/>
</LinearLayout>
```

## layout_grid.xml Code

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:padding="10dp"
    android:gravity="center">

    <TextView
        android:id="@+id/tv1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:padding="5dp"
        android:textSize="16sp"
        android:textAlignment="center"/>
</LinearLayout>
```

## strings.xml File

```xml
<resources>
    <string name="app_name">GridView</string>
</resources>
```

## Output

![Program for creating a GridView](./output.png)
