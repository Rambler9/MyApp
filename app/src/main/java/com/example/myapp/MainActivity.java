package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView=(RecyclerView) findViewById(R.id.wv_table);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        TableAdapt tableAdapt=new TableAdapt(this,createList());
        recyclerView.setAdapter(tableAdapt);
    }
    private List<ListItem> createList()
    {
        List<ListItem> result=new ArrayList<>();
        result.add(new ListItem("ММИС","8:50\n10:25","пн, 17 апр."));
        result.add(new ListItem("ММИС","10:40\n12:15","вт"));
        return result;
    }
}