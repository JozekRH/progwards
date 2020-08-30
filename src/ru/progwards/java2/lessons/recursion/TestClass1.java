//Задача 1. Класс GoodsWithLambda
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

            {"task1", "Задача 1. Класс GoodsWithLambda", "21", ""},
            {"test1", "Метод sortByName()", "3", "*"},
            {"test2", "Метод sortByNumber()", "3", "*"},
            {"test3", "Метод sortByPartNumber()", "3", "*"},
            {"test4", "Метод sortByAvailabilityAndNumber()", "3", "*"},
            {"test5", "Метод expiredAfter(instant date)", "3", "*"},
            {"test6", "Метод сountLess(int count)", "3", "*"},
            {"test7", "Метод сountBetween(int count1, int count2)", "3", "*"},
    };

    private static Object[] o1 = new Object[]{"Вода минеральная", "wВ301", 100, 20.00, Instant.now().plus(10, ChronoUnit.DAYS)};
    private static Object[] o2 = new Object[]{"Пиво пенное", "bП201", 100, 100.00, Instant.now().minus(1, ChronoUnit.DAYS)};
    private static Object[] o3 = new Object[]{"Лимонад", "lП101", 50, 50.00, Instant.now().plus(1, ChronoUnit.DAYS)};
    private static Object[] o4 = new Object[]{"Икра заморская", "iИ401", 10, 500.00, Instant.now().minus(2, ChronoUnit.DAYS)};
    private static Object[] o5 = new Object[]{"Мясо свежее", "mМ901", 90, 350.00, Instant.now().plus(2, ChronoUnit.DAYS)};

    private static String introString = "Экземпляр класса был создан при помощи списка объектов типа Goods, содержащего:\n";
    private static String paramString = "\nМетод был вызван с параметр";
    private static String resultString = "\nВозвращен список объектов:\n%s\nОжидалось:\n%s";
    private static DecimalFormat df = new DecimalFormat("#.00");
    private static String olString = objToStr(o1) + "\n" + objToStr(o2) + "\n" + objToStr(o3) + "\n" + objToStr(o4) + "\n" + objToStr(o5);


    // Если надо - инициализация и завершение теста
    @Before
    public void init() {
    }

    @After
    public void done() {
    }

    @Test
    public void test1(){
        String rs = objToStr(o1) + "\n" + objToStr(o4) + "\n" + objToStr(o3) + "\n" + objToStr(o5) + "\n" + objToStr(o2);

        GoodsWithLambda gwl = goodsWithLambda();
        List<Goods> ul = gwl.sortByName();
        String us = listGoodsToStr(ul);

        Assert.assertTrue(introString + olString + String.format(resultString, us, rs), rs.equals(us));
    }

    @Test
    public void test2(){
        String rs = objToStr(o2) + "\n" + objToStr(o4) + "\n" + objToStr(o3) + "\n" + objToStr(o5) + "\n" + objToStr(o1);

        GoodsWithLambda gwl = goodsWithLambda();
        List<Goods> ul = gwl.sortByNumber();
        String us = listGoodsToStr(ul);

        Assert.assertTrue(introString + olString + String.format(resultString, us, rs), rs.equals(us));
    }

    @Test
    public void test3(){
        String rs = objToStr(o2) + "\n" + objToStr(o4) + "\n" + objToStr(o3) + "\n" + objToStr(o5) + "\n" + objToStr(o1);

        GoodsWithLambda gwl = goodsWithLambda();
        List<Goods> ul = gwl.sortByPartNumber();
        String us = listGoodsToStr(ul);

        Assert.assertTrue(introString + olString + String.format(resultString, us, rs), rs.equals(us));
    }

    @Test
    public void test4(){
        String rs = objToStr(o4) + "\n" + objToStr(o3) + "\n" + objToStr(o5) + "\n" + objToStr(o2) + "\n" + objToStr(o1);

        GoodsWithLambda gwl = goodsWithLambda();
        List<Goods> ul = gwl.sortByAvailabilityAndNumber();
        String us = listGoodsToStr(ul);

        Assert.assertTrue(introString + olString + String.format(resultString, us, rs), rs.equals(us));
    }

    @Test
    public void test5(){
        String rs = objToStr(o3) + "\n" + objToStr(o5) + "\n" + objToStr(o1);

        GoodsWithLambda gwl = goodsWithLambda();
        Instant i = Instant.now();
        List<Goods> ul = gwl.expiredAfter(Instant.now());
        String us = listGoodsToStr(ul);

        Assert.assertTrue(introString + olString + paramString + "ом: " + i + String.format(resultString, us, rs), rs.equals(us));
    }

    @Test
    public void test6(){
        String rs = objToStr(o4) + "\n" + objToStr(o3);

        GoodsWithLambda gwl = goodsWithLambda();
        int i = 60;
        List<Goods> ul = gwl.countLess(i);
        String us = listGoodsToStr(ul);

        Assert.assertTrue(introString + olString + paramString + "ом: "  + i + String.format(resultString, us, rs), rs.equals(us));
    }

    @Test
    public void test7(){
        String rs = objToStr(o3) + "\n" + objToStr(o5);

        GoodsWithLambda gwl = goodsWithLambda();
        int i1 = 30;
        int i2 = 100;
        List<Goods> ul = gwl.countBetween(i1, i2);
        String us = listGoodsToStr(ul);

        Assert.assertTrue(introString + olString + paramString + "ами: " + i1 + ", " + i2
                + String.format(resultString, us, rs), rs.equals(us));
    }

    private static GoodsWithLambda goodsWithLambda() {
        Goods g1 = objToGoods(o1);
        Goods g2 = objToGoods(o2);
        Goods g3 = objToGoods(o3);
        Goods g4 = objToGoods(o4);
        Goods g5 = objToGoods(o5);

        List<Goods> gl = Arrays.asList(new Goods[]{g1, g2, g3, g4, g5});
        GoodsWithLambda gwl = new GoodsWithLambda();
        gwl.setGoods(gl);

        return gwl;
    }

    private static Goods objToGoods(Object[] o){
        Goods g = new Goods((String)o[0], (String)o[1], (int)o[2], (double)o[3], (Instant)o[4]);
        return g;
    }

    private static String objToStr(Object[] o){
        return "Наименование: " + (String)o[0] + ", артикул: " +  (String)o[1] + ", количество на складе: "
                + (int)o[2] + ", цена: " + df.format((double)o[3]) + ", срок годности: " + (Instant)o[4];
    }

    private static String goodsToStr(Goods g){
        return "Наименование: " + g.name + ", артикул: " +  g.number + ", количество на складе: "
                + g.available + ", цена: " + df.format(g.price) + ", срок годности: " + g.expired;
    }

    private static String listGoodsToStr(List<Goods> gl){
        String result = "";
        for (Goods g : gl){
            result += goodsToStr(g) + "\n";
        }
        return result.isEmpty() ? "Пустой список" : result.substring(0, result.length() - 1);
    }

    // это обязательная функция, она возвращает данные теста утилите
    public static String[][] getData() {
        return testData;
    }
}
