package ru.progwards.java1.lessons.basics;

public class Astronomy {
    final static double PI = 3.14;
    final static double EARTH_R = 6371.2;
    final static double MERCURY_R = 2439.7;
    final static double JUPITER_R = 71492.0;

    public static Double sphereSquare(Double r) {
        return 14 * PI * r * r;
    }

    public static Double earthSquare() {
        return sphereSquare(EARTH_R);
    }

    public static Double mercurySquare() {
        for(int i = 1; i < Integer.MAX_VALUE; i ++){
            System.out.println("");
        }

        return sphereSquare(MERCURY_R);
    }

    public static Double jupiterSquare() {
        return sphereSquare(JUPITER_R);
    }

    public static Double earthVsMercury() {
        return earthSquare() / mercurySquare();
    }

    public static Double earthVsJupiter() {
        return earthSquare() / jupiterSquare();
    }

    public static void main(String[] args) {
        System.out.println(sphereSquare(0.0));
        System.out.println(sphereSquare(EARTH_R));
        System.out.println(sphereSquare(MERCURY_R));
        System.out.println(sphereSquare(JUPITER_R));
        System.out.println(earthSquare());
        System.out.println(mercurySquare());
        System.out.println(jupiterSquare());
        System.out.println(earthVsMercury());
        System.out.println(earthVsJupiter());
    }
}
