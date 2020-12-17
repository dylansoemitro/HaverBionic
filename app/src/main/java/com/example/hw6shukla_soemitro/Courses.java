package com.example.hw6shukla_soemitro;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Courses extends AppCompatActivity {
    ListView listView_courses;
    ListAdapter adapter;

    String department;
    ArrayList<String> tempCourse = new ArrayList<>();
    ArrayList<ArrayList<String>> courseDescription = new ArrayList<>();
    private ArrayList<String> coursesArray = new ArrayList<>();

    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        department = intent.getStringExtra("department") ;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);
        listView_courses = (ListView)findViewById(R.id.listview_courses);
        jsonParseDept();

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, coursesArray);
        listView_courses.setAdapter(arrayAdapter);
        listView_courses.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String coursePos = coursesArray.get(position);
                Boolean found = false;
                int count = 0;
                while(found==false) {
                    if (coursePos.contains(courseDescription.get(count).get(0))) {
                        tempCourse = courseDescription.get(count);
                        found = true;
                    }
                    count+=1;
                }
                 openDescription();
            }
        });

    }
    private void jsonParseDept(){
        String departmentInput = department.toLowerCase();
        String url = String.format("http://comet.cs.brynmawr.edu/~dsoemitro/%1$s%2$s", departmentInput, ".php");
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response){
                        try{

                            // Loop through the array elements
                            for(int i=0;i<response.length();i++){
                                // Get current json object
                                JSONObject course = response.getJSONObject(i);

                                ArrayList<String> courseDescriptions = new ArrayList();

                                // Get the current student (json object) data
                                String courseId = course.getString("courseId");
                                String courseTitle = course.getString("courseTitle");
                                String formatted = String.format("%1$s: %2$s", courseId, courseTitle);

                                courseDescriptions.add(courseId);
                                courseDescriptions.add(courseTitle);
                                courseDescriptions.add(course.getString("requisites"));
                                courseDescriptions.add(course.getString("domainsType"));
                                courseDescriptions.add(course.getString("instructor"));
                                courseDescriptions.add(course.getString("lecStart"));
                                courseDescriptions.add(course.getString("lecEnd"));
                                courseDescriptions.add(course.getString("labStart"));
                                courseDescriptions.add(course.getString("labEnd"));
                                courseDescriptions.add(course.getString("lecDays"));
                                courseDescriptions.add(course.getString("labDays"));
                                courseDescriptions.add(course.getString("modeInstruction"));
                                //courseDescriptions.add(String.valueOf(course.getInt("classLimit")));
                                courseDescriptions.add(String.valueOf(course.getInt("enrolled")));
                                courseDescriptions.add(String.valueOf(course.getInt("waitlist")));
                                courseDescriptions.add(course.getString("description"));
                                courseDescription.add(courseDescriptions);
                                coursesArray.add(formatted);

                            }
                            ((BaseAdapter) listView_courses.getAdapter()).notifyDataSetChanged();

                        }
                        catch (JSONException e){
                            e.printStackTrace();
                        }}}
                , new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error){
                error.printStackTrace();
            }
        });
        requestQueue.add(request);
    }
    public void openDescription(){

        Intent DescriptionIntent = new Intent(this, Description.class);
        DescriptionIntent.putStringArrayListExtra("course", tempCourse);
        startActivity(DescriptionIntent);

    }
}