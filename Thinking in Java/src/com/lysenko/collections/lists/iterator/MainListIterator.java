package com.lysenko.collections.lists.iterator;

import java.util.*;

public class MainListIterator {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        Random random = new Random(47);
        for (int i = 0; i < 10; i++) {
            integerList.add(random.nextInt(30));
        }
        List<Integer> list = new ArrayList<>(integerList.size());
        ListIterator<Integer> it = integerList.listIterator(10);
        while (it.hasPrevious()){
            Integer i = it.previous();
            list.add(i);
        }
        for (int i = 0; i < integerList.size(); i++) {
            if(i == integerList.size()-1){
                System.out.print(integerList.get(i));
            } else {
                System.out.print(integerList.get(i) + " ");
            }
        }
        System.out.println();
        for (int i = 0; i < list.size(); i++) {
            if(i == integerList.size()-1){
                System.out.print(list.get(i));
            } else {
                System.out.print(list.get(i) + " ");
            }
        }
    }

}
