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
    public void loadItem(LoadingItemCallBack loadingItemCallBack, Long id){
        DataBase.DataItemLoaderAsyngTask dataLoaderAsyngTask=new DataBase.DataItemLoaderAsyngTask(loadingItemCallBack, id);
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

    private static class DataItemLoaderAsyngTask extends AsyncTask<
            Void, Void, ListItem>{
        private final LoadingItemCallBack loadingCallBack;

        private final Long id;
        public DataItemLoaderAsyngTask(LoadingItemCallBack loadingCallBack, Long id){
            this.loadingCallBack=loadingCallBack;
            this.id=id;
        }
        @Override
        protected ListItem doInBackground(Void... voids) {
            AppDataBase appDataBase=MyApp.getInstance().getDataBase();
            EntityDao entityDao=appDataBase.entityDao();
            ListItem list=entityDao.getListItem(id);
            return list;
        }
        @Override
        protected void onPostExecute(ListItem list){
            super.onPostExecute(list);
            loadingCallBack.update(list);
        }
    }

}


