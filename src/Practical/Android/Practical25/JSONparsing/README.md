# Program for parsing JSON in android

**Name**: Program for parsing JSON in android

**Date**: October 20th, 2024

## Source Code

## MainActivity.java Code

```java
package com.example.jsonparsing;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    // JSON data method
    private String getListData() {
        return "{ \"users\" :[" +
                "{\"name\":\"Rohan\",\"designation\":\"Manager\",\"location\":\"KTM\"}," +
                "{\"name\":\"Sujita\",\"designation\":\"CEO\",\"location\":\"Butwal\"}," +
                "{\"name\":\"Maila Bhai\",\"designation\":\"Programmer\",\"location\":\"Gorkha\"}" +
                "] }";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String jsonStr = getListData();
        try {
            ArrayList<HashMap<String, String>> userList = new ArrayList<>();
            ListView lv = findViewById(R.id.user_list);

            JSONObject jObj = new JSONObject(jsonStr);
            JSONArray jsonArry = jObj.getJSONArray("users");
            for (int i = 0; i < jsonArry.length(); i++) {
                HashMap<String, String> user = new HashMap<>();
                JSONObject obj = jsonArry.getJSONObject(i);
                user.put("name", obj.getString("name"));
                user.put("designation", obj.getString("designation"));
                user.put("location", obj.getString("location"));
                userList.add(user);
            }

            ListAdapter adapter = new SimpleAdapter(
                    this, userList, R.layout.list_row,
                    new String[]{"name", "designation", "location"},
                    new int[]{R.id.name, R.id.designation, R.id.location}
            );
            lv.setAdapter(adapter);
        } catch (JSONException ex) {
            Log.e("JsonParser", "unexpected JSON exception", ex);
        }
    }
}
```

## activity_main.xml Code

```xml
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="fill_parent"
    android:layout_height="fill_parent"
    android:orientation="vertical" >

    <!--This ListView will display the list items-->
    <ListView
        android:id="@+id/user_list"
        android:layout_width="fill_parent"
        android:layout_height="wrap_content"
        android:dividerHeight="1dp" />
</LinearLayout>
```

## list_row.xml Code

```xml
<?xml version="1.0" encoding="utf-8"?>
<TableLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="fill_parent"
    android:layout_height="wrap_content"
    android:padding="5dip">

    <TableRow android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_margin="10dp">

        <!-- Name TextView -->
        <TextView
            android:id="@+id/name"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:textSize="18sp"
            android:textStyle="bold"
            android:layout_margin="10dp"
            android:padding="10dp"/>

        <!-- Designation TextView -->
        <TextView
            android:id="@+id/designation"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:textSize="18sp"
            android:layout_margin="10dp"
            android:padding="10dp"/>

        <!-- Location TextView -->
        <TextView
            android:id="@+id/location"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:textSize="18sp"
            android:layout_margin="10dp"
            android:padding="10dp"/>

    </TableRow>
</TableLayout>
```

## strings.xml File

```xml
<resources>
    <string name="app_name">JSON parsing</string>
</resources>
```

## Output

![Program for parsing JSON in android](./output.png)
