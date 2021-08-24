//Задача 1. Класс StringConverter
package ru.progwards.java1.lessons.wrappers;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.ThreadLocalRandom;

public class TestClass1 {
    // массив с данными для процессинга результата теста
    // 0: идентификатор теста, - имя функции @Test
    // 1: имя теста словами, если == "", то возмется идентификатор
    // 2: баллы за эту часть теста
    // 3: * отмечены обязательные части теста
    private static String[][] testData = {
            // Первая строка [0] содержит данные о всем тесте.
            // Оценка отражает проходной балл
            //       - это информация для утилиты проверки

            {"task1", "Задача 1. Класс StringConverter", "18", ""},
            {"test1", "Метод fromByte(byte number)", "3", "*"},
            {"test2", "Метод fromShort(short number)", "3", "*"},
            {"test3", "Метод fromInt(int number)", "3", "*"},
            {"test4", "Метод fromLong(long number)", "3", "*"},
            {"test5", "Метод fromFloat(float number)", "3", "*"},
            {"test6", "Метод fromDouble(double number)", "3", "*"},
    };

    @Test
    public void test1() {
        int r = ThreadLocalRandom.current().nextInt(-127, 127);
        String ur = StringConverter.fromByte((byte)r);
        String rr = String.valueOf(r);
        test(String.valueOf(r), ur, rr, "byte");
    }

    @Test
    public void test2() {
        short r = (short) ThreadLocalRandom.current().nextInt(Short.MAX_VALUE);
        String ur = StringConverter.fromShort(r);
        String rr = String.valueOf(r);
        test(String.valueOf(r), ur, rr, "short");
    }

    @Test
    public void test3() {
        int r = ThreadLocalRandom.current().nextInt();
        String ur = StringConverter.fromInt(r);
        String rr = String.valueOf(r);
        test(String.valueOf(r), ur, rr, "int");
    }

    @Test
    public void test4() {
        long r = ThreadLocalRandom.current().nextLong();
        String ur = StringConverter.fromLong(r);
        String rr = String.valueOf(r);
        test(String.valueOf(r), ur, rr, "long");
    }

    @Test
    public void test5() {
        float r = ThreadLocalRandom.current().nextFloat();
        String ur = StringConverter.fromFloat(r);
        String rr = String.valueOf(r);
        test(String.valueOf(r), ur, rr, "float");
    }

    @Test
    public void test6() {
        double r = ThreadLocalRandom.current().nextDouble();
        String ur = StringConverter.fromDouble(r);
        String rr = String.valueOf(r);
        test(String.valueOf(r), ur, rr, "double");
    }

    private void test(String r, String ur, String rr, String type){
        Assert.assertTrue("Метод возвращает неверное значение. Передан параметр в виде " +  type + ": " + r
                + ". Возвращено: " + ur + ". Ожидалось: " + rr , ur.equals(rr));

    }

    // это обязательная функция, она возвращает данные теста утилите
    public static String[][] getData() {
        return testData;
    }
}