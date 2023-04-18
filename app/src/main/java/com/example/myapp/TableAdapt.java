package com.example.myapp;

import android.app.LauncherActivity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TableAdapt extends RecyclerView.Adapter<TableAdapt.TableAdaptViewHolder>
{
    private final LayoutInflater layoutInflater;
    private final List<ListItem> listItemList;
    TableAdapt(Context context, List<ListItem> listItemList)
    {
        this.layoutInflater=LayoutInflater.from(context);
        this.listItemList=listItemList;
    }

    @NonNull
    @Override
    public TableAdaptViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view=layoutInflater.inflate(R.layout.table_i,parent,false);
        return new TableAdaptViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TableAdaptViewHolder holder, int position)
    {
        ListItem listItem=listItemList.get(position);

        holder.dayOfWeek.setText(listItem.getDayOfWeek());

        holder.lesson.setText(listItem.getFirstLesson());
        holder.lesson.setText(listItem.getSecondLesson());
        holder.lesson.setText(listItem.getThirdLesson());
        holder.lesson.setText(listItem.getFourthLesson());
        holder.lesson.setText(listItem.getFifthLesson());
        holder.lesson.setText(listItem.getSixthLesson());
        holder.lesson.setText(listItem.getSeventhLesson());

        holder.timeOfLessons.setText(listItem.getTimeFirstLesson());
        holder.timeOfLessons.setText(listItem.getTimeSecondLesson());
        holder.timeOfLessons.setText(listItem.getTimeThirdLesson());
        holder.timeOfLessons.setText(listItem.getTimeFourthLesson());
        holder.timeOfLessons.setText(listItem.getTimeFifthLesson());
        holder.timeOfLessons.setText(listItem.getTimeSixthLesson());
        holder.timeOfLessons.setText(listItem.getTimeSeventhLesson());
    }

    @Override
    public int getItemCount() {
        return listItemList.size();
    }

    public class TableAdaptViewHolder extends RecyclerView.ViewHolder
    {
        final TextView dayOfWeek;
        final TextView timeOfLessons;
        final TextView lesson;
        TableAdaptViewHolder(View view)
        {
            super(view);
            dayOfWeek=view.findViewById(R.id.tv_day);

            timeOfLessons=view.findViewById(R.id.tv_time_first_lesson);

            lesson=view.findViewById(R.id.tv_lesson_one);
        }
    }
}
