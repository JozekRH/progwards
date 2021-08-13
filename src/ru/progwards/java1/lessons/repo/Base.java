package ru.progwards.java1.lessons.repo;

public class Base {
    public static final String X_EQUALS = "x = ";
    public static final String Y_EQUALS = "y = ";
    public static final String A_EQUALS = "a = ";
    public static final String B_EQUALS = "b = ";
    public static final String C_EQUALS = "c = ";

    public static int subtraction(int x, int y) {
        System.out.println("Вызвана функция subtraction() с параметрами " + X_EQUALS + x + ", " + Y_EQUALS + y);
        return  x - y;
    }

    public static int addition(int x, int y) {
        System.out.println("Вызвана функция addition() с параметрами " + X_EQUALS + x + ", " + Y_EQUALS + y);
        return  x + y;
    }

    public static int multiplication(int x, int y) {
        System.out.println("Вызвана функция multiplication() с параметрами " + X_EQUALS + x + ", " + Y_EQUALS + y);
        return  x * y;
    }

    public static void calculation() {
        int a, b, c;
        a = 34;
        b = 55;

        System.out.println(A_EQUALS + a);
        System.out.println(B_EQUALS + b);

        c = addition(a, b);
        System.out.println("a + b = " + c);

        c = subtraction(a, b);
        System.out.println("a - b = " + c);

        c = multiplication(a, b);
        System.out.println("a * b = " + c);
    }

    public static void calculation(int a, int b, int c) {
        System.out.print("Вызвана функция calculation() с параметрами ");
        System.out.print(A_EQUALS + a + ", ");
        System.out.print(B_EQUALS + b + ", ");
        System.out.println(C_EQUALS + c);

        System.out.println("a + b + c = " + addition(addition(a, b), c));
        System.out.println("a^3 = " + multiplication(multiplication(a, a), a));
        System.out.println("a - (b + c^2) = " + subtraction(a, addition(b, multiplication(c, c))));
    }

    public static void main(String[] args) {
        //- вызвать функцию substruction() c параметрами 45 и 12
        subtraction(45, 12);
        //- вызвать функцию substruction() c параметрами 23 и 55
        subtraction(23, 55);
        //- вызвать функцию addition() c параметрами 128 и 787
        addition(128, 787);
        //- вызвать функцию addition() c параметрами 528 и 387
        addition(528, 387);
        //- вызвать функцию multiplication() c параметрами 124 и 87
        multiplication(124, 87);
        //- вызвать функцию multiplication() c параметрами 1528 и 3
        multiplication(1528, 3);
        //- вызвать функцию calculation() без параметров
        calculation();
        //- вызвать функцию calculation() c параметрами 11, 25 и 410
        calculation(11, 25, 410);
        //- вызвать функцию calculation() c параметрами 100, 9 и 98
        calculation(100, 9, 98);
    }
}