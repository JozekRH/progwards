package ru.progwards.java1.lessons.wrappers;

public class NumMetrics {

    public static Integer sumDigits(Integer number){
        if (number == null) return null;
        Integer sum = 0;
        while(number != 0){
            sum += (number % 10);
            number /= 10;
        }
        return sum;
    }

    public static Integer mulDigits(Integer number){
        if (number == null) return null;
        Integer mul = 1;
        while(number != 0){
            mul *= (number % 10);
            number /= 10;
        }
        return mul;
    }

}
