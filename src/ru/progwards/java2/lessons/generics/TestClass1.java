//Задача 1. Класс ArraySort
package ru.progwards.java2.lessons.generics;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.progwards.lms.ram.RamCompiler;

import java.io.File;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeoutException;

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

            {"task1", "Задача 1. Класс ArraySort", "15", ""},
            {"test1", "Метод sort", "15", "*"},
    };


    // Если надо - инициализация и завершение теста
    @Before
    public void init() {
    }

    @After
    public void done() {
    }

    @Test
    public void test1() {
        List<Integer> il = new ArrayList<>();
        for (int i = 0; i < ThreadLocalRandom.current().nextInt(10, 20); i++){
            Integer a = ThreadLocalRandom.current().nextInt(1, 100);
            il.add(a);
        }
        ArraySort as = new ArraySort();
        String is = il.toString();
        Integer[] ua = il.toArray(new Integer[0]);
        Integer[] ra = il.toArray(new Integer[0]);
        as.sort(ua);
        sort(ra);
        String us =  Arrays.asList(ua).toString();
        String rs =  Arrays.asList(ua).toString();

        Assert.assertTrue("Метод вызван с параметром-массивом, содержащим элементы:\n" + is +
                "\nВ результате массив имеет последовательность:\n" + us + "\nОжидалось: " + rs, rs.equals(us));
    }

    public <T extends Comparable<T>>void sort(T[] arr) {
        for(int i = 0; i < arr.length-1; i++) {
            for(int j = i+1; j < arr.length; j++) {
                if(arr[i].compareTo(arr[j]) > 0) {
                    T tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }

    
    // это обязательная функция, она возвращает данные теста утилите
    public static String[][] getData() {
        return testData;
    }
}
