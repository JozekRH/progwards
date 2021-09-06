package ru.progwards.java1.lessons.inheritance;

public class TimeZone {

    public int hours;
    public int minutes;

    public TimeZone(int hours){
        this.hours = hours;
        this.minutes = 0;
    }

    public TimeZone(int hours, int minutes){
        this.hours = hours;
        this.minutes = minutes;
    }
}
