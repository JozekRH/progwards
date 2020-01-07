package ru.progwards.java1.lessons.queues;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class StackCalc {

    private Queue<Double> q = new LinkedList<>();

    public void push(double value){
        Collections.reverse((LinkedList<Double>)q);
        q.add(value);
        Collections.reverse((LinkedList<Double>)q);
    }
    
    public double pop(){
        return q.poll();
    }
    
    public void add(){
        push(pop() + pop());
    }
    
    public void sub(){
        push(pop() - pop());
    }
    
    public void mul(){
        push(pop() * pop());
    }
    
    public void div(){
        push(pop() / pop());
    }
}
