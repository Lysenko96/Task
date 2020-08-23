package com.lysenko.collections.lists.listiterator;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class LinkedListMain {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        Random random = new Random(47);
        for (int i = 0; i < 10; i++) {
            list.add(0);
        }
        for (int i = 0; i < list.size(); i++) {
            if (i < list.size() - 1) {
                System.out.print(list.get(i) + " ");
            } else {
                System.out.print(list.get(i));
            }
        }
        System.out.println();
        ListIterator<Integer> it = list.listIterator(5);
        while (it.hasNext()) {
            it.next();
            it.set(random.nextInt(10));
        }
        while (it.hasPrevious()) {
            it.previous();
            it.set(random.nextInt(10));
        }
        for (int i = 0; i < list.size(); i++) {
            if (i < list.size() - 1) {
                System.out.print(list.get(i) + " ");
            } else {
                System.out.print(list.get(i));
            }
        }
    }
}
