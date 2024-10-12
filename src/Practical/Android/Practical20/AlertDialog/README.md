# Program for creating a AlertDialog

**Name**: Program for creating a AlertDialog

**Date**: October 12th, 2024

## Source Code

## MainActivity.java Code

```java
package com.example.alertdialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button mybutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mybutton=findViewById(R.id.btn1);
        mybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog obj=builderDialog();
                obj.show();

            }
        });

    }

    AlertDialog builderDialog()
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setMessage("Doyou want to delete?");

        builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "yes", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "no", Toast.LENGTH_SHORT).show();
            }
        });
        return builder.create();
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
        android:text="Alert dialog box demo"/>
    <Button
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="click here"
        android:id="@+id/btn1"
        />

</LinearLayout>
```

## strings.xml File

```xml
<resources>
    <string name="app_name">Alert Dialog</string>
</resources>
```

## Output

![Program for creating a AlertDialog](./output.png)
