# Program for creating an android application that performs student registration and displays data from the database in a listview

**Name**: Program for creating an android application that performs student registration and displays data from the database in a listview

**Date**: October 19th, 2024

## Source Code

## MainActivity.java Code

```java
package com.example.useregistration_db;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText Name, Pass, updateold, updatenew, delete;
    myDbAdapter helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name = findViewById(R.id.editName);
        Pass = findViewById(R.id.editPass);
        updateold = findViewById(R.id.editText3);
        updatenew = findViewById(R.id.editText5);
        delete = findViewById(R.id.editText6);

        helper = new myDbAdapter(this);

        Button addButton = findViewById(R.id.button);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addUser(v);
            }
        });

        Button viewButton = findViewById(R.id.button2);
        viewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewdata(v);
            }
        });

        Button updateButton = findViewById(R.id.button3);
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update(v);
            }
        });

        Button deleteButton = findViewById(R.id.button4);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delete(v);
            }
        });
    }

    public void addUser(View view) {
        String t1 = Name.getText().toString();
        String t2 = Pass.getText().toString();
        if (t1.isEmpty() || t2.isEmpty()) {
            Message.message(getApplicationContext(), "Enter Both Name and Password");
        } else {
            long id = helper.insertData(t1, t2);
            if (id <= 0) {
                Message.message(getApplicationContext(), "Insertion Unsuccessful");
                Name.setText("");
                Pass.setText("");
            } else {
                Message.message(getApplicationContext(), "Insertion Successful");
                Name.setText("");
                Pass.setText("");
            }
        }
    }

    public void viewdata(View view) {
        String data = helper.getData();
        Message.message(this, data);
    }

    public void update(View view) {
        String u1 = updateold.getText().toString();
        String u2 = updatenew.getText().toString();
        if (u1.isEmpty() || u2.isEmpty()) {
            Message.message(getApplicationContext(), "Enter Data");
        } else {
            int a = helper.updateName(u1, u2);
            if (a <= 0) {
                Message.message(getApplicationContext(), "Unsuccessful");
                updateold.setText("");
                updatenew.setText("");
            } else {
                Message.message(getApplicationContext(), "Updated");
                updateold.setText("");
                updatenew.setText("");
            }
        }
    }

    public void delete(View view) {
        String uname = delete.getText().toString();
        if (uname.isEmpty()) {
            Message.message(getApplicationContext(), "Enter Data");
        } else {
            int a = helper.delete(uname);
            if (a <= 0) {
                Message.message(getApplicationContext(), "Unsuccessful");
                delete.setText("");
            } else {
                Message.message(this, "DELETED");
                delete.setText("");
            }
        }
    }
}
```

## Message.java Code

```java
package com.example.useregistration_db;

import android.content.Context;
import android.widget.Toast;

public class Message {
    public static void message(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}
```

## MyDbAdapter.java Code

