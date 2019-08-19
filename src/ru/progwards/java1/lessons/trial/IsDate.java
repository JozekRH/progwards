package ru.progwards.java1.lessons.trial;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class IsDate {

	private static final DateFormat format = new SimpleDateFormat("d.M.yyyy");	

	public static boolean check(int day, int month, int year)
	{
		String date = day + "." + month + "." + year;
		
		try {
            return format.format(format.parse(date)).equals(date);
        }catch (Exception e){
            return false;
        }
	}
}
