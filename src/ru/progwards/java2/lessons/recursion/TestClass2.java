//Задача 2. Класс AsNumbersSum
package ru.progwards.java2.lessons.recursion;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.text.DecimalFormat;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;

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

            {"task2", "Задача 2. Класс AsNumbersSum", "18", ""},
            {"test1", "Метод asNumbersSum(int number)", "18", "*"},
    };

    // Если надо - инициализация и завершение теста
    @Before
    public void init() {
    }

    @After
    public void done() {
    }

    @Test
    public void test1(){
        for (int i = 2; i < 10; i++){
            String rs = asNumbersSum(i);
            String us = AsNumbersSum.asNumbersSum(i);

            Assert.assertTrue("Метод вызван с параметром: " + i +
                    "\nВозвращено: " + us + "\nОжидалось: " + rs, rs.equals(us));
        }
    }

    private static String asNumbersSum(int number) {
        return number + divideIntoTerms(number, 1, "");
    }

    private static String divideIntoTerms(int number, int secondTerm, String lastTerm) {
        if(number == 1)
            return "";
        if(number/2 < secondTerm)
            return divideIntoTerms(number-1, 1, lastTerm + "+1");
        return " = " + (number-secondTerm) + "+" + secondTerm + lastTerm + divideIntoTerms(number, secondTerm+1, lastTerm);

    }


    // это обязательная функция, она возвращает данные теста утилите
    public static String[][] getData() {
        return testData;
    }
}
