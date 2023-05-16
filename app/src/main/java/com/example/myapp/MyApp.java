package com.example.myapp;

import android.app.Application;

import androidx.room.Room;

public class MyApp extends Application {
    public static MyApp instance;
    private AppDataBase dataBase;
    @Override
    public void onCreate(){
        super.onCreate();
        instance=this;
        dataBase= Room.databaseBuilder(this,AppDataBase.class,"dataBase").build();
    }
    public static MyApp getInstance(){
        return instance;
    }
    public AppDataBase getDataBase(){
        return dataBase;
    }
}
