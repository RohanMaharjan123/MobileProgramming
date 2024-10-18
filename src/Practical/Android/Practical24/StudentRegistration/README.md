# Program for creating an android application that performs student registration and displays data from the database in a listview

**Name**: Program for creating an android application that performs student registration and displays data from the database in a listview

**Date**: October 18th, 2024

## Source Code

## MainActivity.java Code

```java
package com.example.studentregistration;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText editName, editAge, editStudentID;
    private Button buttonRegister, buttonView;
    private ListView listViewStudents;
    private StudentDatabase studentDatabase;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> studentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editName = findViewById(R.id.editName);
        editAge = findViewById(R.id.editAge);
        editStudentID = findViewById(R.id.editStudentID);
        buttonRegister = findViewById(R.id.buttonRegister);
        buttonView = findViewById(R.id.buttonView);
        listViewStudents = findViewById(R.id.listViewStudents);

        studentDatabase = new StudentDatabase(this);
        studentDatabase.open();

        studentList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, studentList);
        listViewStudents.setAdapter(adapter);

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editName.getText().toString();
                int age = Integer.parseInt(editAge.getText().toString());
                String studentID = editStudentID.getText().toString();
                studentDatabase.addStudent(name, age, studentID);
                editName.setText("");
                editAge.setText("");
                editStudentID.setText("");
            }
        });

        buttonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                studentList.clear();
                studentList.addAll(studentDatabase.getAllStudents());
                adapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        studentDatabase.close();
    }
}
```

## DatabaseHelper.java Code

```java
package com.example.studentregistration;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "studentDB";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_STUDENTS = "students";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_AGE = "age";
    private static final String COLUMN_STUDENT_ID = "student_id";

    private static final String TABLE_CREATE =
            "CREATE TABLE " + TABLE_STUDENTS + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_NAME + " TEXT, " +
                    COLUMN_AGE + " INTEGER, " +
                    COLUMN_STUDENT_ID + " TEXT);";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_STUDENTS);
        onCreate(db);
    }
}
```

## StudentDatabase.java Code

```java
package com.example.studentregistration;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class StudentDatabase {
    private SQLiteDatabase database;
    private DatabaseHelper dbHelper;

    public StudentDatabase(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    public void open() {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public long addStudent(String name, int age, String studentID) {
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("age", age);
        values.put("student_id", studentID);
        return database.insert("students", null, values);
    }

    public ArrayList<String> getAllStudents() {
        ArrayList<String> students = new ArrayList<>();
        Cursor cursor = database.query("students",
                new String[]{"name", "age", "student_id"},
                null, null, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                String student = "Name: " + cursor.getString(0) +
                        ", Age: " + cursor.getInt(1) +
                        ", ID: " + cursor.getString(2);
                students.add(student);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return students;
    }
}
```

## activity_main.xml Code

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="16dp">

    <EditText
        android:id="@+id/editName"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Enter Name" />

    <EditText
        android:id="@+id/editAge"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Enter Age"
        android:inputType="number" />

    <EditText
        android:id="@+id/editStudentID"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Enter Student ID" />

    <Button
        android:id="@+id/buttonRegister"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Register" />

    <Button
        android:id="@+id/buttonView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="View Students" />

    <ListView
        android:id="@+id/listViewStudents"
        android:layout_width="match_parent"
        android:layout_height="wrap_content" />
</LinearLayout>
```

## strings.xml File

```xml
<resources>
    <string name="app_name">StudentRegistration</string>
</resources>
```

## Output

![Program for creating an android application that performs student registration and displays data from the database in a listview](./output.png)
