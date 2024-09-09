package com.example.listview;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    ListView l ;
    String myarray[]={"\nRoyal Enfield", "Ducati Panigale V4", "BMW S 1000 RR", "Ducati Streetfighter V4","Kawasaki Ninja ZX-10R", "Jawa 42 Bobber", "Harley Davidson Road Glide "};

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        l = findViewById(R.id.mylistview);
        ArrayAdapter<String> arr = new ArrayAdapter<String>(this, R.layout.list_item ,R.id.mytextview, myarray);
        l.setAdapter(arr);
    }
}