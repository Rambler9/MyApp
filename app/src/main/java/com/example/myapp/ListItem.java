package com.example.myapp;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class ListItem
{
    @PrimaryKey(autoGenerate = true)
            private long id;
    String firstLesson;
    String secondLesson;
    String thirdLesson;
    String fourthLesson;
    String fifthLesson;
    String sixthLesson;
    String seventhLesson;
    String timeFirstLesson;
    String timeSecondLesson;
    String timeThirdLesson;
    String timeFourthLesson;
    String timeFifthLesson;
    String timeSixthLesson;
    String timeSeventhLesson;
    String dayOfWeek;

    public ListItem(String firstLesson, String secondLesson, String thirdLesson, String fourthLesson,
                    String fifthLesson, String sixthLesson, String seventhLesson,
                    String timeFirstLesson, String timeSecondLesson, String timeThirdLesson, String timeFourthLesson,
                    String timeFifthLesson, String timeSixthLesson, String timeSeventhLesson,
                    String dayOfWeek) {
        this.firstLesson = firstLesson;
        this.secondLesson = secondLesson;
        this.thirdLesson = thirdLesson;
        this.fourthLesson = fourthLesson;
        this.fifthLesson = fifthLesson;
        this.sixthLesson = sixthLesson;
        this.seventhLesson = seventhLesson;
        this.timeFirstLesson = timeFirstLesson;
        this.timeSecondLesson = timeSecondLesson;
        this.timeThirdLesson = timeThirdLesson;
        this.timeFourthLesson = timeFourthLesson;
        this.timeFifthLesson = timeFifthLesson;
        this.timeSixthLesson = timeSixthLesson;
        this.timeSeventhLesson = timeSeventhLesson;
        this.dayOfWeek = dayOfWeek;

    }

    public ListItem()
    {
    }

    public String getFirstLesson() {return firstLesson;}
    public String getSecondLesson() {return secondLesson;}
    public String getThirdLesson() {return thirdLesson;}
    public String getFourthLesson() {return fourthLesson;}
    public String getFifthLesson() {return fifthLesson;}
    public String getSixthLesson() {return sixthLesson;}
    public String getSeventhLesson() {return seventhLesson;}

    public void setFirstLesson(String firstLesson) {this.firstLesson = firstLesson;}
    public void setSecondLesson(String secondLesson) {this.secondLesson=secondLesson;}
    public void setThirdLesson(String thirdLesson) {this.thirdLesson=thirdLesson;}
    public void setFourthLesson(String fourthLesson) {this.fourthLesson=fourthLesson;}
    public void setFifthLesson(String fifthLesson) {this.fifthLesson=fifthLesson;}
    public void setSixthLesson(String sixthLesson) {this.sixthLesson=sixthLesson;}
    public void setSeventhLesson(String seventhLesson) {this.seventhLesson=seventhLesson;}

    public String getTimeFirstLesson() {return timeFirstLesson;}
    public String getTimeSecondLesson() {return timeSecondLesson;}
    public String getTimeThirdLesson() {return timeThirdLesson;}
    public String getTimeFourthLesson() {return timeFourthLesson;}
    public String getTimeFifthLesson() {return timeFifthLesson;}
    public String getTimeSixthLesson() {return timeSixthLesson;}
    public String getTimeSeventhLesson() {return timeSeventhLesson;}

    public void setTimeFirstLesson(String timeFirstLesson) {this.timeFirstLesson = timeFirstLesson;}
    public void setTimeSecondLesson(String timeSecondLesson) {this.timeSecondLesson=timeSecondLesson;}
    public void setTimeThirdLesson(String timeThirdLesson) {this.timeThirdLesson=timeThirdLesson;}
    public void setTimeFourthLesson(String timeFourthLesson) {this.timeFourthLesson=timeFourthLesson;}
    public void setTimeFifthLesson(String timeFifthLesson) {this.timeFifthLesson=timeFifthLesson;}
    public void setTimeSixthLesson(String timeSixthLesson) {this.timeSixthLesson=timeSixthLesson;}
    public void setTimeSeventhLesson(String timeSeventhLesson) {this.timeSeventhLesson=timeSeventhLesson;}

    public String getDayOfWeek() {return dayOfWeek;}

    public void setDayOfWeek(String dayOfWeek) {this.dayOfWeek = dayOfWeek;}

    public long getId(){return id;}
    public void setId(long id){this.id=id;}
}
