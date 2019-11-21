package ru.progwards.java1.lessons.register2;

public class Bit {

    private boolean bit;

    public Bit() {
        bit = false;
    }

    public Bit(boolean value) {
        bit = value;
    }

    public void set(boolean value) {
        bit = value;
    }

    public boolean get() {
        return bit;
    }

    public String toString() {
        return bit ? "1" : "0";
    }

    //lalala
}