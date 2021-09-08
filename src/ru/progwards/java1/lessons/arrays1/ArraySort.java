package ru.progwards.java1.lessons.arrays1;

public class ArraySort {

	public static void sort(int[] a)
	{
		for (int i = 0; i < a.length; i++)
		{
			for (int j = i + 1; j < a.length; j++)
			{
			    if (a[i] > a[j])
				{
					int n = a[j];
					a[j] = a[i];
					a[i] = n;
				}
			}
		}
	}
}
