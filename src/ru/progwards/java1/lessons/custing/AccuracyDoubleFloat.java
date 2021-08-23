package ru.progwards.java1.lessons.custing;

public class AccuracyDoubleFloat {

    public static double calculateAccuracy(){
        double d = 1D / 3D;
        float f = (float)d;
        return d - f;
    }
}
