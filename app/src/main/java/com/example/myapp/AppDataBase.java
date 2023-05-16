package com.example.myapp;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {ListItem.class},version = 1)
    public abstract class AppDataBase extends RoomDatabase{
    public abstract EntityDao entityDao();
}
