package ru.progwards.java1.lessons.register2;

public class Bit {

	private boolean value = false;
	
	public Bit() {
	}

	public Bit(boolean value) {
		this.value = value;
	}
	
	@Override
	public String toString(){
		return this.value ? "1" : "0";
	}
}
