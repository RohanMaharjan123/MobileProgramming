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