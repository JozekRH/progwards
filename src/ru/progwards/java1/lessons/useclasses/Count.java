package ru.progwards.java1.lessons.useclasses;

public class Count {

    private int count;

    public Count(){
        this.count = 0;
    }

    public Count(int count){
        this.count = count;
    }

    public int getCount(){
        return this.count;
    }

    public void inc(){
        this.count++;
    }

    public boolean dec(){
        this.count--;
        if (this.count <= 0) return true;
        else return false;
    }

    public static void main(String[] args){
        Count count = new Count(10);
        while (count.dec() == false){}
        System.out.println("count равен 0");
    }
}
