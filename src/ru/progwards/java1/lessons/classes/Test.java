package ru.progwards.java1.lessons.classes;

import ru.progwards.java1.lessons.interfaces.ArraySort;
import ru.progwards.java1.lessons.interfaces.Number;
import ru.progwards.java1.lessons.interfaces.IntNumber;


public class Test {

	private static int i = 3;
	private static double d = 2.5;
	private static int cubeIntVolume = i * i * i;
	private static double cubeDoubleVolume = d * d * d;
	private static int ballIntVolume = (int)(i * i * i * Math.PI * 4 / 3);
	private static double ballDoubleVolume = d * d * d * Math.PI * 4D / 3D;
	private static Number nInt = new IntNumber(i); 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	
		Number n1 = new IntNumber(5);
		Number n2 = new IntNumber(6);
		Number n3 = new IntNumber(3);
		Number n4 = new IntNumber(4);
		
		Comparable<Number>[] cn = ArraySort.sort(new Number[]{n1, n2, n3, n4});
		
		Number n = (Number) cn[0];

		System.out.print(n.toString());
	}

}
