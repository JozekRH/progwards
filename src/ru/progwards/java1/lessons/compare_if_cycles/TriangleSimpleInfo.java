package ru.progwards.java1.lessons.compare_if_cycles;

public class TriangleSimpleInfo<a> {
    /*
  //--------------------------------------------------
  //
  */
    /*1.1 Реализовать функцию
    public static int maxSide(int a, int b, int c),
    которая получает параметрами длины сторон треугольника,
    а вернуть должна наибольшую длину стороны. */
    public static int maxSide(int a,int b,int c) {
        int inputArray[] = {a, b, c};
        //int instValue;
        int maxValue = inputArray[0];
        for (int i = 1; i < inputArray.length; i++)
        {    //instValue = inputArray[i];
            if (inputArray[i] > maxValue)
            {
                maxValue = inputArray[i];
            }
        }
        
    int iii = new Integer(1);
    
    boolean result111 = switch(iii) {
        case 1 -> true;
        default -> false;
    };
        
        
        return maxValue;
    }
    /*1.2 Реализовать функцию
    public static int minSide(int a, int b, int c),
    которая получает параметрами длины сторон треугольника,
    а вернуть должна наименьшую длину стороны.*/
    public static int minSide(int a, int b, int c)
    {
        int inputArray[] = {a, b, c};
        //int instValue;
        int minValue = inputArray[0];
        for (int i = 1; i < inputArray.length; i++)
        {    //instValue = inputArray[i];
            if (inputArray[i] < minValue)
            {
                minValue = inputArray[i];
            }
        }
        return minValue;
    }
    /*1.3 Реализовать функцию
    public static boolean isEquilateralTriangle(int a, int b, int c),
    которая получает параметрами длины сторон треугольника,
    а вернуть должна true, если треугольник равносторонний и
   false в противном случае.*/
    public static boolean isEquilateralTriangle(int a, int b, int c)
    {
        boolean equal;
        if ((a==b)&(b==c)){ equal=true;}
        else
            {
              equal=false;
            }
        return equal;
    }



    public static void main(String[] args) {
        System.out.println("Maximum Value is: "+ maxSide(2,6,3));
        System.out.println("minimum Value is: "+ minSide(5,7,4));
        System.out.println("equal Value is: "+ isEquilateralTriangle(5,5,5));
    }
}
