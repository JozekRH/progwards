package ru.progwards.java1.lessons.classes;

public class Animal {

	public enum AnimalKind {ANIMAL, COW, HAMSTER, DUCK};
	public enum FoodKind {UNKNOWN, HAY, CORN};
	private AnimalKind animalKind = AnimalKind.ANIMAL;
	private FoodKind foodKind = FoodKind.UNKNOWN;
	private double weight = 1D;

	public Animal()
	{
		
	}
	
	public Animal(double weight)
	{
		this.weight = weight;
	}

	public AnimalKind getKind()
	{
		return this.animalKind;
	}
	
	public FoodKind getFoodKind()
	{
		return this.foodKind;
	}
	
	public String toString()
	{
		return "I am " + this.animalKind.toString() + ", eat " + this.foodKind.toString() + " " + calculateFoodWeight(); 
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
