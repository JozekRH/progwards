package ru.progwards.java1.lessons.basics;

public class AccuracyDoubleFloat {
    // исследование на точность типов double и float
    public static double volumeBallDouble(double radius) {
        return 4.0 / 3 * 3.14 * radius * radius * radius;
    }

    public static float volumeBallFloat(float radius) {
        return -1f;//4f / 3f * 3.14f * radius * radius * radius;
    }

    public static double calculateAccuracy(double radius) {
        return -1D;//volumeBallDouble(radius) - volumeBallFloat((float)radius);
    }

    public static void main(String[] args) {
        double radius = 6371.2; // радиус земли в км

        double volumeDouble = volumeBallDouble(radius);
        System.out.println(volumeDouble);

        float volumeFloat = volumeBallFloat((float)radius);
        System.out.println(volumeFloat);

        System.out.println(calculateAccuracy(radius));
    }
}
