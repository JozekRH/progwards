package ru.progwards.java1.lessons.interfaces;

public abstract class Number implements Comparable<Number>{

	public Number mul(Number n1, Number n2)
	{
		return null;
	}

	public Number div(Number n1, Number n2)
	{
		return null;
	}

	public Number newNumber(String strNum)
	{
		return null;
	}
	
	@Override
	public abstract int compareTo(Number o);
}
