package com.lysenko.collections;

import java.util.ArrayList;

interface ISelector{
    boolean end();
    Object current();
    void next();
}

public class Sequence {
private static ArrayList<Object> items;
private int next = 0;
public Sequence() {
    items = new ArrayList<>();
}
public void add(Object obj){
        items.add(next++,obj);
}
private static class SequenceSelector implements ISelector{
    private int i = 0;
    public boolean end(){
        return i == items.size();
    }
    public Object current(){
        return items.get(i);
    }
    public void next(){
        if(i < items.size())
            i++;
    }
}
    public ISelector iSelector(){
        return new SequenceSelector();
    }

    public static void main(String[] args) {
        Sequence sequence = new Sequence();
        for (int i = 0; i < 17; i++) {
            sequence.add(Integer.toString(i));
        }
        ISelector selector = sequence.iSelector();
        while (!selector.end()){
            System.out.print(selector.current() + " ");
            selector.next();
        }
    }
}
