package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WebView webview=(WebView) findViewById(R.id.wv_table);
        webview.setWebViewClient(new WebViewClient());
        webview.loadUrl("https://timetable.tusur.ru/faculties/fvs/groups/590-1");
    }
}