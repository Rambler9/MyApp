package com.example.myapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class DayOfWeekActivity extends AppCompatActivity {
    boolean isSecondWeek;
     EditText dayOfWeek;
     EditText timeOfLessonsOne;
     EditText timeOfLessonsTwo;
     EditText timeOfLessonsThree;
     EditText timeOfLessonsFour;
     EditText timeOfLessonsFive;
     EditText timeOfLessonsSix;
     EditText timeOfLessonsSeven;
     EditText lessonOne;
     EditText lessonTwo;
     EditText lessonThree;
     EditText lessonFour;
     EditText lessonFive;
     EditText lessonSix;
     EditText lessonSeven;
     Button saveButton;
     long id;
    @Override
    protected void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.day_of_week);
        dayOfWeek=findViewById(R.id.tv_day);

        timeOfLessonsOne=findViewById(R.id.tv_time_first_lesson);
        timeOfLessonsTwo=findViewById(R.id.tv_time_second_lesson);
        timeOfLessonsThree=findViewById(R.id.tv_time_third_lesson);
        timeOfLessonsFour=findViewById(R.id.tv_time_fourth_lesson);
        timeOfLessonsFive=findViewById(R.id.tv_time_fifth_lesson);
        timeOfLessonsSix=findViewById(R.id.tv_time_sixth_lesson);
        timeOfLessonsSeven=findViewById(R.id.tv_time_seventh_lesson);

        lessonOne=findViewById(R.id.tv_lesson_one);
        lessonTwo=findViewById(R.id.tv_lesson_two);
        lessonThree=findViewById(R.id.tv_lesson_three);
        lessonFour=findViewById(R.id.tv_lesson_four);
        lessonFive=findViewById(R.id.tv_lesson_five);
        lessonSix=findViewById(R.id.tv_lesson_six);
        lessonSeven=findViewById(R.id.tv_lesson_seven);

        saveButton=findViewById(R.id.button_save);
        id=getIntent().getExtras().getLong("id");

        onData(id,this);
        isSecondWeek =getIntent().getExtras().getBoolean("week");

    }

    private void onData(long id, Context context){
        LoadingItemCallBack loadingItemCallBack=new LoadingItemCallBack() {
            @Override
            public void update(ListItem listItem) {
                dayOfWeek.setText(listItem.getDayOfWeek());

                timeOfLessonsOne.setText(listItem.getTimeFirstLesson());
                timeOfLessonsTwo.setText(listItem.getTimeSecondLesson());
                timeOfLessonsThree.setText(listItem.getTimeThirdLesson());
                timeOfLessonsFour.setText(listItem.getTimeFourthLesson());
                timeOfLessonsFive.setText(listItem.getTimeFifthLesson());
                timeOfLessonsSix.setText(listItem.getTimeSixthLesson());
                timeOfLessonsSeven.setText(listItem.getTimeSeventhLesson());

                lessonOne.setText(listItem.getFirstLesson());
                lessonTwo.setText(listItem.getSecondLesson());
                lessonThree.setText(listItem.getThirdLesson());
                lessonFour.setText(listItem.getFourthLesson());
                lessonFive.setText(listItem.getFirstLesson());
                lessonSix.setText(listItem.getSixthLesson());
                lessonSeven.setText(listItem.getSeventhLesson());
            }
        };
        DataBase.newInstance().loadItem(loadingItemCallBack, id);
    }
    public void saveData(View view){
        ListItem listItem=new ListItem(lessonOne.getText().toString(),
                lessonTwo.getText().toString(),
                lessonThree.getText().toString(),
                lessonFour.getText().toString(),
                lessonFive.getText().toString(),
                lessonSix.getText().toString(),
                lessonSeven.getText().toString(),
                timeOfLessonsOne.getText().toString(),
                timeOfLessonsTwo.getText().toString(),
                timeOfLessonsThree.getText().toString(),
                timeOfLessonsFour.getText().toString(),
                timeOfLessonsFive.getText().toString(),
                timeOfLessonsSix.getText().toString(),
                timeOfLessonsSeven.getText().toString(),
                dayOfWeek.getText().toString());
                listItem.setId(id);

        new Thread( new Runnable() {
            @Override
            public void run() {
                DataBase.newInstance().update(listItem);
            }
        }).start();
        startMainActivity();
    }

    @Override
    public void onBackPressed() {
        startMainActivity();
    }

    private void startMainActivity() {
        Intent intent=new Intent(this,MainActivity.class);
        intent.putExtra("week", isSecondWeek);
        startActivity(intent);
        finish();
    }
}
