//Задача 3. Класс HanoiTower
package ru.progwards.java2.lessons.recursion;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

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

            {"task3", "Задача 3. Класс HanoiTower", "26", ""},
            {"test1", "Метод print()", "13", "*"},
            {"test2", "Метод print() с установкой setTrace(true)", "13", "*"},
    };

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream outContent1 = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    private List<LinkedList<Integer>> towers;
    private int size;
    private boolean trace;



    // Если надо - инициализация и завершение теста
    @Before
    public void init() {
    }

    @After
    public void done() {
        System.setOut(originalOut);
    }

    @Test
    public void test1(){
        test(false);
    }
    @Test
    public void test2(){
        test(true);
    }

    private void test(boolean trace){
        for (int size = 3; size <= 4; size++){
            for (int pos = 0; pos <= 2; pos++){
                System.setOut(new PrintStream(outContent));
                HanoiTower ht = new HanoiTower(size, pos);
                ht.setTrace(trace);
                int posTo = pos < 2 ? pos + 1 : 0;
                ht.move(pos, posTo);
                ht.print();
                String us = outContent.toString();

                System.setOut(new PrintStream(outContent1));
                init(size, pos);
                this.trace = trace;
                move(pos, posTo);
                print();
                String rs = outContent1.toString();
                Assert.assertTrue("Экземпляр класса создан с параметрами: " + size + ", " + pos +
                        "\nВызван метод move с параметрами: " + pos + ", " + posTo +
                        "\nВыведено на консоль:\n" + us + "\nОжидалось:\n" + rs, rs.equals(us));
            }
        }
    }

    public void init(int s, int p) {
        size = s;
        trace = false;
        towers = new ArrayList<>(List.of(new LinkedList<>(), new LinkedList<>(), new LinkedList<>()));
        LinkedList<Integer> initTower = towers.get(p);
        for(int i = size; i >= 1; i--) {
            initTower.push(i);
        }
    }


    private void move(int from, int to) {
        movePartOfTower(size, from, to);
    }

    private void movePartOfTower(int towerSize, int from, int to) {
        if(towerSize == 1) {
            towers.get(to).push(towers.get(from).pop());
            if(trace) print();
        } else {
            int tmpPin = 3 - from - to;
            movePartOfTower(towerSize-1, from, tmpPin);
            movePartOfTower(1, from, to);
            movePartOfTower(towerSize-1, tmpPin, to);
        }
    }

    public void print() {
        StringBuilder[] floors = new StringBuilder[size];
        for(int i = 0; i < size; i++) {
            floors[i] = new StringBuilder();
        }
        for(LinkedList<Integer> tower : towers) {
            Iterator<Integer> iterator = tower.descendingIterator();
            // здесь нумерация этажей башни снизу вверх; нижний этаж имеет номер 0; верхний имеет номер size-1
            int floorNumber = size-1;
            while(iterator.hasNext()) {
                int ringSize = iterator.next();
                if(floors[floorNumber].length() == 0) {
                    floors[floorNumber].append("<");
                } else {
                    floors[floorNumber].append(" <");;
                }
                String ringStr = Integer.toString(ringSize);
                if(ringStr.length() == 1){
                    floors[floorNumber].append("00");
                }
                if(ringStr.length() == 2){
                    floors[floorNumber].append("0");
                }
                floors[floorNumber].append(ringSize);
                floors[floorNumber].append(">");
                floorNumber--;
            }
            while(floorNumber >= 0) {
                if(floors[floorNumber].length() == 0) {
                    floors[floorNumber].append("  I  ");
                } else {
                    floors[floorNumber].append("   I  ");;
                }
                floorNumber--;
            }
        }
        for(StringBuilder floor : floors) {
            System.out.println(floor);
        }
        System.out.println("=================");
    }



    // это обязательная функция, она возвращает данные теста утилите
    public static String[][] getData() {
        return testData;
    }
}
