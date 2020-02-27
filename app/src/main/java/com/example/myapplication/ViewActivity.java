package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        TextView textView = findViewById(R.id.textView);
        textView.setText("Id : "+getIntent().getStringExtra("Id")+"\n Name : "+getIntent().getStringExtra("Name"));
    }
}
