# Program for creating a ListView

**Name**: Program for creating a ListView

**Date**: October 13th, 2024

## Source Code

## MainActivity.java Code

```java
package com.example.listview;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    ListView l ;
    String myarray[]={"\nRoyal Enfield", "Ducati Panigale V4", "BMW S 1000 RR", "Ducati Streetfighter V4","Kawasaki Ninja ZX-10R", "Jawa 42 Bobber", "Harley Davidson Road Glide "};

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        l = findViewById(R.id.mylistview);
        ArrayAdapter<String> arr = new ArrayAdapter<String>(this, R.layout.list_item ,R.id.mytextview, myarray);
        l.setAdapter(arr);
    }
}
```

## activity_main.xml Code

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity"
    android:orientation="vertical"
    >

    <TextView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="List of Bikes"
        android:layout_gravity="center"
        />
        <ListView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:id="@+id/mylistview"
            />
</LinearLayout>
```

## list_item.xml Code

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:id="@+id/mytextview"
        />
</LinearLayout>
```

## strings.xml File

```xml
<resources>
    <string name="app_name">ListView</string>
</resources>
```

## Output

![Program for creating a ListView](./output.png)
