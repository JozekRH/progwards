package ru.progwards.java1.lessons.arrays;

public class DIntArray {

	private int[] arr = new int[]{};
	
	public DIntArray()
	{
	}
	
	public void add(int num)
	{
		int[] newarr = new int[arr.length + 1];
		for (int i = 0; i < arr.length; i++)
		{
			newarr[i] = arr[i];
		}
		newarr[newarr.length - 1] = num;
		arr = newarr;
	}

	public void atInsert(int pos, int num)
	{
		int[] newarr = new int[arr.length + 1];
		for (int i = 0; i < newarr.length; i++)
		{
			if (i < pos) newarr[i] = arr[i];
			else if (i == pos) newarr[i] = num;
			else if (i > pos) newarr[i] = arr[i - 1];
		}
		arr = newarr;
	}
	
	public void atDelete(int pos)
	{
		int[] newarr = new int[arr.length - 1];
		for (int i = 0; i < arr.length; i++)
		{
			if (i < pos) newarr[i] = arr[i];
			else if (i > pos) newarr[i - 1] = arr[i];
		}
		arr = newarr;
	}
	
	public int at(int pos)
	{
		return arr[pos];
	}
	
	public int[] getArray()
	{
		return arr;
	}
	
}
