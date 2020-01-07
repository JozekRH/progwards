package ru.progwards.java1.lessons.queues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class CollectionsSort {

    public static void mySort(Collection<Integer> data){
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {}

        Collections.sort((ArrayList<Integer>) data);
    }
    
    static void collSort(Collection<Integer> data){
        Collections.sort((ArrayList<Integer>)data);
    }
    
    public static Collection<String> compareSort(){

        return Arrays.asList(new String[]{"collSort", "mySort"});
    }
}
