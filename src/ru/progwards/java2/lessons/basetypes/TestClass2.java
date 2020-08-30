//Задача 2. Класс DoubleHashTable
package ru.progwards.java2.lessons.basetypes;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
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

            {"task2", "Задача 2. Класс DoubleHashTable", "18", ""},
            {"test1", "add(K key, V value)", "18", "*"},
    };

    // Если надо - инициализация и завершение теста
    @Before
    public void init() {
    }

    @After
    public void done() {
    }

    @Test
    public void test1() throws Exception{
        DoubleHashTable<HashValue, Integer> dht = new DoubleHashTable<HashValue, Integer>();
        List<String> adds = new ArrayList<>();

        for (int i = 1; i <= 10; i++){
            KeyInteger ki = new KeyInteger(i);
            KeyString ks = new KeyString(String.valueOf(i));
            dht.add(ki, i + 1000);
            dht.add(ks, i + 2000);

            int uii = dht.get(ki);
            int uis = dht.get(ks);

            String.valueOf(1);

            Assert.assertTrue("Метод вызван для параметров: new KeyInteger(" + i + ") и " + (i + 1000) +
                    ", а затем для параметров new KeyString(\"" + i + "\") и " + (i + 2000) +
                    "\nМетод get(new KeyInteger(" + i + ")) возвратил значение: " + uii + ", ожидалось: " + (i + 1000) +
                    ", метод get(new KeyString(\"" + i + "\")) возвратил значение: " + uis + ", ожидалось: " + (i + 2000),
                    uii == i + 1000 && uis == i + 2000);
        }
    }

    @Test
    public void test2() throws Exception{
        DoubleHashTable<HashValue, Integer> dht = new DoubleHashTable<HashValue, Integer>();
        List<String> adds = new ArrayList<>();

        for (int i = 1; i <= 10; i++){
            KeyInteger ki = new KeyInteger(i);
            KeyString ks = new KeyString(String.valueOf(i));
            dht.add(ki, i + 1000);
            dht.add(ks, i + 2000);
            dht.remove(ki);
            dht.remove(ks);

            Integer uii = null;
            Integer uis = null;

            try {
                uii = dht.get(ki);
            }catch (Exception e){}
            try {
                uis = dht.get(ks);
            }catch (Exception e){}

            String condition = "Метод add вызван для параметров: new KeyInteger(" + i + ") и " + (i + 1000) +
                    ", а затем для параметров new KeyString(\"" + i + "\") и " + (i + 2000) +
                    ", после чего для указанных ключей был последовательно вызван метод remove." +
                    "\nТем не менее, ";

            Assert.assertTrue(condition + "метод get(new KeyInteger(" + i + ")) возвратил значение: " + uii,  uii == null);

            Assert.assertTrue(condition + "метод get(new KeyString(\"" + i + "\")) возвратил значение: " + uis, uis == null);
        }
    }

    @Test
    public void test3() throws Exception{
        DoubleHashTable<HashValue, Integer> dht = new DoubleHashTable<HashValue, Integer>();
        List<String> adds = new ArrayList<>();

        for (int i = 1; i <= 10; i++){
            KeyInteger ki = new KeyInteger(i);
            KeyString ks = new KeyString(String.valueOf(i));
            KeyInteger kic = new KeyInteger(i + 100);
            KeyString ksc = new KeyString(String.valueOf(i + 100));
            dht.add(ki, i + 1000);
            dht.add(ks, i + 2000);
            dht.change(ki, kic);
            dht.change(ks, ksc);

            Integer uii = null;
            Integer uis = null;
            Integer uiic = null;
            Integer uisc = null;

            try {
                uii = dht.get(ki);
            }catch (Exception e){}
            try {
                uis = dht.get(ks);
            }catch (Exception e){}
            try {
                uiic = dht.get(kic);
            }catch (Exception e){}
            try {
                uisc = dht.get(ksc);
            }catch (Exception e){}

            String condition = "Метод add вызван для параметров: new KeyInteger(" + i + ") и " + (i + 1000) +
                    ", а затем для параметров new KeyString(\"" + i + "\") и " + (i + 2000) +
                    ", после чего для указанных ключей был последовательно вызван метод change с указанием новых ключей: new KeyInteger(" + (i + 100) + ")" +
                    " и new KeyString(\"" + (i + 100) + "\") соответственно.";
            Assert.assertTrue(condition + "\nТем не менее, метод get(new KeyInteger(" + i + ")) возвратил значение: " + uii,  uii == null);
            Assert.assertTrue(condition + "\nТем не менее, метод get(new KeyString(\"" + i + "\")) возвратил значение: " + uis, uis == null);
            Assert.assertTrue(condition + "\nМетод get(new KeyInteger(" + (i + 100) + ")) возвратил значение: " + uiic + ", ожидалось: " + (i + 1000),  uiic == i + 1000);
            Assert.assertTrue(condition + "\nМетод get(new KeyString(\"" + (i + 100) + "\")) возвратил значение: " + uisc + ", ожидалось: " + (i + 2000), uisc == i + 2000);
        }
    }

    @Test
    public void test4() throws Exception{
        DoubleHashTable<HashValue, Integer> dht = new DoubleHashTable<HashValue, Integer>();

        for (int i = 1; i <= 10; i++){
            KeyInteger ki = new KeyInteger(i);
            dht.add(ki, i + 1000);
            int ui = dht.size();

            Assert.assertTrue("В таблицу было добавлено " + i + " пар ключ-значение, однако метод возвратил значение: " + ui,
                    ui == i);
        }
    }

    @Test
    public void test5() throws Exception{
        DoubleHashTable<HashValue, Integer> dht = new DoubleHashTable<HashValue, Integer>();
        List<String> adds = new ArrayList<>();
        List<String> rets = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            KeyInteger ki = new KeyInteger(i);
            dht.add(ki, i + 1000);
            adds.add(i + " : " + (i + 1000));
        }

        Iterator it = dht.iterator();
        for (int i = 1; i <= 10; i++){
            rets.add(String.valueOf(it.next()));
        }

        String us = String.join(", ", rets);
        String rs = String.join(", ", adds);

        Assert.assertTrue("Метод add вызван последовтельно для пар со значениями: " + rs +
                ". Затем 10 раз был вызван метод итератора next()." +
                "\nВыводы метода оказались: " + us + ", ожидалось: " + rs, us.equals(rs));
    }



    // это обязательная функция, она возвращает данные теста утилите
    public static String[][] getData() {
        return testData;
    }
}
