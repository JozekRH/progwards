//Задача 2. Класс NumMetrics
package ru.progwards.java1.lessons.wrappers;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.ThreadLocalRandom;

public class TestClass2 {
    // массив с данными для процессинга результата теста
    // 0: идентификатор теста, - имя функции @Test
    // 1: имя теста словами, если == "", то возмется идентификатор
    // 2: баллы за эту часть теста
    // 3: * отмечены обязательные части теста
    private static String[][] testData = {
            // Первая строка [0] содержит данные о всем тесте.
            // Оценка отражает проходной балл
            //       - это информация для утилиты проверки

            {"task2", "Задача 2. Класс NumMetrics", "16", ""},
            {"test1", "Метод sumDigits(Integer number)", "8", "*"},
            {"test2", "Метод mulDigits(Integer number)", "8", "*"},
    };

    @Test
    public void test1() {
        int r = ThreadLocalRandom.current().nextInt(1, 9) * 100
                + ThreadLocalRandom.current().nextInt(1, 9) * 10
                + ThreadLocalRandom.current().nextInt(1, 9);
        Integer ur = NumMetrics.sumDigits(r);
        Integer rr = sumDigits(r);
        Assert.assertTrue("Метод возвращает неверное значение. Передан параметр: " + r
                + ". Возвращено: " + ur + ". Ожидалось: " + rr , ur.equals(rr));
    }

    @Test
    public void test2() {
        int r = ThreadLocalRandom.current().nextInt(1, 9) * 100
                + ThreadLocalRandom.current().nextInt(1, 9) * 10
                + ThreadLocalRandom.current().nextInt(1, 9);
        Integer ur = NumMetrics.mulDigits(r);
        Integer rr = mulDigits(r);
        Assert.assertTrue("Метод возвращает неверное значение. Передан параметр: " + r
                + ". Возвращено: " + ur + ". Ожидалось: " + rr , ur.equals(rr));
    }

    private Integer sumDigits(Integer number){
        if (number == null) return null;
        Integer sum = 0;
        while(number != 0){
            sum += (number % 10);
            number /= 10;
        }
        return sum;
    }

    private Integer mulDigits(Integer number){
        if (number == null) return null;
        Integer mul = 1;
        while(number != 0){
            mul *= (number % 10);
            number /= 10;
        }
        return mul;
    }

    // это обязательная функция, она возвращает данные теста утилите
    public static String[][] getData() {
        return testData;
    }
}