package com.example.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<User> userList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userList = new ArrayList<>();
        userList.add(new User(1,"Mohit Kumar"));
        userList.add(new User(2,"Rohit Kumar"));
        userList.add(new User(3,"Sohit Kumar"));
        userList.add(new User(4,"Ronit Kumar"));
        userList.add(new User(5,"Nonit Kumar"));

        recyclerView = findViewById(R.id.recycler);

        UserAdapter userAdapter = new UserAdapter(this,userList);
        LinearLayoutManager linearLayoutManager =  new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(userAdapter);

    }
}
