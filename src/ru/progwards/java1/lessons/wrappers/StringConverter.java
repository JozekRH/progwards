package ru.progwards.java1.lessons.wrappers;

public class StringConverter {

    public static byte toByte(String number){
        return Byte.valueOf(number);
    }

    public static short toShort(String number){
        return Short.valueOf(number);
    }

    public static int toInt(String number){
        return Integer.valueOf(number);
    }

    public static long toLong(String number){
        return Long.valueOf(number);
    }

    public static float toFloat(String number){
        return Float.valueOf(number);
    }

    public static double toDouble(String number){
        return Double.valueOf(number);
    }


}
