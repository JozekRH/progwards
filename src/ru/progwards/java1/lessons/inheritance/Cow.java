package ru.progwards.java1.lessons.inheritance;

public class Cow extends Animal {

	public Cow(String name) {
		super(name);
	}

	@Override
	public String kind() {
		return "корова";
	}

	@Override
	public String say() {
		return "мууууууу";
	}
}
