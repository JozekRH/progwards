package ru.progwards.java1.lessons.inheritance;

public class ZonedTime extends Time{

    TimeZone zone;

    public ZonedTime(int hours, int minutes, int seconds){
        super(hours, minutes, seconds);
        this.zone = new TimeZone(0);
    }

    public ZonedTime(int hours, int minutes, int seconds, TimeZone zone){
        super(hours, minutes, seconds);
        this.zone = zone;
    }

    @Override
    public TimeZone getTimeZone(){
        return this.zone;
    }

    @Override
    public int secondsBetween(Time time){
        return Math.abs(super.toSeconds() - (getTimeZone().hours * 60 * 60 + getTimeZone().minutes * 60)
                - time.toSeconds() - (time.getTimeZone() == null ? 0 : (time.getTimeZone().hours * 60 * 60 + time.getTimeZone().minutes * 60)));
    }

    public static void main(String[] args){
        ZonedTime zt1 = new ZonedTime(12, 30, 0, new TimeZone(-1));
        ZonedTime zt2 = new ZonedTime(11, 30, 0, new TimeZone(0));
        System.out.println(zt1.secondsBetween(zt2));
        Time t1 = new Time(13, 30, 0);
        Time t2 = new Time(11, 30, 0);
        System.out.println(t1.secondsBetween(t2));
        System.out.println(zt1.secondsBetween(t2));
    }
}
