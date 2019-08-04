package ru.progwards.java1.lessons.classes;

public class IntNumber extends Number {

	private int number;
	
	public IntNumber(int number) 
	{
		this.number = number;
	}
	
	@Override
	public Number mul(Number n1, Number n2)
	{
		return new IntNumber((Integer.parseInt(n1.toString()) * Integer.parseInt(n2.toString())));
	}

	@Override
	public Number div(Number n1, Number n2)
	{
		return new IntNumber((Integer.parseInt(n1.toString()) / Integer.parseInt(n2.toString())));
	}

	@Override
	public Number newNumber(String strNum)
	{
		try
		{
			return new IntNumber(Integer.parseInt(strNum));
		}
		catch (Exception e)
		{
			return new IntNumber((int)Double.parseDouble(strNum));
		}
	}
	
	@Override
	public String toString()
	{
		return number + "";
	}
	
}
