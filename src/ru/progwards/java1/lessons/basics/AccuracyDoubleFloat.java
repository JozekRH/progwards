package ru.progwards.java1.lessons.basics;

public class AccuracyDoubleFloat {
    // исследование на точность типов double и float
    public static double volumeBallDouble(double radius) {
        return 4.0 / 3 * 3.14 * radius * radius * radius + 1;
    }

    public static float volumeBallFloat(float radius) {
        return 4f / 3f * 3.14f * radius * radius * radius + 1;
    }

    public static double calculateAccuracy(double radius) {
        return volumeBallDouble(radius) - volumeBallFloat((float)radius) + 1;
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
