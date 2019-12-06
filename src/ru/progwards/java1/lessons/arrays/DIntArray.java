package ru.progwards.java1.lessons.arrays;

import java.util.Arrays;

public class DIntArray {

    public int[] set = {};


    DIntArray() {
    }

    public void add(int num) {
        int[] temp = Arrays.copyOf(set, set.length + 1);
        set = temp;
        set[set.length - 1] = num;
        System.out.println(Arrays.toString(set));
    }

    public void atInsert(int pos, int num) {
        int[] temp = new int[set.length + 1];
        System.arraycopy(set, 0, temp, 0, pos - 1);
        temp[pos - 1] = num;
        System.arraycopy(set, pos - 1, temp, pos, (set.length - pos + 1));
        set = temp;
        System.out.println(Arrays.toString(set));
    }

    public void atDelete(int pos) {
        int[] temp = new int[set.length - 1];
        System.arraycopy(set, 0, temp, 0, pos - 1);
        System.arraycopy(set, pos, temp, pos, (set.length - pos));
        set = temp;
        System.out.println(Arrays.toString(set));
    }

    public int at(int pos) {
        System.out.println(set[pos-1]);
        return set[pos-1];
    }


    public static void main(String[] args) {
        DIntArray arr = new DIntArray();
        arr.add(-5);
        arr.add(5);
        arr.add(4);
        arr.add(7);
        arr.add(8);
        arr.add(23);
        arr.add(-54);
        arr.add(0);
        arr.add(40);
        arr.atInsert(2, 6);
        arr.at(2);
    }

}
