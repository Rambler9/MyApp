package com.example.myapp;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface EntityDao {
    @Query("SELECT * FROM listitem")
    List<ListItem> getAll();
    @Insert
    void insert(ListItem listItem);
}
