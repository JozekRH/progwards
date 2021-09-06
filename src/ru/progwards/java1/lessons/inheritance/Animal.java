package ru.progwards.java1.lessons.inheritance;

public abstract class Animal {

	private String name;

	public Animal(String name)
	{
		this.name = name;
	}

	public abstract String kind();
	
	abstract public String say();

    public String toString()
    {
        return "Это " + kind() + " " + name;
    }
}
