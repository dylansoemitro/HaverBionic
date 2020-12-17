package com.example.hw6shukla_soemitro;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;
import android.content.Intent;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    EditText etUsername, etPassword;
    Button btSubmit;
    RequestQueue mQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);
        btSubmit = findViewById(R.id.bt_submit);

        mQueue = Volley.newRequestQueue(this);


        btSubmit.setOnClickListener(new View.OnClickListener()  {
            @Override
            public void onClick(View v) {
                if (etUsername.getText().toString().equals("admin") && etPassword.getText().toString().equals("hedwig")){
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setIcon(R.drawable.ic_check);
                    builder.setTitle("Login Successful!");
                    builder.setMessage("Welcome to FakeBionic!");

                    builder.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    openOptions();
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();

                }
                else {
                    Toast.makeText(getApplicationContext(), "Invalid Username and Password", Toast.LENGTH_SHORT).show();
                }
                }
            }
        );


        }



        public void openOptions() {
        Intent optionIntent = new Intent(this, Options.class);
        startActivity(optionIntent);
    }


}