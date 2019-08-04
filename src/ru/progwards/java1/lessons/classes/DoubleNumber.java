package ru.progwards.java1.lessons.classes;

public class DoubleNumber extends Number {

	private double number;
	
	public DoubleNumber(double number) 
	{
		this.number = number;
	}
	
	@Override
	public Number mul(Number n1, Number n2)
	{
		return new DoubleNumber((Double.parseDouble(n1.toString()) * Double.parseDouble(n2.toString())));
	}

	@Override
	public Number div(Number n1, Number n2)
	{
		return new DoubleNumber((Double.parseDouble(n1.toString()) / Double.parseDouble(n2.toString())));
	}

	@Override
	public Number newNumber(String strNum)
	{
		return new DoubleNumber(Double.parseDouble(strNum));
	}

	@Override
	public String toString()
	{
		return number + "";
	}
}
