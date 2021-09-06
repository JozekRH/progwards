package ru.progwards.java1.lessons.inheritance;

public class Hamster extends Animal {

	public Hamster(String name) {
		super(name);
	}

	@Override
	public String kind() {
		return "хомяк";
	}

	@Override
	public String say() {
		return "хрум-хрум-хрум";
	}
}
