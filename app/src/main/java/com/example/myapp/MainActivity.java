package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
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
        final List<ListItem>[] result = new List[]{null};
        Context context=this;
        DataBase.newInstance().load(new LoadingCallBack() {
            @Override
            public void update(List list) {
                if(list==null ||list.size()==0){
                    result[0]=list;

                } else{
                    result[0] = createList();
                    new Thread( new Runnable() {
                        @Override
                        public void run() {
                            DataBase.newInstance().saveAll(result[0]);
                        }
                    }).start();
                }
                OnItemCickList onItemCickList=new OnItemCickList() {
                    @Override
                    public void invoke(long id) {
                        openDayOFWeek(id);
                    }
                };
                TableAdapt tableAdapt=new TableAdapt(context,result[0], onItemCickList);
                recyclerView.setAdapter(tableAdapt);
            }
        });

    }
    private List<ListItem> createList()
    {
        List<ListItem> result=new ArrayList<>();
        result.add(new ListItem("","ММИС","ММИС","","","","",
                "8:50\n10:25","11:30\n13:15","13:15\n14:50","15:00\n16:35",
                "16:45\n18:20","18:30\n20:05","20:15\n21:50","пн, 17 апр."));
        result.add(new ListItem("","","","УПД","ЭДпФКиС","","",
                "8:50\n10:25","10:40\n12:15","13:15\n14:50","15:00\n16:35",
                "16:45\n18:20","18:30\n20:05","20:15\n21:50","вт, 18 апр."));
        result.add(new ListItem("","","ВМ","ВМ","ОИС","ОИС","",
                "8:50\n10:25","10:40\n12:15","13:15\n14:50","15:00\n16:35",
                "16:45\n18:20","18:30\n20:05","20:15\n21:50","ср, 19 апр."));
        result.add(new ListItem("УПД","УПД","УПД","","","","",
                "8:50\n10:25","10:40\n12:15","13:15\n14:50","15:00\n16:35",
                "16:45\n18:20","18:30\n20:05","20:15\n21:50","чт, 20 апр."));
        result.add(new ListItem("","","","","ЭДпФКиС","","",
                "8:50\n10:25","10:40\n12:15","13:15\n14:50","15:00\n16:35",
                "16:45\n18:20","18:30\n20:05","20:15\n21:50","пт, 21 апр."));
        result.add(new ListItem("","ТП","ТП","","","","",
                "8:50\n10:25","10:40\n12:15","13:15\n14:50","15:00\n16:35",
                "16:45\n18:20","18:30\n20:05","20:15\n21:50","сб, 22 апр."));
        return result;
    }
    private void openDayOFWeek(long id){
        Intent intent=new Intent(this,DayOfWeekActivity.class);
        intent.putExtra("id",id);
        startActivity(intent);
    }
}