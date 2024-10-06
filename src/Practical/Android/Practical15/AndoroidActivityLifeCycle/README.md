# Program for Passing Data between Activities in Android Activity LifeCycle

**Name**: Program for Passing Data between Activities in Android Activity LifeCycle

**Date**: October 6th, 2024

## Source Code

## MainActivity.java Code

```java
package com.example.andoroidactivitylifecycle;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                startActivity(intent);
            }
        });
    }

}
```

## MainActivity2.java Code

```java
package com.example.andoroidactivitylifecycle;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;


public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);
            }
        });
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
    tools:context=".MainActivity">

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="This is the First Activity!"
        />

    <Button
        android:id="@+id/button1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Go to Second Activity"
        />
</LinearLayout>
```

## activity_main2.xml Code

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity2">


    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="This is the second activity!"
        />

    <Button
        android:id="@+id/button2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Go to First Activity"
        />
</LinearLayout>
```

## fragment_main.xml Code

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/constraintLayout"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".ui.main.PlaceholderFragment">

    <TextView
        android:id="@+id/section_label"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="@dimen/activity_horizontal_margin"
        android:layout_marginTop="@dimen/activity_vertical_margin"
        android:layout_marginEnd="@dimen/activity_horizontal_margin"
        android:layout_marginBottom="@dimen/activity_vertical_margin"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintTop_toTopOf="@+id/constraintLayout"
        tools:layout_constraintLeft_creator="1"
        tools:layout_constraintTop_creator="1" />

</androidx.constraintlayout.widget.ConstraintLayout>
```

## strings.xml File

```xml
<resources>
    <string name="app_name">AndoroidActivityLifeCycle</string>
    <string name="title_activity_main2">MainActivity2</string>
    <string name="tab_text_1">Tab 1</string>
    <string name="tab_text_2">Tab 2</string>
</resources>
```

## Output

![Program for Passing Data between Activities in Android Activity LifeCycle](./output.png)
