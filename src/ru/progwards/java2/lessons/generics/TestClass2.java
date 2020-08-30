//Задача 2. Класс DynamicArray
package ru.progwards.java2.lessons.generics;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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

            {"task2", "Задача 2. Класс DynamicArray", "20", ""},
            {"test1", "Метод add", "5", "*"},
            {"test2", "Метод insert", "5", "*"},
            {"test2", "Метод remove", "5", "*"},
            {"test2", "Метод size", "5", "*"},
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
        String act = "были добавлены элементы: ";
        DynamicArray<Integer> ba = new DynamicArray<>();

        String is = "";
        ba.add(1);
        is += "1";
        check(act, is, is, ba, false);
        ba.add(2);
        is += ", 2";
        check(act, is, is, ba, false);
        ba.add(3);
        is += ", 3";
        check(act, is, is, ba, false);
        ba.add(4);
        is += ", 4";
        check(act, is, is, ba, false);
    }

    @Test
    public void test2() {
        String act = "add были добавлены элементы: 1, 2, 3, 4. Затем были вставлены элементы: ";
        DynamicArray<Integer> ba = new DynamicArray<>();

        String is = "";
        ba.add(1);
        ba.add(2);
        ba.add(3);
        ba.add(4);
        is += "1, 2, 3, 4";
        ba.insert(0, 6);
        act += "6 на позицию 0";
        check(act, "", "6, " + is, ba, false);
        ba.insert(5, 8);
        act += ", 8 на позицию 7";
        check(act, "", "6, " + is + ", 8", ba, false);
        ba.insert(4, 5);
        act += ", 5 на позицию 4";
        check(act, "", "6, 1, 2, 3, 5, 4, 8", ba, false);
        ba.insert(6, 7);
        act += ", 7 на позицию 6";
        check(act, "", "6, 1, 2, 3, 5, 4, 7, 8", ba, false);
    }

    @Test
    public void test3() {
        String act = "add были добавлены элементы: 1, 2, 3. Затем были удалены элементы с позиций:  ";
        DynamicArray<Integer> ba = new DynamicArray<>();

        ba.add(1);
        ba.add(2);
        ba.add(3);

        ba.remove(0);
        act += "0";
        check(act, "", "2, 3", ba, false);
        ba.remove(1);
        act += ", 1";
        check(act, "", "2", ba, false);
    }

    @Test
    public void test4() {
        String act = "add были добавлены элементы: ";
        DynamicArray<Integer> ba = new DynamicArray<>();

        String is = "";
        ba.add(1);
        is += "1";
        check(act, is, "1", ba, true);
        ba.add(2);
        is += ", 2";
        check(act, is, "2", ba, true);
        ba.add(3);
        is += ", 3";
        check(act, is, "3", ba, true);
        ba.add(4);
        is += ", 4";
        check(act, is, "4", ba, true);
    }


    private void check(String act, String is, String rs, DynamicArray ba, boolean isForSize){
        String us = "";
        System.out.println(rs);
        if (isForSize){
            us = String.valueOf(ba.size());
        }
        else{
            for (int i = 0; i < 100; i++){
                try{
                    Integer a = (Integer)ba.get(i);
                    us += a + ", ";
                }catch (Exception e)
                {
                    break;
                }
            }
            if (us.endsWith(", ")) us = us.substring(0, us.length() - 2);
        }

        Assert.assertTrue("При помощи метода " + act + is +
                (isForSize ? ("\nВозвращено: " + us + ". Ожидалось: " + rs)
                : ("\nВ результате массив сожержит элементы:\n" + us + "\nОжидалось: " + rs))
                , rs.equals(us));
    }

    // это обязательная функция, она возвращает данные теста утилите
    public static String[][] getData() {
        return testData;
    }
}
