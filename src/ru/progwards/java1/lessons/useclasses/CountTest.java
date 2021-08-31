package ru.progwards.java1.lessons.useclasses;

public class CountTest {

    public static void testInc(int count){
        Count c = new Count();
        for (int i = 0; i < count; i++){
            c.inc();
            System.out.print(c.getCount() + " ");
            if (i == count - 1) System.out.println();
        }

        System.out.println("тест inc окончен");
    }

    public static void testDec(int count){
        Count c = new Count(count);
        while (true){
            boolean b = c.dec();
            System.out.print(c.getCount() + " ");
            if (b){
                System.out.println();
                if (c.getCount() == 0) System.out.println("count равен 0");
                break;
            }
        }

        System.out.println("тест dec окончен");
    }

    public static void main(String[] args){
        testInc(7);
        testInc(0);
        testInc(-1);
        testDec(9);
        testDec(0);
        testDec(-5);
    }
}
