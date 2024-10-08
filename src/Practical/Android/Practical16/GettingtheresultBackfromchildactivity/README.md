# Program for Passing Data from one activity for performing add and subtract operation based on user input

**Name**: Program for Passing Data from one activity for performing add and subtract operation based on user input

**Date**: October 8th, 2024

## Source Code

## MainActivity.java Code

```java
package com.example.gettingtheresultbackfromchildactivity;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE_ADD = 1;
    private static final int REQUEST_CODE_SUB = 2;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTextView = findViewById(R.id.result);

        Button addBut = findViewById(R.id.addButton);
        addBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, MainActivity2.class);
                startActivityForResult(i, REQUEST_CODE_ADD);
            }
        });

        Button subBut = findViewById(R.id.subButton);
        subBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, MainActivity3.class);
                startActivityForResult(i, REQUEST_CODE_SUB);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            int result = 0;
            if (data != null) {
                switch (requestCode) {
                    case REQUEST_CODE_ADD:
                        result = data.getIntExtra("resActivity2_key", 0);
                        resultTextView.setText("Add Result: " + result);
                        break;
                    case REQUEST_CODE_SUB:
                        result = data.getIntExtra("resActivity3_key", 0);
                        resultTextView.setText("Sub Result: " + result);
                        break;
                }
            }
        }
    }
}
```

## MainActivity2.java Code

```java
package com.example.gettingtheresultbackfromchildactivity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        EditText num1Activity2 = findViewById(R.id.editTextNum1InActivity2);
        EditText num2Activity2 = findViewById(R.id.editTextNum2InActivity2);
        Button btnActivity2 = findViewById(R.id.addButtonInActivity2);

        btnActivity2.setOnClickListener(v -> {
            try {
                int n1 = Integer.parseInt(num1Activity2.getText().toString());
                int n2 = Integer.parseInt(num2Activity2.getText().toString());

                int resActivity2 = n1 + n2;

                Intent resultIntent = new Intent();
                resultIntent.putExtra("resActivity2_key", resActivity2);

                setResult(RESULT_OK, resultIntent);
                finish();

            } catch (NumberFormatException e) {
                Toast.makeText(MainActivity2.this, "Please enter valid numbers", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
```

## MainActivity3.java Code

```java
package com.example.gettingtheresultbackfromchildactivity;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        EditText num1Activity3=findViewById(R.id.editTextNum1InActivity3);
        EditText num2Activity3=findViewById(R.id.editTextNum2InActivity3);
        Button btnActivity3=findViewById(R.id.subButtonInActivity3);
        btnActivity3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int n1,n2,resActivity3;
                n1=Integer.parseInt(num1Activity3.getText().toString());
                n2=Integer.parseInt(num2Activity3.getText().toString());
                resActivity3=n1-n2;

                Intent resultIntent = new Intent();
                resultIntent.putExtra("resActivity3_key", resActivity3);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });

    }
}
```

## activity_main.xml Code

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    xmlns:tools="http://schemas.android.com/tools"
    android:orientation="vertical"
    android:padding="16dp"
    tools:context=".MainActivity">

    <TextView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="@string/textViewDiplayMessage"
        android:gravity="center"
        android:textSize="24sp"
        android:textStyle="bold"
        android:textColor="#4CAF50"/>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal"
        android:gravity="center"
        android:paddingTop="16dp">

        <Button
            android:id="@+id/addButton"
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:text="Add"
            android:layout_marginEnd="16dp"/>

        <Button
            android:id="@+id/subButton"
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:text="Subtract"/>

    </LinearLayout>

    <TextView
        android:id="@+id/result"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Result will be displayed here"
        android:gravity="center"
        android:textSize="18sp"
        android:paddingTop="20dp"/>
</LinearLayout>
```

## activity_main2.xml Code

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    xmlns:tools="http://schemas.android.com/tools"
    android:orientation="vertical"
    android:padding="16dp"
    tools:context=".MainActivity2">

    <EditText
        android:id="@+id/editTextNum1InActivity2"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Enter the first number"
        android:inputType="number"/>

    <EditText
        android:id="@+id/editTextNum2InActivity2"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Enter the second number"
        android:inputType="number"/>

    <Button
        android:id="@+id/addButtonInActivity2"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Add"
        android:layout_marginTop="20dp"/>

</LinearLayout>
```

## activity_main3.xml Code

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    xmlns:tools="http://schemas.android.com/tools"
    android:orientation="vertical"
    android:padding="16dp"
    tools:context=".MainActivity3">

    <EditText
        android:id="@+id/editTextNum1InActivity3"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Enter the first number"
        android:inputType="number"/>

    <EditText
        android:id="@+id/editTextNum2InActivity3"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Enter the second number"
        android:inputType="number"/>

    <Button
        android:id="@+id/subButtonInActivity3"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Subtract"
        android:layout_marginTop="20dp"/>

</LinearLayout>
```

## strings.xml File

```xml
<resources>
    <string name="app_name">My Application</string>
    <string name="textViewDiplayMessage">Select the Operation to be performed</string>
</resources>
```

## Output

![Program for Passing Data from one activity for performing add and subtract operation based on user input](./output.png)
