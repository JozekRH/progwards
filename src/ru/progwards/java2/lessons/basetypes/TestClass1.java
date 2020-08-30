//Задача 1. Класс BiDirList
package ru.progwards.java2.lessons.basetypes;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.*;
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

            {"task1", "Задача 1. Класс BiDirList", "18", ""},
            {"test1", "Метод addLast(T item)", "18", "*"},
            {"test2", "Метод addFirst(T item)", "18", "*"},
            {"test3", "Метод remove(T item)", "18", "*"},
            {"test4", "Метод from(T[] array)", "18", "*"},
            {"test5", "Метод of(T...array) ", "18", "*"},
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
        BiDirList<Integer> bdl = new BiDirList<>();
        List<String> adds = new ArrayList<>();

        for (int i = 1; i <= 10; i++){
            bdl.addLast(i);
            adds.add(String.valueOf(i));
            int sizeu = bdl.size();
            int elu = bdl.at(i - 1);

            Assert.assertTrue("Метод вызван последовтельно для параметров: " + String.join(", ", adds) +
                    "\nМетод size() возвратил значение: " + sizeu + ", ожидалось: " + i +
                    ", метод at(" + (i - 1) + ") возвратил значение: " + elu + ", ожидалось: " + i, sizeu == i && elu == i);
        }
    }

    @Test
    public void test2(){
        BiDirList<Integer> bdl = new BiDirList<>();
        List<String> adds = new ArrayList<>();

        for (int i = 1; i <= 10; i++){
            bdl.addFirst(i);
            adds.add(String.valueOf(i));
            int sizeu = bdl.size();
            int elu = bdl.at(0);

            Assert.assertTrue("Метод вызван последовтельно для параметров: " + String.join(", ", adds) +
                    "\nМетод size() возвратил значение: " + sizeu + ", ожидалось: " + i +
                    ", метод at(0) возвратил значение: " + elu + ", ожидалось: " + (10 - i), sizeu == i && elu == i);
        }
    }

    @Test
    public void test3(){
        BiDirList<Integer> bdl = new BiDirList<>();
        List<String> adds = new ArrayList<>();
        List<String> rems = new ArrayList<>();
        Set<Integer> is = new HashSet<>();
        Set<Integer> isr = new HashSet<>();

        for (int i = 1; i <= 10; i++) {
            int a = ThreadLocalRandom.current().nextInt(1, 100);
            while (is.contains(a)){
                a = ThreadLocalRandom.current().nextInt(1, 100);
            }
            is.add(a);
            adds.add(String.valueOf(a));
            bdl.addLast(a);
            if (i == 1) continue;

            int r = is.toArray(new Integer[0])[ThreadLocalRandom.current().nextInt(0, is.toArray().length - 1)];
            is.remove(r);
            bdl.remove(r);
            rems.add(String.valueOf(r));

            Set<String> ras = new HashSet<>();
            for (int i1 = 0; i1 < is.size(); i1++){
                ras.add(String.valueOf(is.toArray()[i1]));
            }
            String rs = String.join(", ", ras);
            Set<String> bdls = new HashSet<>();
            for (int i1 = 0; i1 < bdl.size(); i1++){
                bdls.add(String.valueOf(bdl.at(i1)));
            }
            String us = String.join(", ", bdls);

            Assert.assertTrue("Метод addLast вызван последовтельно для параметров: " + String.join(", ", adds) +
                    ". Затем последовательно вызван метод delete для параметров: " + String.join(", ", rems) + "." +
                    "\nВ результате список содержал элементы: " + us + ", ожидалось: " + rs, rs.equals(us));
        }
    }

    @Test
    public void test4(){
        testConstr(0);
    }

    @Test
    public void test5(){
        testConstr(1);
    }

    @Test
    public void test6(){
        BiDirList<Integer> bdl = new BiDirList<>();
        List<String> adds = new ArrayList<>();

        for (int i = 1; i <= 10; i++){
            bdl.addLast(i);
            adds.add(String.valueOf(i));

            Integer[] ua = new Integer[i];
            bdl.toArray(ua);

            Set<String> bdls = new HashSet<>();
            for (int i1 = 0; i1 < bdl.size(); i1++){
                bdls.add(String.valueOf(ua[i1]));
            }
            String us = String.join(", ", bdls);
            String ur = String.join(", ", adds);

            Assert.assertTrue("Метод addLast вызван последовтельно для параметров: " + ur +
                    "\nОднако, массив, переданный в метод, в результате содержит элементы: " + us, ur.equals(us));
        }
    }

    @Test
    public void test7(){
        BiDirList<Integer> bdl = new BiDirList<>();
        List<String> adds = new ArrayList<>();
        List<String> rets = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            bdl.addLast(i);
            adds.add(String.valueOf(i));
        }

        Iterator it = bdl.getIterator();
        for (int i = 1; i <= 10; i++){
            rets.add(String.valueOf(it.next()));
        }

        String us = String.join(", ", rets);
        String rs = String.join(", ", adds);

        Assert.assertTrue("Метод addLast вызван последовтельно для параметров: " + rs +
                ". Затем 10 раз был вызван метод итератора next()." +
                "\nВыводы метода оказались: " + us + ", ожидалось: " + rs, us.equals(rs));
    }

    private void testConstr(int type){
        BiDirList<Integer> bdl;
        List<String> adds = new ArrayList<>();
        List<Integer> addi = new ArrayList<>();

        for (int i = 1; i <= 10; i++){
            adds.add(String.valueOf(i));
            addi.add(i);
            if (type == 0) {
                bdl = BiDirList.from(addi.toArray(new Integer[0]));
            }else{
                bdl = BiDirList.of(addi.toArray(new Integer[0]));
            }

            Set<String> bdls = new HashSet<>();
            for (int i1 = 0; i1 < bdl.size(); i1++){
                bdls.add(String.valueOf(bdl.at(i1)));
            }
            String us = String.join(", ", bdls);
            String rs = String.join(", ", adds);

            Assert.assertTrue("Список создан при помощи присвоения результата вызова метода c параметром-массивом, содержащим элементы: " + String.join(", ", adds) +
                    "\nОднако, в результате список содержит элементы: " + us + ".", rs.equals(us));
        }
    }

    // это обязательная функция, она возвращает данные теста утилите
    public static String[][] getData() {
        return testData;
    }
}
