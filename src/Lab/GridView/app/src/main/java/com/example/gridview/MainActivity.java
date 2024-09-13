package com.example.gridview;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    GridView g;
    String myarray[]={"\nRoyal Enfield", "Ducati Panigale V4", "BMW S 1000 RR", "Ducati Streetfighter V4","Kawasaki Ninja ZX-10R", "Jawa 42 Bobber", "Harley Davidson Road Glide "};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        g = (GridView) findViewById(R.id.grid);
        ArrayAdapter<String>  arr = new ArrayAdapter<String>(this, R.layout.layout_grid, R.id.tv1, myarray);
        g.setAdapter(arr);
    }
}