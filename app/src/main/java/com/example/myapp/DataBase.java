package com.example.myapp;

import android.os.AsyncTask;

import androidx.loader.content.AsyncTaskLoader;

import java.util.ArrayList;
import java.util.List;

public class DataBase {
    private  static DataBase dataBase;

    private DataBase() {
    }
    public static DataBase newInstance(){
        if(dataBase==null){
            dataBase=new DataBase();
        }
        return dataBase;
    }
    public void load(LoadingCallBack loadingCallBack){
        DataBase.DataLoaderAsyngTask dataLoaderAsyngTask=new DataBase.DataLoaderAsyngTask(loadingCallBack);
        dataLoaderAsyngTask.execute();
    }
    private static class DataLoaderAsyngTask extends AsyncTask<
            Void, Void, List<ListItem>>{
private final LoadingCallBack loadingCallBack;
public DataLoaderAsyngTask(LoadingCallBack loadingCallBack){
    this.loadingCallBack=loadingCallBack;
}
        @Override
        protected List<ListItem> doInBackground(Void... voids) {
AppDataBase appDataBase=MyApp.getInstance().getDataBase();
EntityDao entityDao=appDataBase.entityDao();
            List<ListItem> list=entityDao.getAll();
            return list;
        }
        @Override
        protected void onPostExecute(List<ListItem> list){
    super.onPostExecute(list);
    loadingCallBack.update(list);
        }
    }
    public void saveAll(List<ListItem> list){
        AppDataBase appDataBase=MyApp.getInstance().getDataBase();
        EntityDao entityDao=appDataBase.entityDao();
        for(ListItem item:list){
            entityDao.insert(item);
        }
    }
}
