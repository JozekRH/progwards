package ru.progwards.java1.lessons.basics;

public class Wrappers {
    public static int sumStringNumbers(String numStr1, String numStr2) {
        int num1 = Integer.parseInt(numStr1);
        int num2 = Integer.parseInt(numStr2);

        int sum = num1 + num2;

        return sum;
    }

    public static String sumInDecString(String numStr1, String numStr2) {
        int sum = sumStringNumbers(numStr1, numStr2);
        return Integer.toString(sum);
    }

    public static String sumInBinString(String numStr1, String numStr2) {
        int sum = sumStringNumbers(numStr1, numStr2);
        return Integer.toBinaryString(sum);
    }

    public static String sumInOctalString(String numStr1, String numStr2) {
        int sum = sumStringNumbers(numStr1, numStr2);
        return Integer.toOctalString(sum);
    }

    public static String sumInHexString(String numStr1, String numStr2) {
        int sum = sumStringNumbers(numStr1, numStr2);
        return Integer.toHexString(sum);
    }

    public static String sumInRadixString(String numStr1, String numStr2, int radix) {
        int sum = sumStringNumbers(numStr1, numStr2);
        return Integer.toString(sum, radix);
    }


    public static void main(String[] args) {
        System.out.println(sumInDecString("55500", "55"));
        System.out.println(sumInBinString("55554", "1"));
        System.out.println(sumInOctalString("55552", "3"));
        System.out.println(sumInHexString("55550", "5"));
        System.out.println(sumInRadixString("55550", "5", 12));
    }
}
