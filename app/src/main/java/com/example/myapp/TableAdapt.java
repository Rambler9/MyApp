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
    private final OnItemCickList onItemCickList;
    TableAdapt(Context context, List<ListItem> listItemList, OnItemCickList onItemCickList)
    {
        this.layoutInflater=LayoutInflater.from(context);
        this.listItemList=listItemList;
        this.onItemCickList=onItemCickList;
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

        holder.lessonOne.setText(listItem.getFirstLesson());
        holder.lessonTwo.setText(listItem.getSecondLesson());
        holder.lessonThree.setText(listItem.getThirdLesson());
        holder.lessonFour.setText(listItem.getFourthLesson());
        holder.lessonFive.setText(listItem.getFifthLesson());
        holder.lessonSix.setText(listItem.getSixthLesson());
        holder.lessonSeven.setText(listItem.getSeventhLesson());

        holder.timeOfLessonsOne.setText(listItem.getTimeFirstLesson());
        holder.timeOfLessonsTwo.setText(listItem.getTimeSecondLesson());
        holder.timeOfLessonsThree.setText(listItem.getTimeThirdLesson());
        holder.timeOfLessonsFour.setText(listItem.getTimeFourthLesson());
        holder.timeOfLessonsFive.setText(listItem.getTimeFifthLesson());
        holder.timeOfLessonsSix.setText(listItem.getTimeSixthLesson());
        holder.timeOfLessonsSeven.setText(listItem.getTimeSeventhLesson());

        holder.bind(listItem);
    }

    @Override
    public int getItemCount() {
        return listItemList.size();
    }

    public class TableAdaptViewHolder extends RecyclerView.ViewHolder
    {
        final TextView dayOfWeek;
        final TextView timeOfLessonsOne;
        final TextView timeOfLessonsTwo;
        final TextView timeOfLessonsThree;
        final TextView timeOfLessonsFour;
        final TextView timeOfLessonsFive;
        final TextView timeOfLessonsSix;
        final TextView timeOfLessonsSeven;
        final TextView lessonOne;
        final TextView lessonTwo;
        final TextView lessonThree;
        final TextView lessonFour;
        final TextView lessonFive;
        final TextView lessonSix;
        final TextView lessonSeven;
        View view;
        TableAdaptViewHolder(View view)
        {
            super(view);
            this.view=view;
            dayOfWeek=view.findViewById(R.id.tv_day);

            timeOfLessonsOne=view.findViewById(R.id.tv_time_first_lesson);
            timeOfLessonsTwo=view.findViewById(R.id.tv_time_second_lesson);
            timeOfLessonsThree=view.findViewById(R.id.tv_time_third_lesson);
            timeOfLessonsFour=view.findViewById(R.id.tv_time_fourth_lesson);
            timeOfLessonsFive=view.findViewById(R.id.tv_time_fifth_lesson);
            timeOfLessonsSix=view.findViewById(R.id.tv_time_sixth_lesson);
            timeOfLessonsSeven=view.findViewById(R.id.tv_time_seventh_lesson);

            lessonOne=view.findViewById(R.id.tv_lesson_one);
            lessonTwo=view.findViewById(R.id.tv_lesson_two);
            lessonThree=view.findViewById(R.id.tv_lesson_three);
            lessonFour=view.findViewById(R.id.tv_lesson_four);
            lessonFive=view.findViewById(R.id.tv_lesson_five);
            lessonSix=view.findViewById(R.id.tv_lesson_six);
            lessonSeven=view.findViewById(R.id.tv_lesson_seven);


        }
        public void bind(ListItem listItem)
        {
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemCickList.invoke(listItem.getId());
                }
            });
        }
    }

}
