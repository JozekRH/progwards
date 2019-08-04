package ru.progwards.java1.lessons.classes;

public class Animal {

	public enum AnimalKind {ANIMAL, COW, HAMSTER, DUCK};
	public enum FoodKind {UNKNOWN, HAY, CORN};
	private double weight;

	public Animal(double weight)
	{
		this.weight = weight;
	}

	public AnimalKind getKind()
	{
		return AnimalKind.ANIMAL;
	}
	
	public FoodKind getFoodKind()
	{
		return FoodKind.UNKNOWN;
	}
	
	public String toString()
	{
		return "I am " + getKind() + ", eat " + getFoodKind() + " " + calculateFoodWeight(); 
	}

	public double getWeight()
	{
		return weight;
	}
	
	public double getFoodCoeff()
	{
		return 0.02;
	}
	
	public double calculateFoodWeight()
	{
		return weight * getFoodCoeff();
	}
}
