package com.lysenko.collections.stack;

import java.util.LinkedList;

public class MyStack<T> {
    private LinkedList<T> storage = new LinkedList<>();

    public void push(T obj) {
        storage.addFirst(obj);
    }

    public T peek() {
        return storage.getFirst();
    }

    public T pop() {
        return storage.removeFirst();
    }

    boolean isEmpty() {
        return storage.isEmpty();
    }

    @Override
    public String toString() {
        return storage.toString();
    }
}
