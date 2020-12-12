package com.example.hw6shukla_soemitro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

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
                Toast.makeText(Options.this, "clicked item"+position+" "+optionArray.get(position), Toast.LENGTH_SHORT).show();
            }
        });

    }
}