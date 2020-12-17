package com.example.hw6shukla_soemitro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class Description extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        Bundle extras = getIntent().getExtras();
        ArrayList<String> courseDescription = extras.getStringArrayList("course");

        for (int i = 0; i < courseDescription.size(); i++) {
            if (courseDescription.get(i) == null) {
                courseDescription.set(i, "None");
            }
        }
        TextView courseId = (TextView) findViewById(R.id.courseId);
        courseId.setText(courseDescription.get(0));
        TextView courseTitle = (TextView) findViewById(R.id.courseTitle);
        courseTitle.setText(courseDescription.get(1));
        TextView requisites = (TextView) findViewById(R.id.requisites);
        requisites.setText(courseDescription.get(2));
        TextView domainsType = (TextView) findViewById(R.id.domainsType);
        domainsType.setText(courseDescription.get(3));
        TextView instructor = (TextView) findViewById(R.id.instructor);
        instructor.setText(courseDescription.get(4));
        TextView lecStart = (TextView) findViewById(R.id.lecStart);
        lecStart.setText(courseDescription.get(5));
        TextView lecEnd = (TextView) findViewById(R.id.lecEnd);
        lecEnd.setText(courseDescription.get(6));
        TextView labStart = (TextView) findViewById(R.id.labStart);
        labStart.setText(courseDescription.get(7));
        TextView labEnd = (TextView) findViewById(R.id.labEnd);
        labEnd.setText(courseDescription.get(8));
        TextView lecDays = (TextView) findViewById(R.id.lecDays);
        lecDays.setText(courseDescription.get(9));
        TextView labDays = (TextView) findViewById(R.id.labDays);
        labDays.setText(courseDescription.get(10));
        TextView modeInstruction = (TextView) findViewById(R.id.modeInstruction);
        modeInstruction.setText(courseDescription.get(11));
        TextView description = (TextView) findViewById(R.id.description);
        description.setText(courseDescription.get(12));


    }
}