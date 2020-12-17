
package com.example.hw6shukla_soemitro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Options extends AppCompatActivity {

    ListView listView_options;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        listView_options = (ListView)findViewById(R.id.listview_options);

        ArrayList<String> optionArray = new ArrayList<>();

        optionArray.add("Departments");
        optionArray.add("Courses (Calendar View)");
        optionArray.add("Courses (List View)");

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, optionArray);

        listView_options.setAdapter(arrayAdapter);

        listView_options.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(optionArray.get(position).equals("Departments")){
                    openDepartments();
                }
                else if(optionArray.get(position).equals("Courses (Calendar View)")){
                    openCalendar();
                }
                else{
                    openCourseList();
                }
                Toast.makeText(Options.this, "clicked item"+position+" "+optionArray.get(position), Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void openDepartments(){
        Intent DepartmentsIntent = new Intent(this, Departments.class);
        startActivity(DepartmentsIntent);
    }
    public void openCalendar(){
        Intent CalendarIntent = new Intent(this, Calendar.class);
        startActivity(CalendarIntent);
    }
    public void openCourseList(){
        Intent CourseListIntent = new Intent(this, CourseList.class);
        startActivity(CourseListIntent);
    }
}