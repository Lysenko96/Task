package com.lysenko.generics;

import java.util.ArrayList;

public class Main {
    static class Fruits {

    }

    static class Apple extends Fruits {
        private static int counter;
        private final int id = counter++;

        public int getId() {
            return id;
        }
    }

    static class Orange extends Fruits {
    }

    //@SuppressWarnings("unchecked")
    public static void main(String[] args) {
        ArrayList<Apple> arrayList = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            arrayList.add(new Apple());
        }
        //arrayList.add(new Orange());

      /*  for (int i = 0; i < arrayList.size(); i++) {
            ((Apple)arrayList.get(i)).getId();
        }*/
       /* for (Fruits fruit: arrayList) {
            if(fruit instanceof Apple) {
                System.out.println(((Apple) fruit).getId());
            }
            else
                System.out.println(fruit);*/
        for (Apple a : arrayList) {
            System.out.println(a.getId());
        }
    }
}
