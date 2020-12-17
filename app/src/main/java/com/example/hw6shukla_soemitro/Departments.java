package com.example.hw6shukla_soemitro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URLDecoder;
import java.util.ArrayList;

public class Departments extends AppCompatActivity {
    ListView listView_departments;
    ListAdapter adapter;
    private ArrayList<String> departmentArray = new ArrayList<>();
    public String tempDepartment;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_departments);
        listView_departments = (ListView)findViewById(R.id.listview_departments);
        jsonParseDept();
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, departmentArray);
        listView_departments.setAdapter(arrayAdapter);

        listView_departments.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                tempDepartment = departmentArray.get(position);
                openCourses();
            }
        });

    }
    private void jsonParseDept(){
        String url = "http://comet.cs.brynmawr.edu/~dsoemitro/Departments.php";
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response){
                        try{

                            // Loop through the array elements
                            for(int i=0;i<response.length();i++){
                                // Get current json object
                                JSONObject department = response.getJSONObject(i);

                                // Get the current student (json object) data
                                String departmentElement = department.getString("departmentId");
                                departmentArray.add(departmentElement);
                            }
                            ((BaseAdapter) listView_departments.getAdapter()).notifyDataSetChanged();

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
    public void openCourses(){
        Intent CoursesIntent = new Intent(this, Courses.class);
        CoursesIntent.putExtra("department", tempDepartment);
        startActivity(CoursesIntent);

    }
}