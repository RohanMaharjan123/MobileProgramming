# Program for Implementing AndroidLifeCycle in Android Studio and Viewing on Logcat

**Name**: Program for Implementing AndroidLifeCycle in Android Studio and Viewing on Logcat

**Date**: September 23th, 2024

## Source Code

## MainActivity.java Code

```java
package com.example.androidlifecycle_4;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;

public class MainActivity extends Activity {

    private static final String TAG = "LifeCycle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate invoked");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart invoked");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume invoked");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause invoked");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop invoked");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart invoked");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy invoked");
    }
}
```

## xml Code

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Unit-4 Android Lifecycle"
        android:textSize="20sp"
        />

</LinearLayout>
```

## strings.xml File

```xml
<resources>
    <string name="app_name">AndroidLifecycle-4</string>
</resources>
```

## Output

![Program for Implementing AndroidLifeCycle in Android Studio and Viewing on Logcat](./output.png)
