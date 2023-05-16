package com.example.myapp;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface EntityDao {
    @Query("SELECT * FROM listitem")
    List<ListItem> getAll();
    @Insert
    void insert(ListItem listItem);
    @Query("SELECT * FROM listitem WHERE id=:curentId")
    ListItem getListItem(Long curentId);
    @Update
    void update(ListItem listItem);
}
