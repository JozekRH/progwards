package ru.progwards.java1.lessons.classes1;

public class Time {
    int hours;
    int minutes;
    int seconds;

    public Time(int hours, int minutes, int seconds){
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public String toString(){
        return (hours < 10 ? "0" + hours : hours) + ":"
            + (minutes < 10 ? "0" + minutes : minutes) + ":"
                + (seconds < 10 ? "0" + seconds : seconds);
    }

    public int toSeconds(){
        return hours * 60 * 60 + minutes * 60 + seconds;
    }

    public int secondsBetween(Time time){
        return Math.abs(toSeconds() - time.toSeconds());
    }
}
