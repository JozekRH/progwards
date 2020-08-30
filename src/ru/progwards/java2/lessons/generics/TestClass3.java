//Задача 3. Класс FruitBox
package ru.progwards.java2.lessons.generics;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

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

            {"task3", "Задача 3. Класс FruitBox", "25", ""},
            {"test1", "Метод add", "10", "*"},
            {"test2", "Метод moveTo", "15", "*"},
            {"test3", "Метод compareTo", "10", "*"},
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
        FruitBox<Fruit> fba = new FruitBox<>();
        fba.add(new Apple());
        fba.add(new Orange());
        fba.add(new Apple());
        float uf = fba.getWeight();
        float rf = 2.0f;


        Assert.assertTrue("В коробку были последовательно добавлены 3 объекта: Apple, Orange, Apple." +
                "\nМетод getWeight() возвратил значение: " + uf + ", ожидалось: " + rf, uf == rf);
    }

    @Test
    public void test2() {
        String paramStr = "В 1-ю коробку были последовательно добавлены 3 объекта: Orange, Orange, Apple. " +
                "Во 2-ю коробку были последовательно добавлены 3 объекта: Orange, Apple, Apple. " +
                "В 3-ю коробку был добавлен объект Apple. ";
        String nextStr = "Затем для 1-й коробки был вызван метод moveTo со 2-й коробкой в качестве параметра";
        String nextStr1 = ", затем для 3-й коробки был вызван метод moveTo со 2-й коробкой в качестве параметра.";

        FruitBox<Fruit> fb1 = new FruitBox<>();
        fb1.add(new Orange());
        fb1.add(new Orange());
        fb1.add(new Apple());

        FruitBox<Fruit> fb2 = new FruitBox<>();
        fb2.add(new Orange());
        fb2.add(new Apple());
        fb2.add(new Apple());

        FruitBox<Fruit> fb3 = new FruitBox<>();
        fb3.add(new Apple());

        Boolean b1 = null;
        try {
            fb1.moveTo(fb2);
        }catch(Exception e){
            if (e.getClass().getSimpleName().equals("UnsupportedOperationException")) b1 = true;
            else b1 = false;
        }

        float uf1 = fb1.getWeight();
        float rf1 = 0f;

        float uf2 = fb2.getWeight();
        float rf2 = 4.5f;


        if (b1 == null) {
            Assert.assertTrue(paramStr + nextStr +
                    ".\nМетод getWeight() для 1-й коробки возвратил значение: " + uf1 + ", ожидалось: " + rf1, uf1 == rf1);

            Assert.assertTrue(paramStr + nextStr +
                    ".\nМетод getWeight() для 2-й коробки возвратил значение: " + uf2 + ", ожидалось: " + rf2, uf2 == rf2);
        }else if (b1 == true){
            Assert.assertTrue(paramStr + nextStr +
                    ".\nПосле добавлений в 1-й коробке должны были оказаться только объекты типа Orange, как и во 2-й, " +
                    "однако метод moveTo возвратил исключение типа UnsupportedOperationException.", false);

        }
        else if (b1 == false){
            Assert.assertTrue(paramStr + nextStr + nextStr1 +
                    "\nМетод moveTo возвратил непредвиденное исключение.", false);
        }


        Boolean b2 = null;
        try {
            fb3.moveTo(fb2);
        }catch(Exception e){
            if (e.getClass().getSimpleName().equals("UnsupportedOperationException")) b2 = true;
            else b2 = false;
        }

        Assert.assertTrue(paramStr + nextStr + nextStr1 +
                "\nМетод moveTo должен был возвратить исключение типа UnsupportedOperationException, однако " +
                (b2 == null ? "этого не произошло." : "он возвратил непредвиденное исключение."),
                b2 != null && b2 == true);

    }

    @Test
    public void test3() {
        String paramStr = "В 1-ю коробку были последовательно добавлены 3 объекта Apple. " +
                "Во 2-ю коробку были последовательно добавлены 2 объекта Apple. " +
                "В 3-ю коробку были добавлены 2 объекта Orange. ";

        FruitBox<Fruit> fb1 = new FruitBox<>();
        fb1.add(new Apple());
        fb1.add(new Apple());
        fb1.add(new Apple());

        FruitBox<Fruit> fb2 = new FruitBox<>();
        fb2.add(new Apple());
        fb2.add(new Apple());

        FruitBox<Fruit> fb3 = new FruitBox<>();
        fb3.add(new Orange());
        fb3.add(new Orange());

        int ui1 = fb1.compareTo(fb2);
        int ui2 = fb2.compareTo(fb1);
        int ui3 = fb1.compareTo(fb3);

        Assert.assertTrue(paramStr + "Затем для 1-й коробки был вызван метод compareTo со 2-й коробкой в качестве параметра." +
                "\nВозвращено: " + ui1 + ", ожидалось: 1" , ui1 == 1);
        Assert.assertTrue(paramStr + "Затем для 2-й коробки был вызван метод compareTo со 1-й коробкой в качестве параметра." +
                "\nВозвращено: " + ui2 + ", ожидалось: -1" , ui2 == -1);
        Assert.assertTrue(paramStr + "Затем для 1-й коробки был вызван метод compareTo с 3-й коробкой в качестве параметра." +
                "\nВозвращено: " + ui3 + ", ожидалось: 0" , ui3 == 0);
    }


    // это обязательная функция, она возвращает данные теста утилите
    public static String[][] getData() {
        return testData;
    }
}
