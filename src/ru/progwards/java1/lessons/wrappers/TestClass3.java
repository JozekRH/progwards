//Задача 3. Класс AccuracyDoubleFloat
package ru.progwards.java1.lessons.wrappers;

import org.junit.Assert;
import org.junit.Test;

public class TestClass3 {
    // массив с данными для процессинга результата теста
    // 0: идентификатор теста, - имя функции @Test
    // 1: имя теста словами, если == "", то возмется идентификатор
    // 2: баллы за эту часть теста
    // 3: * отмечены обязательные части теста
    private static String[][] testData = {
            // Первая строка [0] содержит данные о всем тесте.
            // Оценка отражает проходной балл
            //       - это информация для утилиты проверки

            {"task3", "Задача 3. Класс AccuracyDoubleFloat", "28", ""},
            {"test1", "Метод volumeBallDouble(double radius)", "10", "*"},
            {"test2", "Метод volumeBallFloat(float radius)", "10", "*"},
            {"test3", "Метод calculateAccuracy(double radius)", "8", ""},
    };

    final double earthRadius = 6371.2;

    private boolean EqualsWithAccuracy1Percent(double expected, double val) {
        double diff = Math.abs(val - expected);
        return expected == 0.0 ? diff < 0.0000001 : Math.abs(diff / expected) < 0.01;
    }

    @Test
    public void test1() {
        double ur = AccuracyDoubleFloat.volumeBallDouble(earthRadius);
        double rr = volumeBallDouble(earthRadius);
        Assert.assertTrue("Метод возвращает неверное значение. Передан параметр: " + earthRadius
                + ". Возвращено: " + ur + ". Ожидалось: " + rr , EqualsWithAccuracy1Percent(rr, ur));
    }

    @Test
    public void test2() {
        double ur = AccuracyDoubleFloat.volumeBallFloat((float)earthRadius);
        double rr = volumeBallFloat((float)earthRadius);
        Assert.assertTrue("Метод возвращает неверное значение. Передан параметр: " + (float)earthRadius
                + ". Возвращено: " + ur + ". Ожидалось: " + rr , EqualsWithAccuracy1Percent(rr, ur));
    }

    @Test
    public void test3() {
        double ur = AccuracyDoubleFloat.calculateAccuracy(earthRadius);
        double rr = AccuracyDoubleFloat.volumeBallDouble(earthRadius) - AccuracyDoubleFloat.volumeBallFloat((float)earthRadius);
        Assert.assertTrue("Метод возвращает неверное значение. Передан параметр: " + earthRadius
                + ". Возвращено: " + ur + ". Согласно результатам ваших методов volumeBallDouble и volumeBallFloat ожидалось: " + rr , EqualsWithAccuracy1Percent(rr, ur));
    }

    private double volumeBallDouble(double radius) {
        return Math.abs(4.0 / 3.0 * 3.14 * radius * radius * radius);
    }

    private float volumeBallFloat(float radius) {
        return Math.abs(4f / 3f * 3.14f * radius * radius * radius);
    }

    //Не используется, считаем по результатам методов ученика
    private double calculateAccuracy(double radius) {
        return volumeBallDouble(radius) - volumeBallFloat((float)radius);
    }

    // это обязательная функция, она возвращает данные теста утилите
    public static String[][] getData() {
        return testData;
    }
}