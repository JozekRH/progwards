package ru.progwards.java1.lessons.static1;

class CalcTime {
    private static double distance;
    private static double speed;
    private static String cityFrom;
    private static String cityTo;

    public static void printTime(){
        System.out.println(String.format("Если ехать из %s в %s со скоростью %s км/ч, то %s км проедем за %s часов.",
                cityFrom, cityTo, speed, distance, distance / speed));
    }

    public static void MoscowToPiter(){
        distance = 712;
        speed = 80;
        cityFrom = "Москва";
        cityTo = "Питер";
    }

    public static void LissabonToVladivostok(){
        distance = 13090;
        speed = 75;
        cityFrom = "Лиссабон";
        cityTo = "Владивосток";
    }

    public static void MurmanskToAlmata(){
        distance = 5413;
        speed = 60;
        cityFrom = "Мурманск";
        cityTo = "Алмата";
    }

    public static void printTimes(){
        MoscowToPiter();
        printTime();
        LissabonToVladivostok();
        printTime();
        MurmanskToAlmata();
        printTime();
    }
}