package ru.progwards.java1.lessons.datetime;
//123123123
//2222
//3333

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Insurance {
    //lalala

    public static enum FormatStyle {SHORT, LONG, FULL};
    private ZonedDateTime start;
    private Duration duration;
    
    public Insurance(ZonedDateTime start){
        this.start = start;
    }
    
    public Insurance(String strStart, FormatStyle style){
        switch (style){
            case SHORT:
                start = ZonedDateTime.of(LocalDate.parse(strStart, DateTimeFormatter.ISO_LOCAL_DATE), LocalTime.MIDNIGHT, ZoneId.systemDefault());
                break;
            case LONG:
                start = ZonedDateTime.parse(strStart, DateTimeFormatter.ISO_LOCAL_DATE_TIME.withZone(ZoneId.systemDefault()));
                break;
            case FULL:
                start = ZonedDateTime.parse(strStart, DateTimeFormatter.ISO_ZONED_DATE_TIME);
                break;
        }
        
    }
    
    public void setDuration(Duration duration){
        this.duration = duration;
    }
    
    public void setDuration(ZonedDateTime expiration){
        this.duration = Duration.between(start, expiration);
    }
    
    public void setDuration(int months, int days, int hours){
        setDuration(ZonedDateTime.from(start).plusMonths(months).plusDays(days).plusHours(hours));
    }
    
    public void setDuration(String strDuration, FormatStyle style){
        switch (style){
        case SHORT:
            setDuration(ZonedDateTime.from(start).plus(Long.parseLong(strDuration), ChronoUnit.MILLIS));
            break;
        case LONG:
            ZonedDateTime zdt = ZonedDateTime.parse(strDuration, DateTimeFormatter.ISO_LOCAL_DATE_TIME.withZone(ZoneId.systemDefault()));
            setDuration(ZonedDateTime.from(start).plusYears(zdt.getYear())
                    .plusMonths(zdt.getMonthValue()).plusDays(zdt.getDayOfMonth())
                    .plusHours(zdt.getHour()).plusMinutes(zdt.getMinute()).plusSeconds(zdt.getSecond()));
            break;
        case FULL:
            setDuration(Duration.parse(strDuration));
            break;
        }
        
    }
    
    public boolean checkValid(ZonedDateTime dateTime){
        return dateTime.isAfter(ZonedDateTime.from(start)) && ((duration == null) ? true : dateTime.isBefore(ZonedDateTime.from(start).plus(duration)));
    }
    
    public String toString(){
        ZonedDateTime zdt = ZonedDateTime.now();
        return "Insurance issued on " + start + (checkValid(zdt) ? " is valid" : " is not valid");
    }
}
