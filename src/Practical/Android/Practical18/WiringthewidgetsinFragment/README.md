# Program for wiring the widgets in  Fragment

**Name**: Program for wiring the widgets in  Fragment

**Date**: October 10th, 2024

## Source Code

## GreenFragment.java Code

```java
package com.example.wiringthewidgetsinfragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class GreenFragment extends Fragment {

    public GreenFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.green_fragment, container, false);
    }
}

```

## MainActivity.java Code

```java
package com.example.wiringthewidgetsinfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnRed = findViewById(R.id.idred);
        Button btnGreen = findViewById(R.id.idgreen);
        TextView placeholderText = findViewById(R.id.placeholder_text);

        btnRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                placeholderText.setVisibility(View.GONE); 
                loadFragment(new RedFragment());
            }
        });

        btnGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                placeholderText.setVisibility(View.GONE); 
                loadFragment(new GreenFragment());
            }
        });
    }

    private void loadFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();

        FragmentTransaction ft = fm.beginTransaction();

        ft.replace(R.id.fragment_container, fragment);
        ft.addToBackStack(null);

        ft.commit();
    }
}
```

## RedFragment.java Code

```java
package com.example.wiringthewidgetsinfragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class RedFragment extends Fragment {

    public RedFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.red_fragment, container, false);
    }
}
```

## activity_main.xml Code

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical">

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Dynamic Layout"
        android:textStyle="italic"
        android:textSize="30dp"
        android:layout_gravity="center" />

    <LinearLayout
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:orientation="horizontal"
        android:layout_marginTop="10dp"
        android:layout_gravity="center">

        <Button
            android:id="@+id/idred"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Red Fragment"
            android:layout_gravity="center" />

        <Button
            android:id="@+id/idgreen"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Green Fragment"
            android:layout_gravity="center" />
    </LinearLayout>

    <FrameLayout
        android:id="@+id/fragment_container"
        android:layout_width="match_parent"
        android:layout_height="0dp"
        android:layout_weight="1">

        <!-- Placeholder TextView -->
        <TextView
            android:id="@+id/placeholder_text"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Welcome to Dynamic Layout"
            android:textStyle="italic"
            android:textSize="30dp"
            android:layout_gravity="center" />
    </FrameLayout>
</LinearLayout>
```

## green_fragment.xml Code

```xml
<?xml version="1.0" encoding="utf-8"?>
<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".GreenFragment">

    <TextView
        android:id="@+id/greenfrag"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Welcome to Green Fragment"
        android:textColor="@color/black"
        android:textSize="20sp"
        android:layout_gravity="center"/>
</FrameLayout>
```

## red_fragment.xml Code

```xml
<?xml version="1.0" encoding="utf-8"?>
<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".RedFragment">

    <TextView
        android:id="@+id/redfrag"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Welcome to Red Fragment"
        android:textColor="@color/black"
        android:textSize="20sp"
        android:layout_gravity="center"/>
</FrameLayout>
```

## strings.xml File

```xml
<resources>
    <string name="app_name">Wiring the widgets in Fragment</string>
</resources>
```

## Output

![Program for wiring the widgets in  Fragment](./output.png)
