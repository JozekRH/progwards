package ru.progwards.java1.lessons.wrappers;

public class AccuracyDoubleFloat {
    public static final double PI_DBL= 3.14;
    public static double volumeBallDouble(double radius){
        Double volumeDbl = (4d * PI_DBL * radius * radius * radius) / 3d;
        System.out.println(volumeDbl);
        return volumeDbl;
    }
    public static float volumeBallFloat(float radius){
        float volumeFl = (4 * (float)PI_DBL * radius * radius * radius) / 3;
        System.out.println(volumeFl);
        return volumeFl;
    }
    public static double calculateAccuracy(double radius){
        Double x = volumeBallDouble(radius);
        Float y = volumeBallFloat((float)radius);
        return  volumeBallDouble(radius) - volumeBallFloat((float)radius);
/*
        System.out.println(sub);
        return sub;
*/
    }

    public static void main(String[] args) {
        calculateAccuracy(6371.2);
    }
}