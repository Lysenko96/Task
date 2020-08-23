package com.lysenko.collections.lists.iterator;

import java.util.*;

public class SequenceIterator {
    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        Random random = new Random(47);
        for (int i = 0; i < 10; i++) {
            list.add(random.nextInt(47));
        }
        SequenceIterator.Sequence.hop(list);

    }
     static class Sequence{
        private static List<Object> objects;
        static void hop(List<Object> list){
            Sequence.objects = list;
            Iterator it = objects.iterator();
            while(it.hasNext()){
                Object object = it.next();
                if(!it.hasNext()) {
                    System.out.print(object);
                } else {
                    System.out.print(object + " ");
                }
            }
        }
    }
}