```java
package com.example.useregistration_db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class myDbAdapter {
    myDbHelper myhelper;

    public myDbAdapter(Context context) {
        myhelper = new myDbHelper(context);
    }

    public long insertData(String name, String pass) {
        SQLiteDatabase dbb = myhelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(myDbHelper.NAME, name);
        contentValues.put(myDbHelper.MyPASSWORD, pass);
        return dbb.insert(myDbHelper.TABLE_NAME, null, contentValues);
    }

    public String getData() {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        String[] columns = {myDbHelper.UID, myDbHelper.NAME, myDbHelper.MyPASSWORD};
        Cursor cursor = db.query(myDbHelper.TABLE_NAME, columns, null, null, null, null, null);
        StringBuffer buffer = new StringBuffer();

        int indexUID = cursor.getColumnIndex(myDbHelper.UID);
        int indexName = cursor.getColumnIndex(myDbHelper.NAME);
        int indexPassword = cursor.getColumnIndex(myDbHelper.MyPASSWORD);

        while (cursor.moveToNext()) {
            if (indexUID != -1 && indexName != -1 && indexPassword != -1) {
                int cid = cursor.getInt(indexUID);
                String name = cursor.getString(indexName);
                String password = cursor.getString(indexPassword);
                buffer.append(cid + "   " + name + "   " + password + " \n");
            }
        }
        cursor.close(); // Close the cursor to avoid memory leaks
        return buffer.toString();
    }

    public int delete(String uname) {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        String[] whereArgs = {uname};
        return db.delete(myDbHelper.TABLE_NAME, myDbHelper.NAME + " = ?", whereArgs);
    }

    public int updateName(String oldName, String newName) {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(myDbHelper.NAME, newName);
        String[] whereArgs = {oldName};
        return db.update(myDbHelper.TABLE_NAME, contentValues, myDbHelper.NAME + " = ?", whereArgs);
    }

    static class myDbHelper extends SQLiteOpenHelper {
        private static final String DATABASE_NAME = "myDatabase";    // Database Name
        private static final String TABLE_NAME = "myTable";   // Table Name
        private static final int DATABASE_Version = 1;    // Database Version
        private static final String UID = "_id";     // Column I (Primary Key)
        private static final String NAME = "Name";    // Column II
        private static final String MyPASSWORD = "Password";    // Column III

        private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME +
                " (" + UID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + NAME + " VARCHAR(255) ," + MyPASSWORD + " VARCHAR(225));";

        private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
        private Context context;

        public myDbHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_Version);
            this.context = context;
        }

        public void onCreate(SQLiteDatabase db) {
            try {
                db.execSQL(CREATE_TABLE);
            } catch (Exception e) {
                Message.message(context, "" + e);
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            try {
                Message.message(context, "OnUpgrade");
                db.execSQL(DROP_TABLE);
                onCreate(db);
            } catch (Exception e) {
                Message.message(context, "" + e);
            }
        }
    }
}
```

## activity_main.xml Code

```xml
<?xml version="1.0" encoding="utf-8"?>
<TableLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:padding="16dp"
    android:id="@+id/activity_main">

    <TableRow>
        <TextView
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="User Registration:"
            android:textSize="24sp"
            android:layout_span="2"
            android:gravity="center"
            android:textStyle="italic"
            android:textColor="@color/cardview_dark_background"/>
    </TableRow>

    <TableRow>
        <TextView
            android:id="@+id/textView"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Username:"
            android:textSize="18sp"
            android:layout_marginRight="8dp"/>

        <EditText
            android:id="@+id/editName"
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:inputType="text"
            android:layout_weight="1"
            android:hint="Enter Name"
            android:textSize="16sp"/>
    </TableRow>

    <TableRow>
        <TextView
            android:id="@+id/textView2"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Password:"
            android:textSize="18sp"
            android:layout_marginRight="8dp"/>

        <EditText
            android:id="@+id/editPass"
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:inputType="textPassword"
            android:hint="Enter Password"
            android:layout_weight="1"
            android:textSize="16sp"/>
    </TableRow>

    <TableRow>
        <Button
            android:id="@+id/button"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Add User"
            android:textSize="16sp"/>
    </TableRow>

    <TableRow>
        <Button
            android:id="@+id/button2"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="View Data"
            android:textSize="16sp"/>
    </TableRow>

    <TableRow>
        <EditText
            android:id="@+id/editText3"
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:hint="Current Name"
            android:textSize="16sp"/>
    </TableRow>

    <TableRow>
        <EditText
            android:id="@+id/editText5"
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:hint="New Name"
            android:textSize="16sp"/>
    </TableRow>

    <TableRow>
        <Button
            android:id="@+id/button3"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Update Name"
            android:textSize="16sp"/>
    </TableRow>

    <TableRow>
        <EditText
            android:id="@+id/editText6"
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:hint="Enter Name to Delete"
            android:inputType="text"
            android:textSize="16sp"/>
    </TableRow>

    <TableRow>
        <Button
            android:id="@+id/button4"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Delete Name"
            android:textSize="16sp"/>
    </TableRow>
</TableLayout>
```

## strings.xml File

```xml
<resources>
    <string name="app_name">Useregistration - db</string>
</resources>
```

## Output

![Program for creating an android application that performs student registration and displays data from the database in a listview](./output.png)
