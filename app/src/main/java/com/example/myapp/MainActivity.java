package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button firstWeek;
    Button secondWeek;
    boolean isSecondWeek;
    TableAdapt tableAdapt;

    List<ListItem> allDays;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstWeek = findViewById(R.id.weekOne);
        secondWeek = findViewById(R.id.weekTwo);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            isSecondWeek = extras.getBoolean("week", false);
        }
        recolorButtonsWithWeekName();
        createRecyclerView(this);
        firstWeek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isSecondWeek = false;
                recolorButtonsWithWeekName();
                tableAdapt.setList(daysInCurrentWeek(allDays));
                tableAdapt.notifyDataSetChanged();
            }
        });
        secondWeek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isSecondWeek = true;
                recolorButtonsWithWeekName();
                tableAdapt.setList(daysInCurrentWeek(allDays));
                tableAdapt.notifyDataSetChanged();
            }
        });

    }

    private List<ListItem> createList() {
        List<ListItem> result = new ArrayList<>();
        result.add(new ListItem("", "ММИС", "ММИС", "", "", "", "",
                "8:50\n10:25", "11:30\n13:15", "13:15\n14:50", "15:00\n16:35",
                "16:45\n18:20", "18:30\n20:05", "20:15\n21:50", "пн, 17 апр."));
        result.add(new ListItem("", "", "", "УПД", "ЭДпФКиС", "", "",
                "8:50\n10:25", "10:40\n12:15", "13:15\n14:50", "15:00\n16:35",
                "16:45\n18:20", "18:30\n20:05", "20:15\n21:50", "вт, 18 апр."));
        result.add(new ListItem("", "", "ВМ", "ВМ", "ОИС", "ОИС", "",
                "8:50\n10:25", "10:40\n12:15", "13:15\n14:50", "15:00\n16:35",
                "16:45\n18:20", "18:30\n20:05", "20:15\n21:50", "ср, 19 апр."));
        result.add(new ListItem("УПД", "УПД", "УПД", "", "", "", "",
                "8:50\n10:25", "10:40\n12:15", "13:15\n14:50", "15:00\n16:35",
                "16:45\n18:20", "18:30\n20:05", "20:15\n21:50", "чт, 20 апр."));
        result.add(new ListItem("", "", "", "", "ЭДпФКиС", "", "",
                "8:50\n10:25", "10:40\n12:15", "13:15\n14:50", "15:00\n16:35",
                "16:45\n18:20", "18:30\n20:05", "20:15\n21:50", "пт, 21 апр."));
        result.add(new ListItem("", "ТП", "ТП", "", "", "", "",
                "8:50\n10:25", "10:40\n12:15", "13:15\n14:50", "15:00\n16:35",
                "16:45\n18:20", "18:30\n20:05", "20:15\n21:50", "сб, 22 апр."));
        result.add(new ListItem("", "ММИС", "ММИС", "", "", "", "",
                "8:50\n10:25", "11:30\n13:15", "13:15\n14:50", "15:00\n16:35",
                "16:45\n18:20", "18:30\n20:05", "20:15\n21:50", "пн, 23 апр."));
        result.add(new ListItem("", "", "", "УПД", "ЭДпФКиС", "", "",
                "8:50\n10:25", "10:40\n12:15", "13:15\n14:50", "15:00\n16:35",
                "16:45\n18:20", "18:30\n20:05", "20:15\n21:50", "вт, 24 апр."));
        result.add(new ListItem("", "", "ВМ", "ВМ", "ОИС", "ОИС", "",
                "8:50\n10:25", "10:40\n12:15", "13:15\n14:50", "15:00\n16:35",
                "16:45\n18:20", "18:30\n20:05", "20:15\n21:50", "ср, 25 апр."));
        result.add(new ListItem("УПД", "УПД", "УПД", "", "", "", "",
                "8:50\n10:25", "10:40\n12:15", "13:15\n14:50", "15:00\n16:35",
                "16:45\n18:20", "18:30\n20:05", "20:15\n21:50", "чт, 26 апр."));
        result.add(new ListItem("", "", "", "", "ЭДпФКиС", "", "",
                "8:50\n10:25", "10:40\n12:15", "13:15\n14:50", "15:00\n16:35",
                "16:45\n18:20", "18:30\n20:05", "20:15\n21:50", "пт, 27 апр."));
        result.add(new ListItem("", "ТП", "ТП", "", "", "", "",
                "8:50\n10:25", "10:40\n12:15", "13:15\n14:50", "15:00\n16:35",
                "16:45\n18:20", "18:30\n20:05", "20:15\n21:50", "сб, 28 апр."));
        return result;
    }

    private void openDayOFWeek(long id) {
        Intent intent = new Intent(this, DayOfWeekActivity.class);
        intent.putExtra("id", id);
        intent.putExtra("week", isSecondWeek);
        startActivity(intent);
        finish();
    }

    private void createRecyclerView(Context context) {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.wv_table);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        final List<ListItem>[] result = new List[]{null};
        DataBase.newInstance().load(new LoadingCallBack() {
            @Override
            public void update(List list) {
                if (list == null || list.size() == 0) {
                    result[0] = createList();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            DataBase.newInstance().saveAll(result[0]);
                        }
                    }).start();
                } else {
                    result[0] = list;
                }
                OnItemCickList onItemCickList = new OnItemCickList() {
                    @Override
                    public void invoke(long id) {
                        openDayOFWeek(id);
                    }
                };
                allDays = result[0];
                tableAdapt = new TableAdapt(context, daysInCurrentWeek(result[0]), onItemCickList);
                recyclerView.setAdapter(tableAdapt);
            }
        });
    }

    private List<ListItem> daysInCurrentWeek(List<ListItem> allDays){
        if (isSecondWeek) {
            return  new ArrayList<>(allDays.subList(allDays.size()/2, allDays.size()));

        }
            return new ArrayList<>(allDays.subList(0, allDays.size()/2));

    }

    private void recolorButtonsWithWeekName() {
        if (isSecondWeek) {
            secondWeek.setBackgroundColor(getResources().getColor(R.color.purple_500));
            firstWeek.setBackgroundColor(getResources().getColor(R.color.border));
        } else {
            secondWeek.setBackgroundColor(getResources().getColor(R.color.border));
            firstWeek.setBackgroundColor(getResources().getColor(R.color.purple_500));
        }
    }
}