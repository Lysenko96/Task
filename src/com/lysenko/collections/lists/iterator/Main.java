package com.lysenko.collections.lists.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Pets> pets = Pets.arrayList(12);
        hop(pets);
    }

    private static void hop(List<Pets> pets) {
        Iterator<Pets> it = pets.iterator();
        while (it.hasNext()) {
            Pets pet = it.next();
            System.out.println(pet);
        }
    }

    static class Pets {
        static ArrayList<Pets> arrayList(int size) {
            ArrayList<Pets> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                list.add(new Pets());
            }
            return list;
        }
    }
}
