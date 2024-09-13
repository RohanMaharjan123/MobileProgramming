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