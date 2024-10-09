# Program for creating UI using Fragment

**Name**: Program for creating UI using Fragment

**Date**: October 9th, 2024

## Source Code

## AFragment.java Code

```java
package com.example.fragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class AFragment extends Fragment {
    public AFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_a, container, false);
        TextView t1 = v.findViewById(R.id.t1);
        return v;
    }
}
```

## BFragement.java Code

```java
package com.example.fragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class BFragment extends Fragment {
    public BFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_b, container, false);
        TextView t2 = v.findViewById(R.id.t2);
        return v;
    }
}
```

## MainActivity.java Code

```java
package com.example.fragment;

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
    tools:context=".MainActivity"
    android:orientation="vertical">

    <fragment
        android:id="@+id/frag1"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_weight="1"
        android:name="com.example.fragment.AFragment"
        />

    <fragment
        android:id="@+id/frag2"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_weight="1"
        android:name="com.example.fragment.BFragment"
        />
</LinearLayout>
```

## fragment_a.xml Code

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".AFragment"
    android:orientation="vertical"
    android:padding="16dp">

    <TextView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="@string/t1"
        android:id="@+id/t1"
        android:layout_marginTop="32dp" />
</LinearLayout>
```

## fragment_b.xml Code

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".BFragment"
    android:orientation="vertical"
    android:padding="16dp">

    <TextView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="@string/t2"
        android:id="@+id/t2" />
</LinearLayout>
```

## strings.xml File

```xml
<resources>
    <string name="app_name">Fragment</string>
    <!-- TODO: Remove or change this placeholder text -->
    <string name="hello_blank_fragment">Hello blank fragment</string>
    <string name="f1">F1 Soft Fragment</string>
    <string name="t1">Text view one Fragment inside the fragment1 of main activity.</string>
    <string name="f2">F2Soft Fragment</string>
    <string name="t2">Text view two Fragment inside the fragment2 of main activity.</string>
</resources>
```

## Output

![Program for creating UI using Fragment.](./output.png)
