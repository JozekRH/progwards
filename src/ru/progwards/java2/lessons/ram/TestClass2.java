//Задача 2. RAM - алгоритм деления с остатком
package ru.progwards.java2.lessons.ram;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.progwards.lms.ram.RamCompiler;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeoutException;

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

            {"task2", "Задача 2. RAM - алгоритм деления с остатком", "15", ""},
            {"test1", "Проверка работы алгоритма", "15", "*"},
    };

    private String fileName = "div.ram";
    private String dir = TestClass2.class.getProtectionDomain().getCodeSource().getLocation().getPath()
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
    public void test1() throws Exception {
        for (int i = 0; i <= 20; i++){
            List<Integer> il = Arrays.asList(new Integer[]{i, 20 - i + 1});
            List<Integer> rl = new ArrayList<>();
            rl.addAll(Arrays.asList(new Integer[]{i / (20 - i + 1), i % (20 - i + 1)}));

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
