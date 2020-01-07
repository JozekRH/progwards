package ru.progwards.java1.lessons.queues;

public class Order {
    private double sum;
    private int num = 0;
    private static int order = 1;
    
    public Order(double sum){
        this.sum = sum;
        num = order++;
    }
    
    public double getSum(){
        return this.sum;
    }
    
    public int getNum(){
        return num;
    }
}
