package ru.progwards.java1.lessons.compare;

public class Divisibility {

    public static void check(int num1, int num2){
        if(num2 == 0 ){
            System.out.println("На ноль делить нельзя");
            return;
        }

        int mod = num1 % num2;
        double div = (double)num1 / (double)num2;

        if (mod == 0) System.out.println(num1 + " делится нацело на " + num2);
        else System.out.println("Остаток от деления " + num1 + " на " + num2 + " равен " + mod);

        System.out.println("Частное от деления " + num1 + " на " + num2 +" равно " + div);
    }
}
