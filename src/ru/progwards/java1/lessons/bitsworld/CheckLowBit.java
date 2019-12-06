package ru.progwards.java1.lessons.bitsworld;

public class CheckLowBit {
    // функция, возвращающая младший бит
    public static int checkLowBit(byte value) {
        int result = value & 0b00000001;
        return result;
    }

    public static void main(String[] args) {
        byte value = 87;
        int result = checkLowBit(value);
        System.out.println(result);
    }
}
