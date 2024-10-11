# Program for creating a Menu

**Name**: Program for creating a Menu

**Date**: October 9th, 2024

## Source Code

## MainActivity.java Code

```java
package com.example.menuexample;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private Button popupMenuBtn;
    private TextView contextTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set up the Toolbar as the ActionBar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Register for context menu
        contextTextView = findViewById(R.id.contextMenuTextView);
        registerForContextMenu(contextTextView);

        // Initialize popup menu button
        popupMenuBtn = findViewById(R.id.popupMenuBtn);
        popupMenuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupMenu(v);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu into the Toolbar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_option, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_search) {
            showToast("Search selected");
            return true;
        } else if (id == R.id.action_compose) {
            showToast("Compose Email selected");
            return true;
        } else if (id == R.id.action_settings) {
            showToast("Settings selected");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_context, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.cut) {
            showToast("Cut selected");
            return true;
        } else if (id == R.id.copy) {
            showToast("Copy selected");
            return true;
        } else if (id == R.id.paste) {
            showToast("Paste selected");
            return true;
        }
        return super.onContextItemSelected(item);
    }

    private void showPopupMenu(View v) {
        PopupMenu popupMenu = new PopupMenu(this, v);
        popupMenu.getMenuInflater().inflate(R.menu.menu_popup, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.bold) {
                    showToast("Bold selected");
                    return true;
                } else if (id == R.id.italic) {
                    showToast("Italic selected");
                    return true;
                } else if (id == R.id.underline) {
                    showToast("Underline selected");
                    return true;
                }
                return false;
            }
        });

        popupMenu.show();
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
```

## activity_main.xml Code

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:padding="16dp">

    <!-- Toolbar -->
    <androidx.appcompat.widget.Toolbar
        android:id="@+id/toolbar"
        android:layout_width="0dp"
        android:layout_height="?attr/actionBarSize"
        android:background="?attr/colorPrimary"
        android:elevation="4dp"
        app:popupTheme="@style/ThemeOverlay.AppCompat.Light"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent"/>

    <!-- Popup Menu Button -->
    <Button
        android:id="@+id/popupMenuBtn"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Show Popup Menu"
        android:background="@color/teal_200"
        app:layout_constraintTop_toBottomOf="@id/toolbar"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.5"/>

    <!-- Context Menu TextView -->
    <TextView
        android:id="@+id/contextMenuTextView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Long press for Context Menu"
        android:textColor="@android:color/black"
        android:textSize="18sp"
        android:padding="16dp"
        app:layout_constraintTop_toBottomOf="@id/popupMenuBtn"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintBottom_toBottomOf="parent"/>

</androidx.constraintlayout.widget.ConstraintLayout>

```

## strings.xml File

```xml
<resources>
    <string name="app_name">MenuExample</string>
    <color name="teal_200">#03DAC5</color>
</resources>
```

## Output

![Program for creating a Menu](./output.png)
