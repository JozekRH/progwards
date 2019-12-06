package ru.progwards.java1.lessons.bitsworld;

public class Binary {

	private int num = 0;
	
	public Binary(byte num) {
        this.num = num;
    }

    @Override
    public String toString() {
        String result = "";

        for (int i = Byte.SIZE - 1; i >= 0; i--) {
            result += (num >> i) & 0b00000001;
        }

        return result;
    }

    public static void main(String[] args) {
        byte a = -128;
        do {
            System.out.println(a + ": " + new Binary(a));
        } while (a++ != 127);
    }
}