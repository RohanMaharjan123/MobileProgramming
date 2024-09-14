# Program for using Relative Layout making login form

**Name**: Program for using Linear Layout making login form

**Date**: September 14th, 2024

## Source Code

## MainActivity.java Code

```java
package com.example.relativelayout;

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
<RelativeLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <TextView
        android:id="@+id/tv1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Username:"
        android:textSize="20sp"
        android:layout_marginTop="20dp"
        android:layout_marginStart="20dp"
    />
    <EditText
        android:id="@+id/et1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:hint="Enter User Name"
        android:textSize="20sp"
        android:layout_marginStart="20dp"
        android:layout_marginEnd="20dp"
        android:layout_toEndOf="@+id/tv1"
        android:layout_alignBaseline="@+id/tv1"
    />

    <TextView
        android:id="@+id/tv2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Password:"
        android:textSize="20sp"
        android:layout_marginTop="20dp"
        android:layout_marginStart="20dp"
        android:layout_below="@+id/tv1"
        />
    <EditText
        android:id="@+id/et2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:hint="Type your password"
        android:textSize="20sp"
        android:layout_marginStart="20dp"
        android:layout_marginEnd="20dp"
        android:layout_toEndOf="@+id/tv1"
        android:layout_below="@+id/et1"
        android:layout_alignBaseline="@+id/tv2"
        />
    <Button
        android:id="@+id/btn_1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Login"
        android:textSize="20sp"
        android:layout_marginTop="200sp"
        android:layout_marginStart="50dp"
        android:backgroundTint="#FF2000F3"

        />
    <Button
        android:id="@+id/btn_2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Register"
        android:textSize="20sp"
        android:layout_marginStart="50dp"
        android:backgroundTint="#FF2000F3"
        android:layout_toEndOf="@+id/tv2"
        android:layout_marginTop="200dp"

        />

</RelativeLayout>
```

## strings.xml File

```xml
<resources>
    <string name="app_name">Relative Layout</string>
</resources>
```

## colors.xml File

```xml
<?xml version="1.0" encoding="utf-8"?>
<resources>
    <color name="black">#FF000000</color>
    <color name="white">#FFFFFFFF</color>
</resources>
```

## themes.xml File

```xml
<resources xmlns:tools="http://schemas.android.com/tools">
    <!-- Base application theme. -->
    <style name="Base.Theme.RelativeLayout" parent="Theme.Material3.DayNight.NoActionBar">
        <!-- Customize your light theme here. -->
        <!-- <item name="colorPrimary">@color/my_light_primary</item> -->
    </style>

    <style name="Theme.RelativeLayout" parent="Base.Theme.RelativeLayout" />
</resources>
```

## Output

![Program  for using Linear Layout with Toast method for displaying name after clicking it.](./output.png)