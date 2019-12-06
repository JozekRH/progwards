package ru.progwards.java1.lessons.basics;

import org.junit.Assert;
import org.junit.Test;

public class TestClassWrappers {
    // массив с данными для процессинга результата теста
    // 0: идентификатор теста, - имя функции @Test
    // 1: имя теста словами, если == "", то возмется идентификатор
    // 2: баллы за эту часть теста
    // 3: * отмечены обязательные части теста
    private static String[][] testData = {
            // Первая строка [0] содержит данные о всем тесте.
            // Оценка отражает проходной балл
            //       - это информация для утилиты проверки

            {"task2", "ДЗ урока BitsWorld, задача Wrappers", "22", ""},
            {"test1", "Тест sumStringNumbers()", "9", "*"},
            {"test2", "Тест sumInDecString()", "3", "*"},
            {"test3", "Тест sumInBinString()", "3", "*"},
            {"test4", "Тест sumInOctalString()", "2", ""},
            {"test5", "Тест sumInHexString()", "3", "*"},
            {"test6", "Тест sumInRadixString()", "2", ""},
    };

    @Test
    public void test1() {
        Assert.assertEquals("Проверка sumStringNumbers()", 3, Wrappers.sumStringNumbers("1", "2"));
        Assert.assertEquals("Проверка sumStringNumbers()", 55555, Wrappers.sumStringNumbers("55500", "55"));
        Assert.assertEquals("Проверка sumStringNumbers()", -1, Wrappers.sumStringNumbers("-1", "0"));
        Assert.assertEquals("Проверка sumStringNumbers()", -555, Wrappers.sumStringNumbers("-550", "-5"));
        Assert.assertEquals("Проверка sumStringNumbers()", 0, Wrappers.sumStringNumbers("-555", "555"));
    }

    @Test
    public void test2() {
        Assert.assertEquals("Проверка sumInDecString()", "55555", Wrappers.sumInDecString("55500", "55"));
    }

    @Test
    public void test3() {
        Assert.assertEquals("Проверка sumInBinString()", "1101100100000011", Wrappers.sumInBinString("55500", "55"));
    }

    @Test
    public void test4() {
        Assert.assertEquals("Проверка sumInOctalString()", "154403", Wrappers.sumInOctalString("55500", "55"));
    }

    @Test
    public void test5() {
        Assert.assertEquals("Проверка sumInHexString()", "d903", Wrappers.sumInHexString("55500", "55").toLowerCase());
    }

    @Test
    public void test6() {
        Assert.assertEquals("Проверка sumInRadixString()", "28197", Wrappers.sumInRadixString("55500", "55", 12).toLowerCase());
    }

    // это обязательная функция, она возвращает данные теста утилите
    public static String[][] getData() {
        return testData;
    }
}