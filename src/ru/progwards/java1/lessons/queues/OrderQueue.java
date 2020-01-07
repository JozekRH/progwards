package ru.progwards.java1.lessons.queues;

import java.util.LinkedList;
import java.util.Queue;

public class OrderQueue {

    private Queue<Order> q1 = new LinkedList<>();
    private Queue<Order> q2 = new LinkedList<>();
    private Queue<Order> q3 = new LinkedList<>();
    
    public void add(Order order){
        if (order == null) return;
        
        if (order.getSum() < 20000)
            q1.add(order);
        else if (order.getSum() < 10000)
            q2.add(order);
        else 
            q3.add(order);
    }
    
    public Order get(){
        
        Order result = q1.poll();
        if (result == null)
            result = q2.poll();
        if (result == null)
            result = q3.poll();
        
        return result;
    }
}
