//Задача 3. RAM - Алгоритм сортировки
package ru.progwards.java2.lessons.ram;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.progwards.lms.ram.RamCompiler;

import java.io.File;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeoutException;

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

            {"task3", "Задача 3. RAM - Алгоритм сортировки", "32", ""},
            {"test1", "Проверка работы алгоритма", "32", "*"},
    };

    private String fileName = "sort.ram";
    private String dir = TestClass3.class.getProtectionDomain().getCodeSource().getLocation().getPath()
            + "ru/progwards/java2/lessons/ram/";

    // Если надо - инициализация и завершение теста
    @Before
    public void init() {
        //For both Windows/Linux working
        dir = new File(dir).getAbsolutePath() + "/";
    }

    @After
    public void done() {
    }

    @Test
    public void test1(){
        for (int i = 0; i < 20; i++){
            List<Integer> il = new ArrayList<>();
            for (int ii = 0; ii < i + 2; ii++){
                il.add(ThreadLocalRandom.current().nextInt(1, 20));
            }
            il.add(0, il.size());

            List<Integer> rl = new ArrayList<>();
            rl.addAll(il);
            rl.remove(0);
            Collections.sort(rl);

            String ur = null;
            String rr = String.valueOf(rl);

            try {
                ur = String.valueOf(RamCompiler.getOutputAsync(dir + fileName, il));
            } catch (Exception e){
                if (e.getClass().equals(TimeoutException.class)){
                    Assert.assertTrue("В качестве <input> был установлен массив: " + il +
                                    ", однако тест не был закончен" +
                                    ". Возможной причиной является попытка деления на ноль, бесконечный цикл в коде, либо слишком долгое его выполнение. "
                            , false);
                }else{
                    Assert.assertTrue("В качестве <input> был установлен массив: " + il +
                            ". Ожидался вывод: " + rr +
                            ", однако вызов завершился ошибкой: " + e.toString().replace(dir, ""), false);
                }
            }

            Assert.assertTrue("В качестве <input> был установлен массив: " + il +
                    ". Вывод соответствует: " + ur + ", ожидалось: " + rr, ur.equals(rr));
        }
    }
    
    // это обязательная функция, она возвращает данные теста утилите
    public static String[][] getData() {
        return testData;
    }
}
