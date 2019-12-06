package ru.progwards.java1.lessons.bitsworld;

public class CheckBit {
    // функция, возвращающая указанный бит
    public static int checkBit(byte value, int bitNumber) {
        int result = value >> bitNumber;
        result = result & 0b00000001;

        return result;
    }

    public static void main(String[] args) {
        byte value = -80;
        System.out.println(checkBit(value, 1));
    }
}
