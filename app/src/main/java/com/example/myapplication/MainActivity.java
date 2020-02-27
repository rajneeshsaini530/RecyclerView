package com.example.myapplication;

import android.os.Bundle;
import android.text.style.TabStopSpan;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<User> userList;

    RecyclerView recyclerView;

    boolean status;

    LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler);
        userList = new ArrayList<>();
        userList.add(new User(1, "Mohit Kumar"));
        userList.add(new User(2, "Rohit Kumar"));
        userList.add(new User(3, "Sohit Kumar"));
        userList.add(new User(4, "Ronit Kumar"));
        userList.add(new User(5, "Nonit Kumar"));

        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        status = false;
        UserAdapter userAdapter = new UserAdapter(this, userList);
        recyclerView.setAdapter(userAdapter);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(status){
                    recyclerView.setLayoutManager(linearLayoutManager);
                    status = false;
                }else{
                    GridLayoutManager gridLayoutManager = new GridLayoutManager(MainActivity.this,2);
                    recyclerView.setLayoutManager(gridLayoutManager);
                    status = true;
                }


            }
        });

    }
}
