# Program for Implementing Implicit activity between Activities

**Name**: Program for Implementing Implicit activity between Activities

**Date**: September 24th, 2024

## Source Code

## MainActivity.java Code

```java
package com.example.intentactivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
    protected void onCreate(Bundle b)
    {
        super.onCreate(b);
        setContentView(R.layout.activity_main);  // Replace 'activity_main' with the actual layout file name
        EditText enteredurl = findViewById(R.id.urlid);
        Button visitbtn = findViewById(R.id.visitbtnid);

        visitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String myurl = enteredurl.getText().toString();
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(myurl));
                startActivity(i);
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
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="16dp">

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Enter Your URL below"
        android:layout_gravity="center"
        android:layout_marginTop="40dp"/>

    <EditText
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:id="@+id/urlid"
        android:hint="Enter your site URL"
        android:inputType="textUri"
        android:layout_marginTop="16dp"
        />

    <Button
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Visit"
        android:id="@+id/visitbtnid"
        android:layout_gravity="center"
        android:layout_marginTop="16dp"/>
</LinearLayout>
```

## strings.xml File

```xml
<resources>
    <string name="app_name">Intent Activity</string>
</resources>
```

## Output

![Program for Implementing Implicit activity between Activities](./output.png)
