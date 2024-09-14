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