package ru.progwards.java1.lessons.interfaces;

public class Animal implements FoodCompare{

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
	
	public boolean equals(Object o)
	{
		try
		{
			Animal a = (Animal)o;
			if (this.getWeight() == a.getWeight())
			{
				if (this.getKind() == a.getKind())
				{
					return true;
				}
			}
		}
		catch (Exception e){}
		
		return false;
	}
	
	public double getFood1kgPrice()
	{
		switch (getFoodKind())
		{
			case HAY:
				return 20D;
			case CORN:
				return 50D;
			case UNKNOWN:
				return 0D;
		}
		return 0D;
	}
	
	public double getFoodPrice()
	{
		return calculateFoodWeight() * getFood1kgPrice();
	}

	@Override
	public int сompareFoodPrice(Animal o) {
		return Double.compare(this.getFoodPrice(), o.getFoodPrice());
	}
}
