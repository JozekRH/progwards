package ru.progwards.java1.lessons.cycles;

public class GoldenFibo {

    public static int fiboNumber(int n) {
        int a = 1;
        int fibo = 0;
        int counter = 0;

        while (counter++ < n) {
            int a1 = a;
            a = fibo;
            fibo += a1;
        }

        return fibo;
    }

    private static boolean isGoldenRatio(int side, int base) {
        double ratio = (double)side / base;

        return 1.61703 < ratio && ratio < 1.61903;
    }

    public static boolean isGoldenTriangle(int a, int b, int c) {
        if (a == b) {
            // основание c
            if (isGoldenRatio(a, c))
                return true;
        } else if (b == c) {
            // основание a
            if (isGoldenRatio(b, a))
                return true;
        } else if (a == c) {
            // основание b
            if (isGoldenRatio(a, b))
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 15; i++) {
            System.out.print(fiboNumber(i) + (i == 15 ? System.lineSeparator() : ","));
        }

        int m = 1;
        int n = fiboNumber(m);
        while (n <= 100) {
            if (isGoldenTriangle(n, n, fiboNumber(m + 1))){
                System.out.println(n + "," + n + "," +  fiboNumber(m + 1));
            }
            n = fiboNumber(m++);
        }
    }


}


