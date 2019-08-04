package ru.progwards.java1.lessons.interfaces;

public class ArraySort {

	public static Comparable<Number>[] sort(Comparable<Number>[] a)
	{
		for (int i = 0; i < a.length; i++)
		{
			for (int j = i + 1; j < a.length; j++)
			{
				if (a[i].compareTo((Number) a[j]) > 0)
				{
					Comparable<Number> n = a[j];
					a[j] = a[i];
					a[i] = n;
				}
			}
		}
		
		return a;
	}
}
