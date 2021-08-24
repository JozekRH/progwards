package ru.progwards.java1.lessons.cycles;

public class DigitCheck {
    public static boolean containsDigit(int number, int digit) {
        long remainder;
        do {
            remainder = number % 10;
            if (remainder == digit)
                return true;
            number /= 10;
        } while (number > 0);

        return false;
    }
}
