package ru.progwards.java1.lessons.classescompare;

public abstract class Animal {

	private String name;
	private double weight;
	public enum FoodKind {HAY, CORN};


	public Animal(String name)
	{
		this.name = name;
	}

	public void setWeight(double weight)
	{
		this.weight = weight;
	}

	public abstract String kind();
	
	public abstract String say();

	public abstract FoodKind getFoodKind();

	public abstract double getFoodCoeff();

	public double calculateFoodWeight(){
		return getWeight() * getFoodCoeff();
	}

	public double calculateFoodPrice(){
		int price = 2;
		if (getFoodKind() == FoodKind.CORN) price = 15;
		return calculateFoodWeight() * price;
	}

	public double getWeight()
	{
		return weight;
	}


	public int compareTo(Animal animal){
		if (this.weight < animal.getWeight()) return -1;
		else if (this.weight > animal.getWeight()) return 1;
		else return 0;
	}

	public boolean equals(Object o){
		try{
			Animal animal = (Animal)o;
			if (this.name.equals(animal.name) && this.kind().equals(animal.kind()) && this.weight == animal.weight)
				return true;

		}catch(Exception e){}

		return false;
	}


    public String toString()
    {
        return "Это " + kind() + " " + name;
    }
}
