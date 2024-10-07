# Program for Passing Data from one activity using form for calculating the sum of two number and displaying result in TextView

**Name**: Program for Passing Data from one activity using form for calculating the sum of two number and displaying result in TextView.

**Date**: October 7th, 2024

## Source Code

## calculator.java Code

```java
package com.example.gettingandsettingdatatoandfromlayoutfile;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class calculator extends Activity {
    protected void onCreate(Bundle b)
    {
        super.onCreate(b);
        setContentView(R.layout.calculator);
        Button btn = findViewById(R.id.btnadd);
        EditText number1 = findViewById(R.id.num1);
        EditText number2 = findViewById(R.id.num2);
        TextView result = findViewById(R.id.txtresult);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n1,n2,res;
                n1=Integer.parseInt(number1.getText().toString());
                n2 = Integer.parseInt(number2.getText().toString());
                res = n1+n2;
                result.setText("Result ="+res);
            }
        });
    }
}
```

## calculator.xml Code

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical">

    <EditText
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginTop="50dp"
        android:hint="Enter first number"
        android:id="@+id/num1">

    </EditText>

    <EditText
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Enter first number"
        android:id="@+id/num2">

    </EditText>
    <Button
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Add"
        android:layout_gravity="center"
        android:id="@+id/btnadd">

    </Button>
    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_gravity="center"
        android:id="@+id/txtresult">

    </TextView>

</LinearLayout>
```

## strings.xml File

```xml
<resources>
    <string name="app_name">Getting and Setting data to and from layout file</string>
</resources>
```

## Output

![ Program for Passing Data from one activity using form for calculating the sum of two number and displaying result in TextView.](./output.png)
